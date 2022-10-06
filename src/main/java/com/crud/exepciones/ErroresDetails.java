package com.crud.exepciones;

import java.util.Date;

public class ErroresDetails {

	private Date marcaDeTiemppo;
	private String mensaje;
	private String detalles;
	
	public ErroresDetails(Date marcaDeTiemppo, String mensaje, String detalles) {
		super();
		this.marcaDeTiemppo = marcaDeTiemppo;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}

	public Date getMarcaDeTiemppo() {
		return marcaDeTiemppo;
	}

	public void setMarcaDeTiemppo(Date marcaDeTiemppo) {
		this.marcaDeTiemppo = marcaDeTiemppo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
}
