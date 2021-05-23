package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateIndividual extends BaseClass

{

	@And ("navigate to individuals from App launcher")
	public void SendIndividual() throws InterruptedException
	{
	//click toggle button 
	driver.findElement(By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//label[text()='Search apps or items...']/following::input")).sendKeys("Individuals");;
	driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
	
	
	}
	
	@And ("Click on the Dropdown icon in the Individuals tab")
	public void clickdrpdwn() 
	{
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']")).click();
	    
	}
	
	@And ("Click on New Individual")
	public void NewIndividualPopup() 
	{	
	WebElement findElement = driver.findElement(By.xpath("//span[text()='New Individual']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", findElement);
	}
	
	@Then("^give data for first name and last name as$")
	public void givedata(DataTable table)
	{
		List<List<String>> rows = table.asLists();
		driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
		driver.findElement(By.linkText("Mr.")).click();
		driver.findElement(By.xpath("(//span[text()='*']/following::input)[1]")).sendKeys(rows.get(1).get(0));
		driver.findElement(By.xpath("(//span[text()='*']/following::input)[2]")).sendKeys(rows.get(1).get(1));
	}
	
	@And ("Click on Save")
	public void ClickSave()
	{
		driver.findElement(By.xpath("//button[@title='Save']")).click();
	}
	
	@And ("Verify message")

	public void verifymessage() throws InterruptedException 
	{
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']")).getText();
        System.out.println(text);
	}
	
	
}
