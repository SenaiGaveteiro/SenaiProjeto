package br.gaveteiro.senai.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.gaveteiro.senai.modelo.Empresa;

@Repository
public class EmpresaDao {
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Empresa empresa)
	{
		manager.persist(empresa);
	}
}
