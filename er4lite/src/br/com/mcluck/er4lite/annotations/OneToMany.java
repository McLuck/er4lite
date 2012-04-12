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
 * HISTÓRICO DA CLASSE: Interface para definir configurações de relacionamentos 1:N <br/>
 * ER4Lite <br/>
 * 09/04/2012 - Primeira versão da classe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)  
@Documented  
public @interface OneToMany{
	/**
	 * O nome da coluna na tabela que representa o tipo de 
	 * @return String com o nome do campo na tabela que será a FK
	 */
	public String foreingKey();
	
	/**
	 * Define o tipo de carregamento para entidades dependentes 
	 * @return int(0) definido em br.com.mcluck.er4lite.annotations.LoadType.LAZY_LOADING
	 */
	public int loadType() default LoadType.LAZY_LOADING;
	
	/**
	 * Tipo de cascata entre o relacionamento. <br/>
	 * Ver tipos disponíveis em CascadeType.class
	 * @return int(0) Definido em CascadeType.ALL
	 */
	public int[]cascade() default {CascadeType.ALL};
}
