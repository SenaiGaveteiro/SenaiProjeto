package br.gaveteiro.senai.controller;

import java.net.URI;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gaveteiro.senai.dao.TipoUsuarioDao;
import br.gaveteiro.senai.modelo.TipoUsuario;
@CrossOrigin
@RestController
public class TipoUsuarioRestController {
	@Autowired
	TipoUsuarioDao tipoUsuarioDao;
	
	@RequestMapping(value = "/tipo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TipoUsuario> inserir(@RequestBody String strTipoUsuario)
	{
		try {
			JSONObject job = new JSONObject(strTipoUsuario);
			TipoUsuario tipo = new TipoUsuario();
			tipo.setDescricao(job.getString("descricao"));
				
		 tipoUsuarioDao.inserir(tipo);
		 URI location = new URI("/tipo/"+tipo.getIdTipo());
		 return ResponseEntity.created(location).body(tipo);
		 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/tipo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TipoUsuario> listar()
	{
		return tipoUsuarioDao.listar();
	}
	
	@RequestMapping(value = "/tipo/{idTipoUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TipoUsuario> listar(@PathVariable Long idTipoUsuario)
	{
		try {
			TipoUsuario tipo = tipoUsuarioDao.listar(idTipoUsuario);
			return ResponseEntity.ok(tipo); 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/tipo/{idTipoUsuario}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> excluir(@PathVariable Long idTipoUsuario)
	{
			tipoUsuarioDao.excluir(idTipoUsuario);
			return ResponseEntity.noContent().build();
	}
	 
	@RequestMapping(value = "/tipo/{idTipoUsuario}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> alterar(@PathVariable Long idTipoUsuario  ,@RequestBody String strTipoUsuario)
	{
		try {
			JSONObject job = new JSONObject(strTipoUsuario);
			tipoUsuarioDao.alterar(job.getString("descricao"), idTipoUsuario);
			HttpHeaders responseHeader = new HttpHeaders();
			URI location = new URI("/tipo/"+idTipoUsuario);
			responseHeader.setLocation(location);
			return new ResponseEntity<>(responseHeader, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
