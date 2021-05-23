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

public class ServiceAppointmet extends ProjectSpecificMethod

{
	@Test(dataProvider = "fetchData")
	public void TC001_ServApntmnt(String usrname,String Paswrd,String module,String Description,String AccName) throws InterruptedException 
	{
		new LoginPage(driver, prop)
		    .enterUsername(usrname)
		    .enterPassword(Paswrd)
		    .clickLoginButton()
		    .clickToggle()
		    .ClickViewAll()
		    .SendServiceAppointment(module)
            .Serviceappointment()
            .SendAppointmentData(Description)
            .createnewaccount(AccName)
            .gettodaysdate()
            .verifymessage();
	}
	
	@BeforeTest
	public void name() 
	{
		excelfilename = "ServiceAppointment";
	}
	

}
