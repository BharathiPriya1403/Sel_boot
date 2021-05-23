package Pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Base.ProjectSpecificMethod;
import utils.ReadProp;

public class AppLauncherPage extends ProjectSpecificMethod
{
	
	
	public AppLauncherPage(ChromeDriver driver,Properties prop) 
	{
		this.driver = driver;
		this.prop=prop;
	}
	public IndividualsPage SendIndividual(String module) throws InterruptedException 
	{
		
	    //Individuals
		driver.findElement(By.xpath(prop.getProperty("AppLauncherPage.SendIndividual.Text"))).sendKeys(module);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mark[text()='"+module+"']")).click();
		return new IndividualsPage(driver, prop);
	}
	
	public ServiceAppointmentpage SendServiceAppointment(String module) throws InterruptedException 
	{   //Service Appointments
		driver.findElement(By.xpath("//label[text()='"+prop.getProperty("AppLauncherPage.SendServiceAppointment.Text")+"']/following::input")).sendKeys(module);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p/mark[text()='"+module+"']")).click();
		return new ServiceAppointmentpage(driver,prop);
	}

}
