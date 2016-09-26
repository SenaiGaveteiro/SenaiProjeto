package br.gaveteiro.senai.modelo;

<<<<<<< HEAD
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
=======
import java.util.Calendar;

>>>>>>> dc5f73faba4739bdaf7ecae528529854fddc4d08
public class MudancaStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mudanca")
	private Long idMudanca;
<<<<<<< HEAD
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
=======
	private Long idPedido;
	private Long idStatus;
	private Long idUsuario;
	private Calendar dataAlteracao;
	
	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public Long getIdMudanca() {
		return idMudanca;
>>>>>>> dc5f73faba4739bdaf7ecae528529854fddc4d08
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
