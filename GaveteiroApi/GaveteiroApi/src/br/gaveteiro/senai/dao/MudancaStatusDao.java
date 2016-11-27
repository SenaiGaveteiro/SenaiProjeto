package br.gaveteiro.senai.dao;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.gaveteiro.senai.modelo.MudancaStatus;
import br.gaveteiro.senai.modelo.Pedido;
import br.gaveteiro.senai.modelo.Usuario;

@Repository
public class MudancaStatusDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void atualizarStatus(Pedido pedido, Usuario usuario)
	{
		Calendar dataAlteracao = Calendar.getInstance();
		dataAlteracao.getTime();
				
		MudancaStatus mudancaStatus = new MudancaStatus();
		mudancaStatus.setPedido(pedido);
		mudancaStatus.setStatus(pedido.getStatus());
		mudancaStatus.setUsuario(usuario);
		mudancaStatus.setDataAlteracao(dataAlteracao);
		manager.persist(mudancaStatus);
	}
	
}
