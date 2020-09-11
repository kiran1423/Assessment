package com.pom.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testbase {
	
	public static Properties properties;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String currentdirctory = System.getProperty("user.dir");
	static String propertyFilePath= currentdirctory+"//src//main//java//com//pom//config//config.properties";

	
	public Testbase(){
		try {
			FileInputStream fis = new FileInputStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	
	public static String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public static String Path;
	public static String Sheet;
	
	public static void initialization()
	{
		
		String browser = properties.getProperty("browser");
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",properties.getProperty("driverPath"));
		driver = new ChromeDriver();
		}
		else if(browser.equals("FF"))
		{
		System.setProperty("webdriver.chrome.driver",properties.getProperty("driverPath"));
		driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String URL = getApplicationUrl();
		System.out.println(URL);
		driver.get(URL);
		
	}

}


