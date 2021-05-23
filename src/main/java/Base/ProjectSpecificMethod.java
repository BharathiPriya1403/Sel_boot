package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class ProjectSpecificMethod 
{
	public ChromeDriver driver;
	public Properties prop;
	public static String url = "https://login.salesforce.com";
	public String excelfilename;
	public String timeString;
	

	@BeforeMethod
	public void Startapp() throws IOException 
	{
		
		File src = new File("./src/main/resources/English.properties") ;
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}

	@AfterMethod
	public void CloseApp() 
	{
		driver.close();
	}
	
	
	@DataProvider(name="fetchData")
	public  String[][] SendData() throws InvalidFormatException, IOException 
	{
		ReadExcel re = new ReadExcel();
		return re.readData(excelfilename);
		
	}


	public String todaysdate() 
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
