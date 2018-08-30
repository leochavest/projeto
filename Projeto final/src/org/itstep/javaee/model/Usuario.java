package org.itstep.javaee.model;

public class Usuario {

	private String nome;
	private Integer cpf;
	private String endereco;
	private String telefone;

	public Usuario() {
		super();
	}

	public Usuario(String nome, Integer cpf, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}


}
