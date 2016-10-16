package br.gaveteiro.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.gaveteiro.senai.modelo.Pedido;
import br.gaveteiro.senai.modelo.Status;

@Repository
public class PedidoDao {
	@PersistenceContext
	private EntityManager manager;
	public Pedido listar(Long idPedido)
	{
		return manager.find(Pedido.class, idPedido);
	}
	
	public List<Pedido> listar()
	{
		TypedQuery<Pedido> query = manager.createQuery("select p From Pedido p", Pedido.class);
		return query.getResultList();
	}
	
	@Transactional
	public void alterarStatus(Long idPedido, Status status)
	{
		Pedido pedido = manager.find(Pedido.class, idPedido);
		pedido.setStatus(status);
		manager.merge(pedido);
	}
}
