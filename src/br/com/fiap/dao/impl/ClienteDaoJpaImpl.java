package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Cliente;

public class ClienteDaoJpaImpl extends GenericDaoJpaImpl<Cliente, Long> {

	public ClienteDaoJpaImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Cliente> lista() {
		TypedQuery<Cliente> query = entityManager.createQuery("select v from Cliente v", Cliente.class);
		return query.getResultList();
	}
	
	public Cliente encontrarPorId(Long id) {
		TypedQuery<Cliente> query = entityManager.createQuery("select v from Cliente v where v.id = :id", Cliente.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
