/**
 * 
 */
package br.com.mcluck.er4lite.exceptions;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Exception para tipos de entidades inválidas<br/>
 * ER4Lite <br/>
 * 10/04/2012 - Primeira versão da classe
 */
public class InvalidEntityException extends ER4LiteExcepion{
	
	private static final long serialVersionUID = -5313243000869189318L;
	public InvalidEntityException(){
		super();
	}
	public InvalidEntityException(Integer code){
		super(code);
	}	
	public InvalidEntityException(Integer code, String message){
		super(code, message);
	}	
	public InvalidEntityException(String message){
		super(message);
	}	
	
	public static class Code{
		public static final Integer MISSING_PK = Integer.valueOf(1);
		public static final Integer IS_NOT_AN_ENTITY = Integer.valueOf(2);
	}
}
