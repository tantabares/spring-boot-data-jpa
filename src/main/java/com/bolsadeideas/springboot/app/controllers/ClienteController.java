package com.bolsadeideas.springboot.app.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.services.IClienteService;
import com.bolsadeideas.springboot.app.models.services.IUploadFileService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteSrv;

	@Autowired
	private IUploadFileService uploadFileService;

	@RequestMapping(value = "/")
	public String index() {
		return "redirect:/listar";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = new PageRequest(page, 5);

		Page<Cliente> clientes = clienteSrv.findAll(pageRequest);
		PageRender<Cliente> pageRnd = new PageRender<>("/listar", clientes);

		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRnd);
		return "listar";
	}

	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {
		Resource recurso = null;

		try {
			recurso = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Cliente client = clienteSrv.findOne(id);
		if (client == null) {
			flash.addFlashAttribute("danger", "El cliente no existe.");
			return "redirect:/listar";
		}

		model.put("cliente", client);
		model.put("titulo", "Detalle del cliente: " + client.getNombre());

		return "ver";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		model.put("btnstr", "Crear Cliente");
		return "form";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(Map<String, Object> model, @PathVariable(value = "id") Long id, RedirectAttributes flash) {
		Cliente client = null;
		if (id > 0) {
			client = clienteSrv.findOne(id);
			if (client == null) {
				flash.addFlashAttribute("danger", "Cliente no encontrado");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("warning", "Cliente no encontrado");
			return "redirect:/listar";
		}

		model.put("cliente", client);
		model.put("titulo", "Editar Cliente");
		model.put("btnstr", "Confirmar");
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			String titPage = (cliente.getId() != null) ? "Editar Cliente" : "Formulario de Cliente";
			model.addAttribute("titulo", titPage);
			model.addAttribute("btnstr", "Confirmar");
			return "form";
		}

		if (!foto.isEmpty()) {
			if (cliente.getId() != null && cliente.getId() > 0 && cliente.getFoto() != null
					&& cliente.getFoto().length() > 0) {
				uploadFileService.delete(cliente.getFoto());
			}

			String uniqueFileName = null;
			try {
				uniqueFileName = uploadFileService.copy(foto);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			flash.addFlashAttribute("info", "Se ha cargado correctamente el archivo '" + uniqueFileName + "'");
			cliente.setFoto(uniqueFileName);
		}
		String flashMsj = (cliente.getId() != null) ? "Cliente editado con éxito" : "Cliente creado con éxito";
		clienteSrv.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", flashMsj);
		return "redirect:/listar";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			Cliente cliente = clienteSrv.findOne(id);
			clienteSrv.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado con éxito");

			if (uploadFileService.delete(cliente.getFoto())) {
				flash.addFlashAttribute("info", "Foto " + cliente.getFoto() + " eliminada con exito!");
			}
		}
		return "redirect:/listar";
	}
}
