package com.crud.service;

import java.util.List;

import com.crud.entidad.Usuario;

public interface IUsuarioService {

	void guardarUsuario(Usuario usuario);
	
	List<Usuario> obtenerTodosLosUsuarios();
	
	Usuario buscarDocumento(Long documento);
	
	Usuario actualizarUsuario(Usuario usuario, Long documento);
	
	void eliminarUsuario(Long documento);
}
