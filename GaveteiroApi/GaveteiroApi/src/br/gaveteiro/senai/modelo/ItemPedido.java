package br.gaveteiro.senai.modelo;

public class ItemPedido {
	private Long idItemPedido;
	private Long quantidade;
	private Float valorUnitario;
	private Float valorSubtotal;
	private Float valorFrete;
	private Float total;
	private Long idProduto;
	private Long idPedido;
	private String servicoFrete;
	public Long getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Float getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Float getValorSubtotal() {
		return valorSubtotal;
	}
	public void setValorSubtotal(Float valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}
	public Float getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(Float valorFrete) {
		this.valorFrete = valorFrete;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public String getServicoFrete() {
		return servicoFrete;
	}
	public void setServicoFrete(String servicoFrete) {
		this.servicoFrete = servicoFrete;
	} 
}
