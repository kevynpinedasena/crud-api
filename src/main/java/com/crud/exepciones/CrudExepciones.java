package com.crud.exepciones;

import org.springframework.http.HttpStatus;

public class CrudExepciones extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private HttpStatus estados;
	private String mensaje;
	
	public CrudExepciones(HttpStatus estados, String mensaje) {
		super(String.format(mensaje, estados));
		this.estados = estados;
		this.mensaje = mensaje;
	}
	
	public CrudExepciones(HttpStatus estados, String mensaje, String mensaje1) {
		super();
		this.estados = estados;
		this.mensaje = mensaje;
		this.mensaje = mensaje1;
	}

	public HttpStatus getEstados() {
		return estados;
	}

	public void setEstados(HttpStatus estados) {
		this.estados = estados;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
