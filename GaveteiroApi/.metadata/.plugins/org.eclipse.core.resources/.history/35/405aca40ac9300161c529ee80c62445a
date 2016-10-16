package br.gaveteiro.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.gaveteiro.senai.modelo.Produto;

@Repository
public class ProdutoDao {
@PersistenceContext
private EntityManager manager;
	
	@Transactional
	public void inserir(Produto produto)
    {
		manager.persist(produto);
	}
	
	public List<Produto> listar()
	{
		TypedQuery<Produto> query = manager.createQuery("select p from Produto p", Produto.class);
		return query.getResultList(); 
	}
	
	public Produto listar(Long idProduto)
	{
		return manager.find(Produto.class, idProduto);
	}
	
}
