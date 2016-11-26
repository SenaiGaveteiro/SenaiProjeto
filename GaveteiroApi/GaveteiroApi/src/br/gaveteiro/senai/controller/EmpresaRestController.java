package br.gaveteiro.senai.controller;

import org.json.JSONObject;
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
import java.net.*;
import java.util.List;

import br.gaveteiro.senai.dao.EmpresaDao;
import br.gaveteiro.senai.modelo.Empresa;
@CrossOrigin
@RestController
public class EmpresaRestController {
	@Autowired
	private EmpresaDao empresaDao;
	
	@RequestMapping(value = "/empresa", method =RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Empresa> inserir(@RequestBody String strEmpresa)
	{
		 try {
			 JSONObject job = new JSONObject(strEmpresa);
			 Empresa empresa = new Empresa();
			 empresa.setRazaoSocial(job.getString("razaoSocial"));
			 empresa.setCnpj(job.getString("cnpj"));
			 empresaDao.inserir(empresa);
			 
			 URI location = new URI("/empresa/"+empresa.getIdEmpresa());
			return ResponseEntity.created(location).body(empresa);
		} catch (Exception e) {
		  e.printStackTrace();
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/empresa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Empresa> listar()
	{
		return empresaDao.listar();
	}
	
	@RequestMapping(value = "/empresa/{idEmpresa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Empresa> listar(@PathVariable Long idEmpresa)
	{
		try {
			Empresa empresa = empresaDao.listar(idEmpresa);
			return ResponseEntity.ok(empresa); 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
