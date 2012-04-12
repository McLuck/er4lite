/**
 * 
 */
package br.com.mcluck.er4lite.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Interface para definir se uma classe é entidade e portanto, é persistida através do <b>DAO</b><br/>
 * ER4Lite <br/>
 * 09/04/2012 - Primeira versão da classe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.TYPE)  
@Documented  
public @interface Entity {
	/**
	 * Nome da tabela que a entidade irá persistir <br/>
	 * Caso não seja especificado, a tabela tera o mesmo nome da classe
	 */
	public String Table () default "";
}
