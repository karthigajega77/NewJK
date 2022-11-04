package org.base;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	//Browser launch
//	public static WebDriver launchBrowser() {
//		WebDriverManager.chromedriver().setup();
//	     WebDriver driver = new ChromeDriver();
//		return driver;
//	

//	}
//	public static WebDriver launchBrowse(String browsername) 
//	{
//		if (browsername.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver =new ChromeDriver();
//		}
//	
//			else if (browsername.equalsIgnoreCase("firefox"))
//			{
//		
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//			}
//			else if (browsername.equalsIgnoreCase("edge"))
//			{
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//			}
//			else
//			{
//				System.out.println("Invalid Browser");
//			}
//		return driver;
//		}
//
//	}
	public static WebDriver launchBrowser(String browserName)
	{
		switch (browserName)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
			break;
				
		}
		return driver;

	}
//url launch
	public static void launchUrl(String Url)
	{
		driver.get(Url);
		driver.manage().window().maximize();

	}
	//wait
	public static void implicityWait(long sec) 
	{
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);

	}
		//getTitle
	public static String getTitle()
	{
		String title = driver.getTitle();
		return title;
		
	}
	//getCurrentUrl
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}
	//close
	public static void close() {
		driver.close();

	}
	//sendkeys
	public static void Sendkeys(WebElement e, String name)
	{
		
		e.sendKeys(name);
	}
	//click
	public static void click(WebElement e) {
		e.click();

	}
	//getText
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	
	//getAttribute
	public static String getAttribute(WebElement e)
	{
		String attribute = e.getAttribute("value");
		return attribute;

	}
	
	//Actions
	//MovetoEelement
	public static void MovetoELement(WebElement e) {
	Actions a = new Actions(driver);
	a.moveToElement(e).perform();

	}
	//dragAndDrop
	public static void dragAndDrop(WebElement e1, WebElement e2) {
		Actions a = new Actions(driver);
		a.dragAndDrop(e1, e2);

	}
	//select
	//selectByIndex
	public static  void SelectByIndex(WebElement e, int index)
	{
		Select s =new Select(e);
		s.selectByIndex(index);

	}
	//findelement
	public static WebElement findElement(String locatorName, String Value)
	{
      WebElement value =null;
      if(locatorName.equals("id"))
      {
    	  value = driver.findElement(By.id(Value));
      }
      else if (locatorName.equals("name"))
      {
    	  value= driver.findElement(By.name(Value));
      }
      else if (locatorName.equals("xpath"))
      {
    	   value = driver.findElement(By.xpath(Value));
      }
	return value;
      }
	//quite
		public static void quite() {
			driver.quit();

		}	
		//contextclick
		public static void contextClick(WebElement e) 
		{
		Actions a =new Actions(driver);
         a.contextClick(e).perform();
		}
		//double click
		public static void doubleClick(WebElement e) {
			Actions a = new Actions(driver);
			a.doubleClick(e).perform();

		}
	
}

