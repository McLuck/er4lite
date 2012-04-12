/**
 * 
 */
package br.com.mcluck.er4lite.entity;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.test.IsolatedContext;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Converte DomainEntity em SQL<br/>
 * ER4Lite <br/>
 * 11/04/2012 - Primeira versão da classe
 */
public class GenerateSQL {
	public synchronized static ContentValues getContentValues(DomainEntity de){
		ContentValues cv = new ContentValues();
		try{
			for(Field f : de.getSetAttributes()){
				Object o = de.getAttributes().get(f);
				if(o instanceof Date){
					cv.put(ReflectionUtil.getColumnName(f, o), ((Date)o).getTime());
				}else if(o instanceof Integer){
					cv.put(ReflectionUtil.getColumnName(f,o), (Integer)o);	
				}else if(o instanceof Double){
					cv.put(ReflectionUtil.getColumnName(f,o), (Double)o);
				}else if(o instanceof Float){
					cv.put(ReflectionUtil.getColumnName(f,o), (Float)o);
				}else if(o instanceof String){
					cv.put(ReflectionUtil.getColumnName(f,o), (String)o);
				}else if(o instanceof Short){
					cv.put(ReflectionUtil.getColumnName(f,o), (Short)o);
				}else if(o instanceof Boolean){
					cv.put(ReflectionUtil.getColumnName(f,o), (Boolean)o);
				}else if(o instanceof Byte){
					cv.put(ReflectionUtil.getColumnName(f,o), (Byte)o);
				}else if(o instanceof byte[]){
					cv.put(ReflectionUtil.getColumnName(f,o), (byte[])o);
				}else if(ReflectionUtil.isOneToMany(f)){
					Field anotherId = ReflectionUtil.getIdFromEntity(o);
					if(anotherId!=null){
						Object fk = null;
						try {
							fk = ReflectionUtil.getValue(o, anotherId);
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (NoSuchFieldException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
						if(fk == null){
							cv.putNull(ReflectionUtil.getColumnName(f, de.getAttributes().get(fk)));
						}
					}
				}
			}	
		}catch(NoSuchFieldException e){
			e.printStackTrace();
		}
		return cv;
	}
	public static class Insert{
		public static String getDefaultInsert(DomainEntity de) throws NoSuchFieldException{
			String sql = "INSERT INTO #TABLE_NAME# (#COLUMNS#) VALUE (#VALUES#)";
			StringBuilder columns = new StringBuilder();
			StringBuilder values = new StringBuilder();
			boolean frt = true;
			for(Field f : de.getSetAttributes()){
				if(frt)
					frt = false;
				else{
					columns.append(", ");
					values.append(", ");
				}
				columns.append(ReflectionUtil.getColumnName(f, de.getAttributes().get(f)));
				if(f.getType().equals(String.class) || f.getType()==String.class){
					values.append("'");
					values.append(de.getAttributes().get(f));
					values.append("'");
				}else if(f.getType().equals(Date.class) || f.getType() == Date.class){
					values.append(((Date)de.getAttributes().get(f)).getTime());
				}else{
					values.append(de.getAttributes().get(f));
				}
			}
			sql = sql.replace("#TABLE_NAME#", de.getTable()).replace("#COLUMNS#", columns.toString())
					.replace("#VALUES#", values.toString());
			return sql;
		}
	}
	public static class Select{
		public static String getNextId(DomainEntity de){
			String sql = "SELECT MAX(".concat(de.getIdField().getName()).concat(")+1 FROM ").concat(de.getTable());
			return sql;
		}
	}
}
