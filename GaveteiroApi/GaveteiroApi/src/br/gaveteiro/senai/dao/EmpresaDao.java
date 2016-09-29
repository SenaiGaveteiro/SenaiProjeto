package br.gaveteiro.senai.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.gaveteiro.senai.modelo.Empresa;

@Repository
public class EmpresaDao {
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(Empresa empresa)
    {
		manager.persist(empresa);
	}
}
