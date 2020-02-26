package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoproject3.loginPage;
import utitlities.BaseClassDemo;
import utitlities.ExcelMethods;

public class loginpageTest extends BaseClassDemo {
	
	public loginPage loginpage;
	public ExcelMethods excel;
	
	public loginpageTest()
	{
		super();
	}
	
	@BeforeMethod
	
	public void launchApplication()
	{
		
		BaseClassDemo.initilaizedemo();
	}
	
	
	@Test
	
	public void loginintoApp() throws Throwable
	{
		loginpage=new loginPage();
		loginpage.trademart_loginbuttonn.click();
		excel=new ExcelMethods();
		Thread.sleep(2000);
		loginpage.loginpage_emailid.sendKeys("vinay");
		Thread.sleep(2000);
		loginpage.loginpage_password.sendKeys(excel.getData("LoginPage", 1, 1));
		Thread.sleep(2000);
		loginpage.loginpage_loginbutton.click();
		
		
		
	}
	
	@AfterMethod
	
	public void killapp()
	{
	driver.close();

}
}