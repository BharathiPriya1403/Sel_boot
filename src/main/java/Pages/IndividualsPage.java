package Pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.ProjectSpecificMethod;
import io.cucumber.java.en.Then;

public class IndividualsPage extends ProjectSpecificMethod 
{
	public IndividualsPage(ChromeDriver driver, Properties prop)
	{
		this.driver = driver;
		this.prop = prop;
	}
	public IndividualsPage clickdrpdwn()
	{
		driver.findElement(By.xpath(prop.getProperty("IndividualsPage.clickdrpdwn.xpath"))).click();
		return this;
	}

	public NewIndividualPage clickNew() 
	{
		WebElement findElement = driver.findElement(By.xpath("//span[text()='"+prop.getProperty("NewIndividualPage.clickNew.Text")+"']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", findElement);
		return new NewIndividualPage(driver);
	}
	
	public IndividualsPage IndividualsTab(String frstName) throws InterruptedException 
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("IndividualsPage.IndividualsTab.xpath")))).sendKeys(frstName);
        driver.findElement(By.xpath(prop.getProperty("IndividualsPage.IndividualsTab.xpath"))).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);		
		WebElement drpDwn = driver.findElement(By.xpath("//span[text()='"+prop.getProperty("IndividualsPage.IndividualsTab.drpDwn")+"']/ancestor::a[1]"));
		driver.executeScript("arguments[0].click();", drpDwn);
		return this;
	}
	
	public NewIndividualPage EditIndividual() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='"+prop.getProperty("NewIndividualPage.EditIndividual.title")+"']")).click();
		return new NewIndividualPage(driver);
	}
	
	public VerifyPage DelIndividual() 
	{
		driver.findElement(By.xpath("//a[@title='"+prop.getProperty("NewIndividualPage.VerifyPage.DelIndividual.title")+"']")).click();
		driver.findElement(By.xpath("//span[text()='"+prop.getProperty("NewIndividualPage.VerifyPage.DelIndividual.text")+"']")).click();
		return new VerifyPage(driver);
	}
	
	
	public IndividualsPage ClickNameSort() throws InterruptedException 
	{
		Actions action = new Actions(driver);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='"+prop.getProperty("NewIndividualPage.ClickNameSort.text")+"']"))).click().perform();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Name']"))).click();
		List<String> AddRowval = new ArrayList<String>();
		List<String> ComRowval = new ArrayList<String>();
		List<WebElement> Names = driver.findElements(By.xpath("//th[@scope='row']"));
		for (WebElement i : Names) 
		{
			AddRowval.add(i.getText());
			
		}
		ComRowval.addAll(AddRowval);
		Collections.sort(ComRowval);
		System.out.println(AddRowval + "  " + ComRowval);
		System.out.println(AddRowval.equals(ComRowval));
		return new IndividualsPage(driver, prop);
	}
	

}
