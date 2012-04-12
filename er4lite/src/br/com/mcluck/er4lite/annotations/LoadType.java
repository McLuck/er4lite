/**
 * 
 */
package br.com.mcluck.er4lite.annotations;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Tipos de carregamentos disponíveis<br/>
 * ER4Lite <br/>
 * 09/04/2012 - Primeira versão da classe
 */
public final class LoadType {
	/**
	 * Carregamento lazy utilizando proxy da dependência
	 */
	public static final int LAZY_LOADING = 0;
	
	/**
	 * Carregamento eager da dependência
	 */
	public static final int EAGER = 1;
}
