/**
 * 
 */
package br.com.mcluck.er4lite.annotations;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Classe para definir os tipos de Cascade para relacionamentos das dependencias<br/>
 * ER4Lite <br/>
 * 09/04/2012 - Primeira versão da classe
 */
public final class CascadeType {
	public static final int ALL = 0;
	public static final int PERSIST = 1;
	public static final int REFRESH = 2;
	public static final int MERGE = 3;
}
