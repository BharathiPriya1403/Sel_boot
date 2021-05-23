package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Base.ProjectSpecificMethod;

public class NewAppointmentPage extends ProjectSpecificMethod
{
	public NewAppointmentPage(ChromeDriver driver, Properties prop)
	{
		this.driver = driver;
		this.prop = prop;
	}
	public NewAccountPage SendAppointmentData(String Description) 
	{
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(Description);
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("//span[@title='New Account']")).click();
		return new NewAccountPage(driver, prop);

	}

	public VerifyPage gettodaysdate() throws InterruptedException 
	{
		driver.findElement(By.xpath("(//label[@class='form-element__label']/following::input[@class=' input'])[1]")).sendKeys(todaysdate());
		Thread.sleep(2000);
		WebElement findElement = driver.findElement(By.xpath("(//label[@class='form-element__label']/following::input[@class=' input'])[2]"));
		findElement.clear();
		findElement.sendKeys(timeString);
		driver.findElement(By.xpath("(//label[@class='form-element__label']/following::input[@class=' input'])[3]")).sendKeys(futureDate());
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		return new VerifyPage(driver);
	}

}
