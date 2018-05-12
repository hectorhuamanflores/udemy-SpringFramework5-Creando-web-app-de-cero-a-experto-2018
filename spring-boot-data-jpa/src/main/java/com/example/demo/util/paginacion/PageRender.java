package com.example.demo.util.paginacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	
	private String url;
	private Page<T> page;
	
	private int totalPaginas;
	private int numElementosPorPagina;
	private int paginaActual;
	
	private List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		this.numElementosPorPagina = page.getSize();
		this.totalPaginas = page.getTotalPages();
		this.paginaActual = page.getNumber()+1;
		int desde,hasta;
		if(totalPaginas <= numElementosPorPagina){
			desde = 1;
			hasta = totalPaginas;
		}else{
			if(paginaActual<=numElementosPorPagina/2){
				desde=1;
				hasta=numElementosPorPagina;
			}else if(paginaActual >= totalPaginas - numElementosPorPagina/2){
				desde= totalPaginas - numElementosPorPagina + 1;
				hasta= numElementosPorPagina;
			}else{
				desde=paginaActual-numElementosPorPagina/2;
				hasta=numElementosPorPagina;
			}
		}
		for(int i=0;i<hasta;i++){
			paginas.add(new PageItem(desde+i,paginaActual == desde+i ));
		}
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}
	public boolean isFirst(){  //si es primera página
		return page.isFirst();
	}
	public boolean isLast(){ // si es la ultima página
		return page.isLast();
	}
	public boolean isHasNext(){ // si tiene siguiente
		return page.hasNext();
	}
	public boolean isHasPrevious(){ // si tiene una página anterior
		return page.hasPrevious();
	}
}
