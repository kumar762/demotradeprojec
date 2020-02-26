package utitlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClassDemo {
	
	public static WebDriver driver;
	public static Actions action;
	public static Properties prop;
	
	
	public BaseClassDemo()
	{
		try
		{
			prop=new Properties();
			
			FileInputStream fis=new FileInputStream("D:\\Vinaykumar\\demoproject3\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		}
	
	
	public static void initilaizedemo()
	{
		
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\jars\\drivers\\80 version driver\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	//overloaded methods
	
	public static void navigateMethod(WebElement element1)
	{
		action=new Actions(driver);
		action.moveToElement(element1).click().build().perform();
		
	}
	
	public static void navigateMethod(WebElement element1,WebElement element2)
	{
		action=new Actions(driver);
		action.moveToElement(element1).build().perform();
		action.moveToElement(element2).click().build().perform();

		
	}

}
