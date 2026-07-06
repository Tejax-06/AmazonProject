package com.amazon.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.amazon.base.BasePage;
import com.amazon.pages.BussinessPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.RegistrationPage;
import com.amazon.pages.SignInPage;
import com.amazon.utils.ConfigReader;

public class BaseTest {

	
	public BasePage basepage;
	public WebDriver driver;
	public RegistrationPage registrationPage;
	//public SignInPage signInpage;
	public HomePage homepage;
	public BussinessPage bussinessPage;
	public SignInPage signInPage;
	public 	ConfigReader configReader;
	
	@BeforeMethod (alwaysRun=true)
	public void baseSetUp() {
		 configReader=  new ConfigReader();
		basepage = new BasePage(driver);
		driver =basepage.getdriver(configReader.getBrowser());
		
	   
	    driver.get(configReader.getUrl());
      	driver.manage().window().maximize();
		//driver.get("https://www.amazon.in/");
		
		registrationPage = new RegistrationPage(driver);
		signInPage= new SignInPage(driver);
		homepage=new HomePage(driver);
		bussinessPage=new BussinessPage(driver);
		
	}
	
	/*
	 * @AfterMethod (alwaysRun=true)
	 * 
	 * public void closeBrowser() { basepage.quiteDriver(); }
	 */
	
	
}
