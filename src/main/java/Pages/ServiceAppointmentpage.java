package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Base.ProjectSpecificMethod;

public class ServiceAppointmentpage extends ProjectSpecificMethod

{
	public ServiceAppointmentpage(ChromeDriver driver,Properties prop) 
	{
		this.driver=driver;
		this.prop=prop;
	}
	
	public NewAppointmentPage Serviceappointment() 
	{
		driver.findElement(By.xpath("//div[text()='New']")).click();
		return new NewAppointmentPage(driver, prop);
	}
	
	
	
}
