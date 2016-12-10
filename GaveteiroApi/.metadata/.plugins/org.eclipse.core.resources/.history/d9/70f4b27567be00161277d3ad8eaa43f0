package br.gaveteiro.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gaveteiro.senai.dao.MudancaStatusDao;
import br.gaveteiro.senai.modelo.MudancaStatus;

@RestController
public class MudancaStatusRestController {

	@Autowired
	private MudancaStatusDao mudancaStatusDao;
	
	@RequestMapping(value="pedido/{idPedido}/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MudancaStatus> listar(@PathVariable Long idPedido)
	{
		return mudancaStatusDao.listar(idPedido);
	}
	
}
