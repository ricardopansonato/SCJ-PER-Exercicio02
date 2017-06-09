package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Pedido;

public class PedidoDaoJpaImpl extends GenericDaoJpaImpl<Pedido, Long> {

	public PedidoDaoJpaImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Pedido> lista() {
		TypedQuery<Pedido> query = entityManager.createQuery("select v from Pedido v", Pedido.class);
		return query.getResultList();
	}
	
	public Pedido encontrarPorId(Long id) {
		TypedQuery<Pedido> query = entityManager.createQuery("select v from Pedido v where v.id = :id", Pedido.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
