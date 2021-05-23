package steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass 
{
	public static RemoteWebDriver driver;
	 public static WebDriverWait wait;
	 public String timeString;
	  
	  public String todaysdate() throws InterruptedException 
		{
			SimpleDateFormat dformat = new SimpleDateFormat("MM/dd/yyyy");
			DateFormat tformat= new SimpleDateFormat("hh:mm aa");
			timeString = tformat.format(new Date()).toString();
			Date date = new Date();
			String format = dformat.format(date);
			return format;
		}
	  
	  public String futureDate() 
		{
			SimpleDateFormat dformat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar adddate = Calendar.getInstance();
			adddate.setTime(new Date());
			adddate.add(Calendar.DATE, 5);
			String format = dformat.format(adddate.getTime());
			return format;
		}

}
