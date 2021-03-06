package br.gaveteiro.senai.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_pedido")
	private Calendar dataPedido;
	private String endereco;
	@Column(name = "servico_frete")
	private String servicoFrete;
	private Float subtotal;
	private Float total;
	private Float frete;
	@Column(name = "ultima_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ultimaAtualizacao;
	@OneToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_status")
	private Status status;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pagamento")
	private FormaPagamento pagamento;
	@OneToMany(mappedBy = "pedido", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<ItemPedido> itens;
	public String getServicoFrete() {
		return servicoFrete;
	}

	public void setServicoFrete(String servicoFrete) {
		this.servicoFrete = servicoFrete;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public FormaPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(FormaPagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Float getFrete() {
		return frete;
	}

	public void setFrete(Float frete) {
		this.frete = frete;
	}
	
	public Calendar getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(Calendar ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

}