package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Base.ProjectSpecificMethod;

public class NewAccountPage extends ProjectSpecificMethod
{
	public NewAccountPage(ChromeDriver driver,Properties prop) 
	{
		this.driver = driver;
		this.prop=prop;
	}
	public NewAppointmentPage createnewaccount(String AccName) 
	{
		try 
		{
			driver.findElement(By.xpath("(//span[text()='Account Name']/following::input[@class=' input'])[1]")).sendKeys(AccName);
			driver.findElement(By.xpath(prop.getProperty("NewAccountPage.createnewaccount.Save"))).click();
		} 
		catch (ElementClickInterceptedException e) 
		{
			System.out.println("ClickSave - NotSucessfull"+ e.getMessage());
			throw new RuntimeException();
		}
		return new NewAppointmentPage(driver,prop);
	}


}
