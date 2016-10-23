package br.gaveteiro.senai.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_status")
	private Long idStatus;
	private String descricao;
	
	public Long getIdStatus() {
		return this.idStatus;
	}
	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
