package com.amazon.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utils.ConfigReader;
import com.amazon.utils.CustomWait;

public class BasePage {

	protected WebDriver driver;
	protected CustomWait wait;
	@FindBy(xpath="//a[@href=\"/ref=ap_frn_logo\"]")
	private WebElement logo;
	protected ConfigReader configReader;
	
	//Constructor
	public BasePage(WebDriver driver) {
		this.driver=driver;
		configReader = new ConfigReader();
		PageFactory.initElements(driver, this);
		this.wait=new CustomWait(driver,Duration.ofSeconds(configReader.getGlobalWaitValue()));
	}
	
	public WebDriver getdriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
			/*
			 * ChromeOptions options=new ChromeOptions();
			 * options.addArguments("--incognito"); driver= new ChromeDriver(options);
			 */
			 
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			
			driver= new EdgeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		
		return driver;
	}
	
	
	public WebElement getLogo() {
		wait.waitForVisibilityOfElement(logo);
		return logo;
	}
	
	//Close Browser
	public void quiteDriver() {
		
		driver.close();
	}
	
	public boolean verifyLogo(){
		return getLogo().isDisplayed();
	}
	
	public String getTitleOfThePage() {
		
		return driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}


	public void navigateToBack() {
		// TODO Auto-generated method stub
		driver.navigate().back();
		
	}


	public void naviagetToForward() {
		// TODO Auto-generated method stub
		driver.navigate().forward();
		
	}


	public void refresh() {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
	}


	
}
