package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod

{
	public LoginPage(ChromeDriver driver,Properties prop) 
	{
		this.driver=driver;
		this.prop=prop;
		
	}
	
	public LoginPage enterUsername(String usrname) 
	{
		driver.findElement(By.id(prop.getProperty("LoginPage.Username.ID"))).sendKeys(usrname);
		return this;
		
	}
	
	public LoginPage enterPassword(String Paswrd)
	{
		driver.findElement(By.id(prop.getProperty("LoginPage.password.ID"))).sendKeys(Paswrd);
		return this;
	}
	
	public HomePage clickLoginButton()
	{
		driver.findElement(By.id(prop.getProperty("LoginPage.Loginbutton.ID"))).click();
		return new HomePage(driver, prop);
	}

	
}

