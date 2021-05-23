package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Base.ProjectSpecificMethod;

public class VerifyPage extends ProjectSpecificMethod
{
	public VerifyPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	

	public void verifymessage() throws InterruptedException 
	{
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']")).getText();
        System.out.println(text);
	}
	
//	public void verifymessageTwo() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		String text = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']")).getText();
//		String msgVer = driver.findElement(By.xpath("(//span/span[contains(text(), 'SA')])[2]")).getText();
//		System.out.println(text.contains(msgVer));
//	}
}
