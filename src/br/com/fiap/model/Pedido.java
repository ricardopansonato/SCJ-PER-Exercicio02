package br.com.fiap.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PEDIDOS", catalog = "EXERCICIO02", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "IDPEDIDO" } ) })
public class Pedido implements Serializable {

	private static final long serialVersionUID = -6744183770591583504L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="IDPEDIDO")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumns({@JoinColumn(name="IDCLIENTE",referencedColumnName="IDCLIENTE")})
	private Cliente cliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA")	
	private Calendar data;
	
	@Column(name="DESCRICAO", length=45)
	private String descricao;
	
	@Column(name="VALOR")
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", data=" + data + ", descricao=" + descricao + ", valor="
				+ valor + "]";
	}
}
