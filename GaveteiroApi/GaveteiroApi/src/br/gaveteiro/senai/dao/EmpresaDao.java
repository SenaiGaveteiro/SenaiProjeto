package br.gaveteiro.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	public List<Empresa> listar()
	{
		TypedQuery<Empresa> query = manager.createQuery("select e from Empresa e", Empresa.class);
		return query.getResultList(); 
	}
	
	public Empresa listar(Long idEmpresa)
	{
		return manager.find(Empresa.class, idEmpresa);
	}
	
	@Transactional
	public void excluir(Long idEmpresa)
	{
		Empresa empresa = manager.find(Empresa.class, idEmpresa);
		manager.remove(empresa);
	}
	
}
