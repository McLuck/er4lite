package br.com.mcluck.er4lite.domain;

import br.com.mcluck.er4lite.annotations.CascadeType;
import br.com.mcluck.er4lite.annotations.Column;
import br.com.mcluck.er4lite.annotations.Entity;
import br.com.mcluck.er4lite.annotations.Id;
import br.com.mcluck.er4lite.annotations.OneToOne;

@Entity
public class Usuario {
	@Id(autoIncrement=true, name="idusuario")
	private int id;
	
	@Column(lenght=1000)
	private String nome;
	private String email;

	@Column(name="rua")
	private String logradouro;
	@Column(ignoreField=true)
	private String numero;
	
	@OneToOne(cascade={CascadeType.ALL}, joinColumn="idtelefone")
	private Telefone telefone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
