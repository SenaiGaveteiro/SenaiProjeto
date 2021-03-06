package br.gaveteiro.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.gaveteiro.senai.modelo.Status;

@Repository
public class StatusDao {
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(Status status)
	{
		manager.persist(status);
	}
	
	public Status listar(Long idStatus)
	{
		return manager.find(Status.class, idStatus);
	}
	
	public List<Status> listar()
	{
		TypedQuery<Status> query = manager.createQuery("select s from Status s", Status.class);
		return query.getResultList();
	}
	
	
}
