package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethod;
import Pages.LoginPage;
import utils.ReadExcel;

public class DeleteIndividuals extends ProjectSpecificMethod
{

	@Test(dataProvider = "fetchData", dependsOnMethods = {"testCase.TC_EditIndividual.TC001_EditInd"})
	public void TC001_DElInd(String usrname,String Paswrd,String frstName,String module, String gender, String lastName) throws InterruptedException 
	{
		new LoginPage(driver, prop)
	    .enterUsername(usrname)
	    .enterPassword(Paswrd)
	    .clickLoginButton()
	    .clickToggle()
	    .ClickViewAll()
	    .SendIndividual(module)
	    .IndividualsTab(frstName)
	    .DelIndividual()
	    .verifymessage();
	}
	
	
	@BeforeTest
	public void name() 
	{
		excelfilename = "DeleteIndividuals";
	}
	
	
}
