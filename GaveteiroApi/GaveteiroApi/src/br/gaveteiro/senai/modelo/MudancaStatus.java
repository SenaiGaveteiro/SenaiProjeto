package br.gaveteiro.senai.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mudaca_status")
public class MudancaStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mudanca")
	private Long idMudanca;
	@ManyToMany
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	@JoinColumn(name = "id_status")
	private Status status;
	@JoinColumn(name = "id_usuario")
	@OneToMany
	private Usuario usuario;
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getIdMudanca() {
		return idMudanca;
	}
	public void setIdMudanca(Long idMudanca) {
		this.idMudanca = idMudanca;
	}

}
