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
 * HISTÓRICO DA CLASSE: <br/>
 * ER4Lite <br/>
 * 10/04/2012 - Primeira versão da classe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)  
@Documented  
public @interface OneToOne {
	
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
	
	/**
	 * Definir o nome do atributo da outra entidade que contem o mapa da FK na tabela para este relacionamento<br/>
	 * Padrão será o primeiro atributo da classe mapeada com a FK. Caso tenha mais de um, isto irá causar divergencia de dados.
	 * @return String contendo o nome do atributo da outra entidade que referencia esta entidade
	 */
	public String mappedBy() default "";
	
	/**
	 * Definir o nome da coluna utilizada para mapear este relacionamento com a outra classe. <br/>
	 * @return 
	 */
	public String joinColumn() default "";
}
