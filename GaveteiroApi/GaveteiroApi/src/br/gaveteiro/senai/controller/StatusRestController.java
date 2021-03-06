package br.gaveteiro.senai.controller;
 
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gaveteiro.senai.dao.StatusDao;
import br.gaveteiro.senai.modelo.Status;
@CrossOrigin
@RestController
public class StatusRestController {
	@Autowired
	private StatusDao statusDao;
	
	@RequestMapping(value = "/status/{idStatus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Status> listar(@PathVariable Long idStatus)
	{
		try {
			Status status = statusDao.listar(idStatus);
			if(status != null)
				return ResponseEntity.ok(status);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Status> listar()
	{
		return statusDao.listar();
	}
	
	@RequestMapping(value = "/status", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Status> inserir(@RequestBody Status status)
	{
		try {
			if(status != null)
			{
				statusDao.inserir(status);
				URI location = new URI("/status/"+status.getIdStatus());
				return ResponseEntity.created(location).body(status);
			}
			else{
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
