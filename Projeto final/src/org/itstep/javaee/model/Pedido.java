package org.itstep.javaee.model;

public class Pedido {
	private Integer id;
	private Integer idCardapio;
	private Integer cpf;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(Integer id, Integer idCardapio, Integer cpf) {
		super();
		this.id = id;
		this.idCardapio = idCardapio;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Integer idCardapio) {
		this.idCardapio = idCardapio;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idCardapio=" + idCardapio + ", cpf=" + cpf + "]";
	}

}
