package br.com.fiap.main;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.impl.ClienteDaoJpaImpl;
import br.com.fiap.model.Cliente;
import br.com.fiap.model.Pedido;

public class Program {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("system");
		EntityManager em = emf.createEntityManager();
		GenericDao<Cliente, Long> clienteDao = new ClienteDaoJpaImpl(em);
		
		for (int j = 0; j < 3; j++) {
			Cliente cliente = new Cliente();
			cliente.setEmail("ricardolp.bsi+" + j + "@gmail.com");
			cliente.setNome("Ricardo");
			
			Set<Pedido> pedidos = new LinkedHashSet<>();
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente);
			pedido.setData(Calendar.getInstance());
			pedido.setValor(10.2d);
			pedido.setDescricao("Carro" + j);
			pedidos.add(pedido);
			
			Pedido pedido1 = new Pedido();
			pedido1.setCliente(cliente);
			pedido1.setData(Calendar.getInstance());
			pedido1.setValor(10.2d);
			pedido1.setDescricao("Bicicleta" + j);
			
			pedidos.add(pedido1);
			cliente.setPedidos(pedidos);
			
			clienteDao.create(cliente);
		}
		
		clienteDao.lista().forEach(c -> {
			System.out.println(c);
			c.getPedidos().forEach(p -> {
				System.out.println(p);
			});
		});
		
		em.close();
	}
}
