package br.gaveteiro.senai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.gaveteiro.senai.dao.EmpresaDao;

@RestController
public class EmpresaRestController {
	@Autowired
	private EmpresaDao empresaDao;
	
}
