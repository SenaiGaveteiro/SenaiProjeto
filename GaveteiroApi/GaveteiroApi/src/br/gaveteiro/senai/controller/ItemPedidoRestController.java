package br.gaveteiro.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gaveteiro.senai.dao.ItemPedidoDao;
import br.gaveteiro.senai.modelo.ItemPedido;

@RestController
public class ItemPedidoRestController {
	@Autowired
	ItemPedidoDao itemPedidoDao;

	@RequestMapping(value = "pedido/{idPedido}/itens", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ItemPedido> listar(@PathVariable Long idPedido)
	{
	    return itemPedidoDao.listarPorPedido(idPedido);	
	}
	
}
