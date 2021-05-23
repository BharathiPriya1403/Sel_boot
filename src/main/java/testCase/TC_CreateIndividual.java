package testCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.ProjectSpecificMethod;
import Pages.LoginPage;
import utils.ReadExcel;

public class TC_CreateIndividual extends ProjectSpecificMethod
{
	

	
	
	@Test(dataProvider = "fetchData")
	public void TC002(String usrname,String Paswrd,String frstName,String module,String gender, String LstName) throws InterruptedException 
	{
		new LoginPage(driver, prop)
		    .enterUsername(usrname)
		    .enterPassword(Paswrd)
		    .clickLoginButton()
		    .clickToggle()
		    .ClickViewAll()
		    .SendIndividual(module)
		    .clickdrpdwn()
		    .clickNew()
		    .sendSalutation(gender)
		    .sendFirstName(frstName)
		    .sendLastName(LstName)
		    .ClickSave()
		    .verifymessage();
	}
	
	@BeforeTest
	public void name() 
	{
		excelfilename = "CreateIndividuals";
	}
	
//	@DataProvider(name = "fetchData")
//	public  String[][] setFile() throws InvalidFormatException, IOException {
//		excelfilename = "CreateIndividuals";
//		ReadExcel re = new ReadExcel();
//		return re.readData(excelfilename);

//	}
}
