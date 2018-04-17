package com.bolsadeideas.springboot.app.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private List<PageItem> paginas;
	
	private String url;
	private Page<T> page;
	
	private int totalPaginas;
	private int pageSize;
	private int actualPage;
	
	public PageRender(String url, Page<T> page)
	{
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		
		pageSize = page.getSize();
		totalPaginas = page.getTotalPages();
		actualPage = page.getNumber() + 1;
		
		int desde, hasta;
		
		if(totalPaginas <= pageSize)
		{
			desde = 1;
			hasta = totalPaginas;
		}
		else if(actualPage <= pageSize/2)
		{
			desde = 1;
			hasta = pageSize; 
		} else if (actualPage >= totalPaginas - pageSize/2)
		{
			desde = totalPaginas - pageSize + 1;
			hasta = pageSize;
		} else
		{
			desde = actualPage - pageSize/2;
			hasta = pageSize;
		}
		
		for (int i=0; i < hasta; i++)
		{
			paginas.add(new PageItem(desde + i, actualPage == desde + i));
		}
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getActualPage() {
		return actualPage;
	}
	
	public boolean isFirst()
	{
		return page.isFirst();
	}
	
	public boolean isLast()
	{
		return page.isLast();
	}
	
	public boolean isHasNext()
	{
		return page.hasNext();
	}
	
	public boolean isHasPrevious()
	{
		return page.hasPrevious();
	}
}
