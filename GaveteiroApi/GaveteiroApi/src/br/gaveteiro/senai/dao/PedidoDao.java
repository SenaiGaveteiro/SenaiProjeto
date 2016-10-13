package br.gaveteiro.senai.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.gaveteiro.senai.modelo.Pedido;

@Repository
public class PedidoDao {
	@PersistenceContext
	private EntityManager manager;
	@Transactional
	public Pedido listar(Long idPedido)
	{
		return manager.find(Pedido.class, idPedido);
	}
	
}
