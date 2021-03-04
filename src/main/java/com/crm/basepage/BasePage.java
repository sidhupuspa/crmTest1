package com.crm.basepage;

import java.beans.EventHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.utils.TestUtils;
import com.crm.utils.WebEventListener;



public class BasePage {
	public static WebDriver driver;
	public static Properties prop;
	public FileInputStream flib;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	public BasePage()

	{
		try{
			prop=new Properties();
			FileInputStream flib= new FileInputStream("../FreeCrmTestSuite/src/data/commondata.properties");
			prop.load(flib);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e2)
		{
			e2.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\testing\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			driver=new InternetExplorerDriver();
	}
		e_driver=new EventFiringWebDriver(driver);
		eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
	driver.manage().window().maximize();
	driver=e_driver;
	driver.manage().deleteAllCookies();
	/*
	 * implicit wait time would be short for every element and it would be large for specific element,
	 * The pageLoadTimeout limits the time that the script allots for a web page to be displayed.
	 *  If the page loads within the time then the script continues.
	 */
	driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait, TimeUnit.SECONDS);

	//lunch url
	driver.get(prop.getProperty("url"));

	}
	public static void closeBrowser()
	{
		driver.quit();
	}
}
