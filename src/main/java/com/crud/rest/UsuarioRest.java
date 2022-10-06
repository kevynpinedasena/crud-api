package com.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entidad.Usuario;
import com.crud.service.IUsuarioService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class UsuarioRest {
	
	@Autowired(required = true)
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios(){
		return usuarioService.obtenerTodosLosUsuarios();
	}
	
	@GetMapping("/usuarios/{documento}")
	public ResponseEntity<Usuario> buscarUsuarioPorDocumento(@PathVariable Long documento){
		return ResponseEntity.ok(usuarioService.buscarDocumento(documento));
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario){
		usuarioService.guardarUsuario(usuario);
		return new ResponseEntity<>("Usuario registrado con exito", HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarios/{documento}")
	public ResponseEntity<String> actualizarUsuario(@PathVariable Long documento, @RequestBody Usuario usuario){
		usuarioService.actualizarUsuario(usuario, documento);
		return new ResponseEntity<>("Usuario actualizado con exito", HttpStatus.CREATED);
	}
	
	@DeleteMapping("/usuarios/{documento}")
	public ResponseEntity<String> eliminarUsuario(@PathVariable Long documento){
		usuarioService.eliminarUsuario(documento);
		return new ResponseEntity<>("Usuario Eliminado con exito", HttpStatus.OK);
	}

}
