package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import Pages.NewAccountPage;
import Pages.NewAppointmentPage;
import Pages.VerifyPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateServiceAppointment extends BaseClass
{
	@And ("navigate to Appointments from App launcher")
	public void SendIndividual() throws InterruptedException
	{
	//click toggle button 
	driver.findElement(By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//label[text()='Search apps or items...']/following::input")).sendKeys("Service Appointments");;
	driver.findElement(By.xpath("//mark[text()='Service Appointments']")).click();
	}
	
	@And ("click New")
	public void Serviceappointment() 
	{
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
	}
	
	@Then("Enter the description")
	public void SendAppointmentData(DataTable table) 
	{
		List<List<String>> rows = table.asLists();
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(rows.get(0).get(0));
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("//span[@title='New Account']")).click();
	}
	
	@Then("Click newAccount")
	public void createnewaccount(DataTable table) 
	{
		List<List<String>> rows = table.asLists();
		driver.findElement(By.xpath("(//span[text()='Account Name']/following::input[@class=' input'])[1]")).sendKeys(rows.get(0).get(0));
		driver.findElement(By.xpath("//div[contains(@class,'modal-footer')]//span[text()='Save']")).click();
	}
	
	@And ("Give todays date")
	public void Gettodaysdate() throws InterruptedException 
	{
		driver.findElement(By.xpath("(//label[@class='form-element__label']/following::input[@class=' input'])[1]")).sendKeys(todaysdate());
		Thread.sleep(2000);
		WebElement findElement = driver.findElement(By.xpath("(//label[@class='form-element__label']/following::input[@class=' input'])[2]"));
		findElement.clear();
		findElement.sendKeys(timeString);
		driver.findElement(By.xpath("(//label[@class='form-element__label']/following::input[@class=' input'])[3]")).sendKeys(futureDate());
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	}
	@And ("Verify Service message")
	public void verifymessage() throws InterruptedException 
	{
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']")).getText();
        System.out.println(text);
	}

}
