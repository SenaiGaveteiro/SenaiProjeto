package br.gaveteiro.senai.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.gaveteiro.senai.modelo.Usuario;

@Repository
public class UsuarioDao {
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Usuario usuario)
  {
		manager.persist(usuario);
	}

}
