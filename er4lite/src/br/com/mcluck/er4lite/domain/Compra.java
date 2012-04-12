/**
 * 
 */
package br.com.mcluck.er4lite.domain;

import java.util.List;

import br.com.mcluck.er4lite.annotations.CascadeType;
import br.com.mcluck.er4lite.annotations.Entity;
import br.com.mcluck.er4lite.annotations.Id;
import br.com.mcluck.er4lite.annotations.ManyToMany;
import br.com.mcluck.er4lite.annotations.OneToMany;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: <br/>
 * ER4Lite <br/>
 * 10/04/2012 - Primeira versão da classe
 */
@Entity
public class Compra {
	@Id(autoIncrement=true, name="idcompra")
	private int id;
	
	@OneToMany(cascade={CascadeType.ALL}, foreingKey="idusuario")
	private Usuario usuario;
	
	@ManyToMany(mappedBy="compras", clazz=Produto.class)
	private List<Produto> produtos;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.util.Date getData() {
		return data;
	}
	public void setData(java.util.Date data) {
		this.data = data;
	}
	private java.util.Date data;

	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
