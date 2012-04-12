/**
 * 
 */
package br.com.mcluck.er4lite.domain;

import java.util.List;

import br.com.mcluck.er4lite.annotations.Column;
import br.com.mcluck.er4lite.annotations.Entity;
import br.com.mcluck.er4lite.annotations.Id;
import br.com.mcluck.er4lite.annotations.ManyToMany;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: <br/>
 * ER4Lite <br/>
 * 10/04/2012 - Primeira versão da classe
 */
@Entity
public class Produto {
	@Id
	private Integer id;
	@Column(lenght=1000)
	private String descricao;
	private String icone;
	private String label;
	private Double valor;
	
	@ManyToMany(joinColumn="idproduto", clazz=Compra.class)
	private List<Compra> compras;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
}
