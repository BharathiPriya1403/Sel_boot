package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethod;
import Pages.LoginPage;
import utils.ReadExcel;

public class TC_EditIndividual extends ProjectSpecificMethod
{
	@Test(dataProvider = "fetchData", dependsOnMethods = {"testCase.TC_CreateIndividual.TC002"})
	public void TC001_EditInd(String usrname,String Paswrd,String frstName,String module,String gender) throws InterruptedException 
	{
		new LoginPage(driver, prop)
		.enterUsername(usrname)
		.enterPassword(Paswrd)
		.clickLoginButton()
		.clickToggle()
		.ClickViewAll()
		.SendIndividual(module)
		.IndividualsTab(frstName)
		.EditIndividual()
		.sendSalutation(gender)
		.sendFirstName(frstName)
		.ClickSave()
		.verifymessage();
	}

	@BeforeTest
	public void name() 
	{
		excelfilename = "EditIndividuals";
	}

}
