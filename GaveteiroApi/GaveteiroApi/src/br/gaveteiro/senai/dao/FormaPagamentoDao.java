package br.gaveteiro.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.gaveteiro.senai.modelo.FormaPagamento;

@Repository
public class FormaPagamentoDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
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
	
	public void merge(FormaPagamento pagamento){
		manager.merge(pagamento);
	}
}
