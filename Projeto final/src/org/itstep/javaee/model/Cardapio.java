package org.itstep.javaee.model;

public class Cardapio {
	private Integer id;
	private String proteina;
	private String acompanhamentos;
	
	public Cardapio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cardapio(Integer id, String proteina, String acompanhamentos) {
		super();
		this.id = id;
		this.proteina = proteina;
		this.acompanhamentos = acompanhamentos;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProteina() {
		return proteina;
	}
	public void setProteina(String proteina) {
		this.proteina = proteina;
	}
	public String getAcompanhamentos() {
		return acompanhamentos;
	}
	public void setAcompanhamentos(String acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", proteina=" + proteina + ", acompanhamentos=" + acompanhamentos + "]";
	}

	
}
