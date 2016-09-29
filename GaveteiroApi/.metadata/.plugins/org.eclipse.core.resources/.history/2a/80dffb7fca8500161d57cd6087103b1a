package br.gaveteiro.senai.modelo;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> dc5f73faba4739bdaf7ecae528529854fddc4d08
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "forma_pagamento")
public class FormaPagamento {
	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento")
=======
<<<<<<< HEAD
	@GeneratedValue
=======
<<<<<<< HEAD
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pagamento")
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> bd1041ad3c0cb22d77c61735e49002e9e789d2d2
>>>>>>> df123979dc79bf9c0b9b75fdbd75a4dc56b2c71d
>>>>>>> dc5f73faba4739bdaf7ecae528529854fddc4d08
	private Long idFormaPagamento;
	@OneToMany (mappedBy="pagamento")
	private List <Pedido> pedidos;
	
	private String descricao;
	public Long getIdFormaPagamento() {
		return idFormaPagamento;
	}
	public void setIdFormaPagamento(Long idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	} 
}
