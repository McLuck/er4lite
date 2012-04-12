/**
 * 
 */
package br.com.mcluck.er4lite.utils;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LucasIsrael -  <br />
 * HISTÓRICO DA CLASSE: Classe para tratamento rapido de Dates<br/>
 * ER4Lite <br/>
 * 11/04/2012 - Primeira versão da classe
 */
public class SmartDate extends java.util.Date{
	private static final String FORMATO_SQL = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMATO_VISUAL_COMPLETO_PT_BR = "dd/MM/yyyy HH:mm:ss";
	private static final String FORMATO_VISUAL_COMPLETO_EN_US = "MM/dd/yyyy HH:mm:ss";
	private static final String FORMATO_VISUAL_DATA_EN_US = "MM/dd/yyyy";
	private static final String FORMATO_VISUAL_DATA_PT_BR = "dd/MM/yyyy";
	private static final String FORMATO_VISUAL_HORA_MINUTO_SEGUNDO = "HH:mm:ss";
	private static final String FORMATO_VISUAL_HORA_MINUTO = "HH:mm";
	
	public String getVisualCompletoPTBR(){
		return new SimpleDateFormat(FORMATO_VISUAL_COMPLETO_PT_BR).format(this);
	}
	
	public String getVisualCompletoENUS(){
		return new SimpleDateFormat(FORMATO_VISUAL_COMPLETO_EN_US).format(this);
	}
	
	public String getVisualDataPTBT(){
		return new SimpleDateFormat(FORMATO_VISUAL_DATA_PT_BR).format(this);
	}
	
	public String getVisualDataENUS(){
		return new SimpleDateFormat(FORMATO_VISUAL_DATA_EN_US).format(this);
	}
	
	public String getVisualHoraCompleta(){
		return new SimpleDateFormat(FORMATO_VISUAL_HORA_MINUTO_SEGUNDO).format(this);
	}
	
	public String getVisualHora(){
		return new SimpleDateFormat(FORMATO_VISUAL_HORA_MINUTO).format(this);
	}
	
	public SmartDate(){
		super();
	}

	public SmartDate(long milis){
		super(milis);
	}

	public SmartDate(Date date){
		super();
		setTime(date.getTime());
	}

	public SmartDate(String input, String format) throws ParseException{
		super();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date data=dateFormat.parse(input);
		super.setTime(data.getTime());
	}
	
	public SmartDate(String input) throws ParseException{
		super();
		SimpleDateFormat dateFormat;
		Date data=null;
		if(input.length()==19){
			if(input.contains("-")){
				dateFormat = new SimpleDateFormat(FORMATO_SQL);
				data = dateFormat.parse(input);	
			}else if(input.contains("/")){
				try{
					dateFormat = new SimpleDateFormat(FORMATO_VISUAL_COMPLETO_PT_BR);
					data = dateFormat.parse(input);	
				}catch(ParseException e){
					dateFormat = new SimpleDateFormat(FORMATO_VISUAL_COMPLETO_EN_US);
					data = dateFormat.parse(input);	
				}
			}
		}else if(input.length()==10){
			try{
				dateFormat = new SimpleDateFormat(FORMATO_VISUAL_DATA_PT_BR);
				data = dateFormat.parse(input);
			}catch(ParseException e){
				dateFormat = new SimpleDateFormat(FORMATO_VISUAL_DATA_EN_US);
				data = dateFormat.parse(input);
			}
		}else if(input.length()==8 && input.contains(":")){
			dateFormat = new SimpleDateFormat(FORMATO_VISUAL_HORA_MINUTO_SEGUNDO);
			data = dateFormat.parse(input);
		}else if(input.length()==5 && input.contains(":")){
			dateFormat = new SimpleDateFormat(FORMATO_VISUAL_HORA_MINUTO);
			data = dateFormat.parse(input);
		}else{
			throw new InvalidParameterException(input+" não é uma data válida!");
		}
		if(data!=null){
			super.setTime(data.getTime());
		}
	}
}
