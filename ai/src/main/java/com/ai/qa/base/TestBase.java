package com.ai.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ai.qa.util.TimeOut;

public class TestBase {
	private static Logger log = LogManager.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		prop = new Properties();
		File src= new File("C:\\Users\\uswjnr67\\SLTP\\ai\\src\\main\\java\\com\\ai\\qa\\config\\config.properties");
		FileInputStream fis;
		try {
			log.debug("Trying to load Configuration properties file");
			fis = new FileInputStream(src);
			prop.load(fis);
			log.debug("Configuration properties file is loaded successfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("While trying to load configuration FileNotFoundException thrown ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.debug("While trying to load configuration IOException thrown ");
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String browser = prop.getProperty("browser");
		
	    if(browser.equalsIgnoreCase("chrome"))
	    {  System.out.println(browser);
	    	System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver.exe");
	    	driver = new ChromeDriver();
	      }
	    else if(browser.equals("FF"))
	    {
	    	System.setProperty("webdriver.gecko.driver","C:\\Users\\uswjnr67\\Documents\\selenium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
	    }
	    log.debug("Test started in  "+ browser+ "broswer");
	    driver.get(prop.getProperty("url"));
	    log.debug("Test Url is opened");
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TimeOut.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TimeOut.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		log.debug("All initialization done");
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	public String getExcelPath(String qaenvironment)
	{
		return prop.getProperty(qaenvironment);
	}
	public String getScreenPath()
	{ 
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
	    System.out.println(dateFormat.format(date)); //2016/11/16 12:08:4
        return "screen"+ dateFormat.format(date);
	}
}
