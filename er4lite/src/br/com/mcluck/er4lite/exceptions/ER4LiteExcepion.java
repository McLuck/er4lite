/**
 * 
 */
package br.com.mcluck.er4lite.exceptions;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Classe de exception padrão do ER4Lite<br/>
 * ER4Lite <br/>
 * 10/04/2012 - Primeira versão da classe
 */
public class ER4LiteExcepion extends Exception{
	private static final long serialVersionUID = 1L;
	private Integer code = Integer.valueOf(0);
	public ER4LiteExcepion(){
		super();
	}
	public ER4LiteExcepion(Integer code){
		super();
		this.code = code;
	}
	public ER4LiteExcepion(Integer code, String message){
		super(message);
		this.code = code;
	}
	public ER4LiteExcepion(String message){
		super(message);
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}
