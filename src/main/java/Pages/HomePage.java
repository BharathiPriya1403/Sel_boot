package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod
{
	public HomePage(ChromeDriver driver,Properties prop) 
	{
		this.driver = driver;
		this.prop=prop;
	}
	public HomePage clickToggle() 
	{
		driver.findElement(By.xpath(prop.getProperty("Homepage.ClickToggle.xpath"))).click();
		return this;
	}
	
	public AppLauncherPage ClickViewAll()
	{
		driver.findElement(By.xpath("//button[text()='"+prop.getProperty("Homepage.ClickViewAll.Text")+"']")).click();
		return new AppLauncherPage(driver, prop);
	}
}
