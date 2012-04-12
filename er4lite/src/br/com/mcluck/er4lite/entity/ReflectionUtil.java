/**
 * 
 */
package br.com.mcluck.er4lite.entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import br.com.mcluck.er4lite.annotations.Column;
import br.com.mcluck.er4lite.annotations.Entity;
import br.com.mcluck.er4lite.annotations.Id;
import br.com.mcluck.er4lite.annotations.ManyToMany;
import br.com.mcluck.er4lite.annotations.ManyToOne;
import br.com.mcluck.er4lite.annotations.OneToMany;
import br.com.mcluck.er4lite.annotations.OneToOne;


/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Classe para ajudar na implementação do tratamento de entitades por reflections<br/>
 * ER4Lite <br/>
 * 10/04/2012 - Primeira versão da classe
 */
public class ReflectionUtil {
	public synchronized static boolean isEntity(Object o){
		return o!=null ? o.getClass().isAnnotationPresent(Entity.class):false;
	}
	public synchronized static void setValue(Object obj, String field, Object value) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		Field f = getField(obj, field);
		f.set(obj, value);
	}
	public synchronized static Object getValue(Object obj, String field) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		Field f = getField(obj, field);
		return f.get(obj);
	}
	public synchronized static Field[] getFields(Object o){
		return o.getClass().getDeclaredFields();
	}
	public synchronized static Object getValue(Object obj, Field field) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		return field.get(obj);
	}
	public synchronized static Field getField(Object obj, String name) throws NoSuchFieldException{
		Field field = null;
		field = obj.getClass().getDeclaredField(name);
		field.setAccessible(true);
		return field;
	}
	
	public synchronized static boolean isId(Field f){
		return f!=null?f.isAnnotationPresent(Id.class):false;
	}
	
	public synchronized static Field getIdFromEntity(Object o){
		for(Field f : o.getClass().getDeclaredFields()){
			if(isId(f))
				return f;
		}
		return null;
	}
	
	public synchronized static Id getAnnotationId(Field idField){
		if(isId(idField)){
			return idField.getAnnotation(Id.class);
		}
		return null;
	}
	
	public synchronized static Entity getAnnotationEntity(Object o){
		if(isEntity(o)){
			return o.getClass().getAnnotation(Entity.class);
		}
		return null;
	}
	
	public synchronized static Column getAnnotationColumn(final Field f){
		if(f.isAnnotationPresent(Column.class)){
			return f.getAnnotation(Column.class);
		}
		if(isId(f))
			return null;
		return new Column() {
			public Class<? extends Annotation> annotationType() {
				return Column.class;
			}
			
			@Override
			public String name() {
				return f.getName();
			}
			
			@Override
			public int lenght() {
				return 255;
			}
			
			@Override
			public boolean ignoreField() {
				return false;
			}
		};
	}
	
	public synchronized static ManyToMany getAnnotationManyToMany(Field f){
		if(f.isAnnotationPresent(ManyToMany.class)){
			return f.getAnnotation(ManyToMany.class);
		}
		return null;
	}
	
	public synchronized static ManyToOne getAnnotationManyToOne(Field f){
		if(f.isAnnotationPresent(ManyToOne.class)){
			return f.getAnnotation(ManyToOne.class);
		}
		return null;
	}
	
	public synchronized static OneToMany getAnnotationOneToMany(Field f){
		if(f.isAnnotationPresent(OneToMany.class)){
			return f.getAnnotation(OneToMany.class);
		}
		return null;
	}
	
	public synchronized static OneToOne getAnnotationOneToOne(Field f){
		if(f.isAnnotationPresent(OneToOne.class)){
			return f.getAnnotation(OneToOne.class);
		}
		return null;
	}
	
	public synchronized static String getColumnName(Field f, Object value) throws NoSuchFieldException {
		if(f!=null){
			String columnName = f.getName().toUpperCase();
			if(isOneToMany(f)){
				OneToMany otm = ReflectionUtil.getAnnotationOneToMany(f);
				if(!otm.foreingKey().equals("")){
					columnName = otm.foreingKey();
				}
			}else if(isOneToOne(f)){
				OneToOne oto = ReflectionUtil.getAnnotationOneToOne(f);
				if(!oto.joinColumn().equals("")){
					columnName = oto.joinColumn();
				}else if(!oto.mappedBy().equals("")){
					Field other = ReflectionUtil.getField(value, oto.mappedBy());
					if(other!=null){
						OneToOne otoOther = ReflectionUtil.getAnnotationOneToOne(other);
						columnName = otoOther.joinColumn();
					}
				}
			}else{
				Column column = ReflectionUtil.getAnnotationColumn(f);
				if(column!=null){
					columnName = column.name();
				}	
			}
			
			return columnName;
		}
		return null;
	}
	
	public synchronized static boolean isManyToOne(Field f){
		return f.isAnnotationPresent(ManyToOne.class);
	}
	
	public synchronized static boolean isManyToMany(Field f){
		return f.isAnnotationPresent(ManyToMany.class);
	}
	
	public synchronized static boolean isOneToMany(Field f){
		return f.isAnnotationPresent(OneToMany.class);
	}
	
	public synchronized static boolean isOneToOne(Field f){
		return f.isAnnotationPresent(OneToOne.class);
	}
	
	public synchronized static String getJoinTableManyToMany(Object obj, Field f){
		ManyToMany rel = ReflectionUtil.getAnnotationManyToMany(f);
		String joinTable = "_has_";
		Class another = rel.clazz();
		if(obj.getClass().getSimpleName().compareTo(another.getSimpleName())>1){
			joinTable = obj.getClass().getSimpleName().toUpperCase()
					.concat(joinTable)
					.concat(another.getSimpleName().toUpperCase());
		}else{
			joinTable = another.getSimpleName().toUpperCase()
					.concat(joinTable)
					.concat(obj.getClass().getSimpleName().toUpperCase());
		}
		return joinTable;
	}
}
