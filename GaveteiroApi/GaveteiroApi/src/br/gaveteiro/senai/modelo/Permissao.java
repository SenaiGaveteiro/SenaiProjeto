package br.gaveteiro.senai.modelo;

public class Permissao {
	private Long idPermissao;
	private String action;
	private String controller;
	private Long idTipo;
	public Long getIdPermissao() {
		return idPermissao;
	}
	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public Long getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

}
