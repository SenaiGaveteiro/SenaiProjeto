package br.gaveteiro.senai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.gaveteiro.senai.modelo.Permissao;
import br.gaveteiro.senai.modelo.TipoUsuario;

@Repository
public class PermissaoDao {
	@PersistenceContext
	private EntityManager manager;

	public List<Permissao> listar() {
		TypedQuery<Permissao> query = manager.createQuery("select p from Permissao p", Permissao.class);
		return query.getResultList();
	}

	public Permissao listar(Long idPermissao) {
		try {
			Permissao permissao = manager.find(Permissao.class, idPermissao);
			return permissao;
		} catch (Exception e) {
			e.printStackTrace();
			return new Permissao();
		}
	}

	public List<Permissao> listarPorTipo(Long idTipo) {
		TypedQuery<Permissao> query = manager
				.createQuery("select p from Permissao p where p.tipoUsuario.idTipo = :idTipo", Permissao.class);
		query.setParameter("idTipo", idTipo);
		return query.getResultList();
	}

	public boolean validar(String controller, String action, TipoUsuario tipo) {
		TypedQuery<Permissao> query = manager.createQuery(
				"select p from Permissao p where p.action = :action and p.tipoUsuario.idTipo = :id", Permissao.class);
		query.setParameter("id", tipo.getIdTipo());
		query.setParameter("action", action);
		try {
			for (Permissao permissao : query.getResultList()) {
				if (controller.contains(permissao.getController()))
					return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
