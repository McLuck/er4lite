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
 * HISTÓRICO DA CLASSE: Interface para definir dados mais refinados de cada campo de uma tabela no mapeamento de uma entidade<br/>
 * ER4Lite <br/>
 * 09/04/2012 - Primeira versão da classe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)  
@Documented  
public @interface Column {
	/**
	 * Define o nome do campo na tabela
	 * @return Padrão sempre é o nome do campo da classe
	 */
	public String name() default  "";
	
	/**
	 * Por padrão todos os atributos de uma entidades fazem referência a uma coluna de uma tabela no banco.
	 * Para definir um atributo não persistente, ou seja, que não será considerado no momento de persistir, use true neste parâmetro.
	 * @return false por default
	 */
	public boolean ignoreField() default false;
	
	/**
	 * Definir o tamanho de um campo no banco do tipo String. Caso este valor ultrapasse 255, o tipo da coluna no banco será do tipo TEXT.
	 * @return 255 default
	 */
	public int lenght() default 255;
}
