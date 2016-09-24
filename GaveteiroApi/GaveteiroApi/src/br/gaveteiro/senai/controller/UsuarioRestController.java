package br.gaveteiro.senai.controller;

import java.net.URI;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.gaveteiro.senai.dao.UsuarioDao;
import br.gaveteiro.senai.modelo.Usuario;

@RestController
public class UsuarioRestController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Transactional
	@RequestMapping(value = "/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Usuario>  inserir(@RequestBody String strUsuario)
	{
		try 
	 {
			JSONObject job = new JSONObject(strUsuario);
			Usuario usuario = new Usuario();
			usuario.setNome(job.getString("nome"));
			usuario.setEmail(job.getString("email"));
			usuario.setCpf(job.getString("cpf"));
			usuario.setRg(job.getString("rg"));
			usuario.setLogin(job.getString("login"));
			usuario.setSenha(job.getString("senha"));
			usuario.setSexo(job.getString("sexo").charAt(0));
			usuario.setTelefone(job.getString("telefone"));
			
			usuarioDao.inserir(usuario);
			URI location = new URI("/usuario/"+usuario.getIdUsuario());
			return ResponseEntity.created(location).body(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
