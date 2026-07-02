package com.amzon.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.basetest.BaseTest;

public class RegistrationPageTest extends BaseTest{

	@BeforeMethod
	public void setUpPage() {
		//open the Registration Page from Home Page Of Amazon
		homepage.openRegistrationpage();
	}
	@Test
	public void isLogoPresentTest() {
		homepage.openSignInpage();
		Assert.assertTrue(registrationPage.verifyLogo(),"Error ---Logo IS nOt Present");
	}
	
	@Test
	public void pageTitleTest() {
		assertEquals(registrationPage.getTitleOfThePage(),"Amazon Registration Page title Doesnot Match"+registrationPage.getTitleOfThePage());
		//assertEquals(registrationPage.getTitleOfThePage(), "Amazon Registration","Page Title Does Not Matched expected Page Title"+registrationPage.getTitle());
	}
	
	@Test
	public void verifyMobileNumberFunctinality() {
		registrationPage. verifyEmailAddress("demotest@gmail.com");
		Assert.assertEquals(registrationPage.getTitleOfThePage(),"registration PAge Title");
		registrationPage.verifyMobileNumberFuncationality("1234567890", "DemoName");
		//Assert Verify the authentication Page
			
		}
		
		
			
	@Test
	public void signInlinktest() {
		registrationPage.clickOnsighInlink();
			Assert.assertEquals(signInPage.getTitleOfThePage(), "Error---Sign In page Not opened After Clicking");
		}

	
	@Test
	public void createBussinessAccountTest() {
		registrationPage.clickOnCreateBussinessAccountLink();
			Assert.assertEquals(bussinessPage.getTitleOfThePage(), "Error---Bussiness page Not opened After Clicking");
		}
	
	@Test
	public void fieldsOnthePagetest() {
		registrationPage.verfyPrecenceOfElementsOnthePage();
	}
	}

