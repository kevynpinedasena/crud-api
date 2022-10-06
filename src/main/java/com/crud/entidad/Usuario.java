package com.crud.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@Column(name = "documento_usu", nullable = false)
	private Long documento;
	
	@Column(name = "nombre_usu", nullable = false)
	private String nombre;
	
	@Column(name = "apellido_usu", nullable = false)
	private String apellido;
	
	@Column(name = "telefono_usu", nullable = false)
	private String telefono;
	
	@Column(name = "correo_usu", nullable = false)
	private String correo;

	public Usuario() {
	}

	public Usuario(Long documento, String nombre, String apellido, String telefono, String correo) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
