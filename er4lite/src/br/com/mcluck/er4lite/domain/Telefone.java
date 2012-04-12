/**
 * 
 */
package br.com.mcluck.er4lite.domain;

import br.com.mcluck.er4lite.annotations.Entity;
import br.com.mcluck.er4lite.annotations.Id;
import br.com.mcluck.er4lite.annotations.OneToOne;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Telefone de usuário<br/>
 * ER4Lite <br/>
 * 10/04/2012 - Primeira versão da classe
 */
@Entity
public class Telefone {
	@Id(autoIncrement=true, name="idtelefone")
	private Integer id;
	private String numero;
	
	@OneToOne(mappedBy="telefone")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
