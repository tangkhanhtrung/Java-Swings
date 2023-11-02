package Btcuoiky;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
 
public class DateUtil {
		  	
	  public int getDays(int year, int month) {
		  Calendar cal = Calendar.getInstance();		  		  
		  cal.set(year, month, 1);
		  int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);		  
		  return days;
	  }
	  
	  public String getDayOfWeek(int y, int m, int d) {		  
		  String dateString = String.format("%d-%d-%d", y, m, d);		  
		  Date date;		  
		  String dayOfWeek = "";
		  try {			
			date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
			// Then get the day of week from the Date based on specific locale.
			dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
			
		  } catch (ParseException e) {			
			e.printStackTrace();
		  }
		  return dayOfWeek;
	  }
}
