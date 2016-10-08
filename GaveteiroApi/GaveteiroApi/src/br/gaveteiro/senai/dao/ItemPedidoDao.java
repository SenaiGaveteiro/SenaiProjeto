package br.gaveteiro.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.gaveteiro.senai.modelo.ItemPedido;

@Repository
public class ItemPedidoDao {
	@PersistenceContext
	private EntityManager manager;
	
	public List<ItemPedido> listarPorPedido(Long idPedido)
	{
		TypedQuery<ItemPedido> query = manager.createQuery("select i from ItemPedido i where i.pedido.idPedido = :idPedido", ItemPedido.class);
		query.setParameter("idPedido", idPedido);
		return query.getResultList();
	}
}
