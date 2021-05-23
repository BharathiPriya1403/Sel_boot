package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificMethod;

public class NewIndividualPage extends ProjectSpecificMethod
{
	public NewIndividualPage(ChromeDriver driver) 
	{
		this.driver = driver;
	}
	public NewIndividualPage sendSalutation(String gender)
	{
		try 
		{
			driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
			driver.findElement(By.linkText(gender)).click();
			System.out.println("SendSalutation-Sucessfull");
		} 
		catch (Exception e) 
		{
			System.out.println("SendSalutation-NotSucessfull");
		}
		
		return this;
	}

	public NewIndividualPage sendFirstName(String frstName)
	{

		driver.findElement(By.xpath("(//span[text()='*']/following::input)[1]")).sendKeys(frstName);
		return this;
	}

	public NewIndividualPage sendLastName(String LstName)
	{
		driver.findElement(By.xpath("(//span[text()='*']/following::input)[2]")).sendKeys(LstName);
		return this;
	}

	public VerifyPage ClickSave()
	{
		try 
		{
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			System.out.println("ClickSave - Sucessfull");
		} 
		catch (Exception e)
		{
			System.out.println("ClickSave - NotSucessfull");
		}

		return new VerifyPage(driver);
	}

	public NewIndividualPage errormessage() 
	{
		
		try 
		{
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			System.out.println("ClickSave - Sucessfull");
			String text = driver.findElement(By.xpath("//span[text()='Review the errors on this page.']")).getText();
			System.out.println(text);
		} 
		catch (ElementNotInteractableException e) 
		{
			System.out.println("ClickSave - NotSucessfull"+ e.getMessage());
			throw new RuntimeException();
			
		}
		
		return this;
	}

}
