package com.crud.serviceImpl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crud.entidad.Usuario;
import com.crud.exepciones.CrudExepciones;
import com.crud.exepciones.ResourceNotFoundExepcion;
import com.crud.repository.IUsuarioRepository;
import com.crud.service.IUsuarioService;

@Service
@Transactional
public class UsuarioImpl implements IUsuarioService{
	
	@Autowired(required = true)
	private IUsuarioRepository usuarioRepository;

	@Override
	public void guardarUsuario(Usuario usuario) {
		boolean usuarios = usuarioRepository.findById(usuario.getDocumento()).isPresent();
		
		if (usuarios == true) {
			throw new CrudExepciones(HttpStatus.BAD_REQUEST, "El usuario ya existe con este documento");
		}
		
		boolean valiCorreo = validarCorreo(usuario.getCorreo());
		boolean valiTelefono = validarTelefono(usuario.getTelefono());
		
		if (valiCorreo == false){
			throw new CrudExepciones(HttpStatus.BAD_REQUEST, "el correo es invalido");
		}
		else if (valiTelefono == false){
			throw new CrudExepciones(HttpStatus.BAD_REQUEST, "el telefono es invalido");
		}
		else if(usuario.getDocumento() == 0 || usuario.getNombre() == "" || usuario.getApellido() == "" || usuario.getTelefono() == "") {
			throw new CrudExepciones(HttpStatus.NOT_FOUND, "Llene todo los campos");
		}
		else {			
			usuarioRepository.save(usuario);
		}
	
	}
	
	@Override
	public List<Usuario> obtenerTodosLosUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}

	@Override
	public Usuario buscarDocumento(Long documento) {
		Usuario usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourceNotFoundExepcion("usuario", "documento", documento));
		return usuario;
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario, Long documento) {
		Usuario usuarios = usuarioRepository.findById(documento).orElseThrow(() -> new ResourceNotFoundExepcion("usuario", "documento", documento));
		
		usuarios.setNombre(usuario.getNombre());
		usuarios.setApellido(usuario.getApellido());
		usuarios.setTelefono(usuario.getTelefono());
		
		boolean valiCorreo = validarCorreo(usuario.getCorreo());
		boolean valiTelefono = validarTelefono(usuario.getTelefono());
		
		if (valiCorreo == false){
			throw new CrudExepciones(HttpStatus.BAD_REQUEST, "el correo es invalido");
		}
		else if (valiTelefono == false){
			throw new CrudExepciones(HttpStatus.BAD_REQUEST, "el telefono es invalido");
		}
		else if(usuario.getNombre() == "" || usuario.getApellido() == "" || usuario.getTelefono() == "") {
			throw new CrudExepciones(HttpStatus.NOT_FOUND, "Llene todo los campos");
		}
		else {			
			usuarios.setCorreo(usuario.getCorreo());	
			Usuario usuarioActualizado = usuarioRepository.save(usuarios);
			return usuarioActualizado;
		}
		
	}

	@Override
	public void eliminarUsuario(Long documento) {
		Usuario usuarios = usuarioRepository.findById(documento).orElseThrow(() -> new ResourceNotFoundExepcion("usuario", "documento", documento));
		usuarioRepository.delete(usuarios);
	}
	
	public boolean validarCorreo(String correo){
		Pattern patron = Pattern.compile("^(\\w+[/./-]?){1,}@[a-z]+[/.]\\w{2,}$");
		Matcher comparador = patron.matcher(correo);
		
		if (comparador.find() == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean validarTelefono(String telefono){
		Pattern patron = Pattern.compile("^\\d{10,10}$");
		Matcher comparador = patron.matcher(telefono);
		
		if (comparador.find() == true) {
			return true;
		}
		else {
			return false;
		}
	}
}
