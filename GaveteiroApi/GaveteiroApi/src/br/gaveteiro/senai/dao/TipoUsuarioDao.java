package br.gaveteiro.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.gaveteiro.senai.modelo.TipoUsuario;

@Repository
public class TipoUsuarioDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(TipoUsuario tipo)
	{
		manager.persist(tipo);
	}
	
	public List<TipoUsuario> listar()
	{
		TypedQuery<TipoUsuario> query = manager.createQuery("select t from TipoUsuario t", TipoUsuario.class);
		return query.getResultList(); 
	}
	
	public TipoUsuario listar(Long idTipoUsuario)
	{
		return manager.find(TipoUsuario.class, idTipoUsuario);
	}
	
	@Transactional
	public void alterar(String descricao, Long idTipo)
	{
		TipoUsuario tipo = manager.find(TipoUsuario.class, idTipo);
		tipo.setDescricao(descricao);
		manager.merge(tipo);
	}
	
	@Transactional
	public void excluir(Long idTipoUsuario)
	{
			TipoUsuario tipo = new TipoUsuario();
			tipo = manager.find(TipoUsuario.class, idTipoUsuario);
			manager.remove(tipo);
	}
}
