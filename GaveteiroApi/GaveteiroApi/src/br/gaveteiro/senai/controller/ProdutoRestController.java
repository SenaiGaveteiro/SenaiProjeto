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

import br.gaveteiro.senai.dao.ProdutoDao;
import br.gaveteiro.senai.modelo.Produto;
@CrossOrigin
@RestController
public class ProdutoRestController {

	@Autowired
	private ProdutoDao produtoDao;
	
	@RequestMapping(value = "/produto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Produto> inserir (@RequestBody Produto produto)
	{	
		try {
			produtoDao.inserir(produto);
			URI location = new URI("/produto/"+produto.getIdProduto());
			return ResponseEntity.created(location).body(produto);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/produto", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Produto> lista(){
	
		return produtoDao.listar();
		
	}
	
	@RequestMapping(value = "/produto/{idProduto}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Produto> listar(@PathVariable Long idProduto)
	{
		try {
			Produto produto = produtoDao.listar(idProduto);
			return ResponseEntity.ok(produto); 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
