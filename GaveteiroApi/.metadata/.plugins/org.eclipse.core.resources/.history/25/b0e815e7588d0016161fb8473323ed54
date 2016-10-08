package br.gaveteiro.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.gaveteiro.senai.modelo.FormaPagamento;

@Repository
public class FormaPagamentoDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(FormaPagamento pagamento)
	{
		manager.persist(pagamento);
	}
	
	public FormaPagamento listar(Long idFormaPagamento)
	{
		return manager.find(FormaPagamento.class, idFormaPagamento);
	}
	
	public List<FormaPagamento> listar()
	{
		TypedQuery<FormaPagamento> query = manager.createQuery("select p from FormaPagamento p", FormaPagamento.class);
		return query.getResultList();
	}
}
