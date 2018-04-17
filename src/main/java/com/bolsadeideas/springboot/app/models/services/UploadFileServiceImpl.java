package com.bolsadeideas.springboot.app.models.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final static String UPLOADS_PATH = "uploads";

	@Override
	public Resource load(String filename) throws MalformedURLException {
		Path pathPhoto = getPath(filename);
		log.info("pathPhoto: " + pathPhoto);

		Resource recurso = null;

		recurso = new UrlResource(pathPhoto.toUri());
		if (!recurso.exists() || !recurso.isReadable()) {
			throw new RuntimeException("Error: no se puede cargar la imagen: " + pathPhoto.toString());
		}

		return recurso;
	}

	@Override
	public String copy(MultipartFile file) throws IOException {
		//  Path uplPath = Paths.get("src//main//resources//static/uploads");
		// String rootPath = uplPath.toFile().getAbsolutePath();
		// String rootPath = "C://Temp//uploads";
		
		String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path rootPath = getPath(uniqueFileName);

		log.info("rootPath: " + rootPath);
		// byte[] bytes = foto.getBytes();
		// Path completePath = Paths.get(rootPath + "//" + foto.getOriginalFilename());
		// Files.write(completePath, bytes);
		Files.copy(file.getInputStream(), rootPath);

		return uniqueFileName;
	}

	@Override
	public boolean delete(String filename) {
		Path rootPath = getPath(filename);
		File archivo = rootPath.toFile();
		
		if(archivo.exists() && archivo.canRead()){
			if(archivo.delete()) {
				return true;
			}
		}		return false;
	}

	public Path getPath(String filename) {
		return Paths.get(UPLOADS_PATH).resolve(filename).toAbsolutePath();
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_PATH).toFile());		
	}

	@Override
	public void init() throws IOException {
		Files.createDirectories(Paths.get(UPLOADS_PATH));
	}
}
