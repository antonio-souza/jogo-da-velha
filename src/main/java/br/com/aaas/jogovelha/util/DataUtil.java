package br.com.aaas.jogovelha.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

  public static Calendar converterData(String strData, String formato) {
    if (strData == null || strData == "") {
      return null;
    }
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.setLenient(false);
      Date dtmData = new SimpleDateFormat(formato).parse(strData);
      calendar.setTimeInMillis(dtmData.getTime());
      return calendar;
    } catch (ParseException e) {
      //e.printStackTrace();
      return null;
    }
  }

  public static String formatarData(Calendar calendar, String formato) {
    if (calendar == null) {
      return null;
    }
    DateFormat df = new SimpleDateFormat(formato);
    return df.format(calendar.getTime());
  }

  public static final Calendar truncarData(final Calendar cal) {
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return cal;
  }
  
  public static final Calendar montarData(int dia, int mes, int ano) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    cal.set(Calendar.DAY_OF_MONTH, dia); 
    cal.set(Calendar.MONTH, mes - 1); 
    cal.set(Calendar.YEAR, ano); 
    return cal;
  }
  
  public static final Calendar somar(final Calendar cal, int campo, int quantidade) {
    Calendar calCopia = (Calendar) cal.clone();
    calCopia.add(campo, quantidade);
    return calCopia;
  }
  
  public static final Date converterDate(final Calendar cal) {
    if (cal == null) return null;
    return cal.getTime();
  }
  
  public static final int pegarAno(final Calendar cal) {
    return cal.get(Calendar.YEAR);
  }
  
  public static final int pegarMes(final Calendar cal) {
    return cal.get(Calendar.MONTH) + 1;
  }
  
  public static final int pegarDia(final Calendar cal) {
    return cal.get(Calendar.DAY_OF_MONTH);
  }
  
  public static Calendar setarHorarioCalendar(Calendar data, int hora, int minuto, int segundo) {
    if (data != null) {
      // Clona a data para não mudar hora na instancia q foi passada por parametro
      Calendar date = (Calendar) data.clone();
      date.set(Calendar.HOUR_OF_DAY, hora);
      date.set(Calendar.MINUTE, minuto);
      date.set(Calendar.SECOND, segundo);
      date.set(Calendar.MILLISECOND, 0);
      return date;
    }
    return null;
  }

  public static Calendar converterData(Date date) {
    if (date == null) {
      return null;
    }    
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
  }

  public static Date converterEmDate(String strData, String formato) {
    if (strData == null) {
      return null;
    }    
    Calendar calendar = converterData(strData, formato);
    return converterDate(calendar);
  }

  public static String formatarData(Date date, String formato) {
    if (date == null) {
      return null;
    }    
    Calendar calendar = converterData(date);
    return formatarData(calendar, formato);
  }
}
