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
 * HISTÓRICO DA CLASSE: Interface para definir o campo da entidade que será a PK na tabela<br/>
 * ER4Lite <br/>
 * 09/04/2012 - Primeira versão da classe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)  
@Documented  
public @interface Id {
	/**
	 * O campo que será usado como PK da tabela.
	 * @return "id"
	 */
	public String name() default "id";
	
	/**
	 * Campo é auto increment
	 * @return true by default
	 */
	public boolean autoIncrement() default true;
}
