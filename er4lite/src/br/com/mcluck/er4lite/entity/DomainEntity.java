/**
 * 
 */
package br.com.mcluck.er4lite.entity;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.mcluck.er4lite.annotations.Entity;
import br.com.mcluck.er4lite.exceptions.InvalidEntityException;



/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Container de entidade<br/>
 * ER4Lite <br/>
 * 10/04/2012 - Primeira versão da classe
 */
public class DomainEntity {
	private Object domain;
	private Object idValue;
	private String table;
	private Field idField;
	private Map<Field, Object> attributes;
	public DomainEntity(Object domain) throws InvalidEntityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException{
		if(domain == null)
			throw new NullPointerException();
		if(!ReflectionUtil.isEntity(domain))
			throw new InvalidEntityException(InvalidEntityException.Code.IS_NOT_AN_ENTITY);
		this.idField = ReflectionUtil.getIdFromEntity(domain);
		if(this.idField==null)
			throw new InvalidEntityException(InvalidEntityException.Code.MISSING_PK);
		this.idValue = ReflectionUtil.getValue(domain, this.idField);
		attributes = new HashMap<Field, Object>();
		for(Field f : ReflectionUtil.getFields(domain)){
			f.setAccessible(true);
			attributes.put(f, ReflectionUtil.getValue(domain, f));
		}
		Entity entity = ReflectionUtil.getAnnotationEntity(domain);
		this.table = entity.Table();
		if(table.equals("")){
			table = domain.getClass().getSimpleName().toUpperCase();
		}
		this.domain = domain;
	}
	public Object getDomain() {
		return domain;
	}
	public void setDomain(Object domain) {
		this.domain = domain;
	}
	
	public Object getIdValue() {
		return idValue;
	}
	public void setIdValue(Object idValue) {
		this.idValue = idValue;
	}
	public Field getIdField() {
		return idField;
	}
	public void setIdField(Field idField) {
		this.idField = idField;
	}
	public Map<Field, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<Field, Object> attributes) {
		this.attributes = attributes;
	}
	public Set<Field> getSetAttributes(){
		return attributes.keySet();
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
}
