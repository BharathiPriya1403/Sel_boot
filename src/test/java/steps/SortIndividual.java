package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Pages.IndividualsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SortIndividual extends BaseClass
{
	@And ("navigate to individuals from App launcher for sorting")
	public void SendIndividual() throws InterruptedException
	{
	//click toggle button 
	driver.findElement(By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//label[text()='Search apps or items...']/following::input")).sendKeys("Individuals");;
	driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
	
	}
	
	@Then ("Sort the name")
	public void ClickNameSort() throws InterruptedException 
	{
		Actions action = new Actions(driver);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Name']"))).click().perform();
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
		
	}
	
}
