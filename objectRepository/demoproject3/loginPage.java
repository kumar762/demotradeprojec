package demoproject3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utitlities.BaseClassDemo;

public class loginPage extends BaseClassDemo {
	
	@FindBy(xpath="//a[contains(text(),'Log in')]")public WebElement trademart_loginbuttonn;
	@FindBy(name="email") public WebElement loginpage_emailid;
	@FindBy(xpath="//input[@id='password']") public WebElement loginpage_password;
	@FindBy(id="submitLogin") public WebElement loginpage_loginbutton;
	@FindBy(xpath="//a[@class='frgt-pass']") public WebElement loginpage_forgeotpassword;
	
	
	public loginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
}
