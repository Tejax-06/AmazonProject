package com.amazon.pages;




import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.BasePage;

public class HomePage extends BasePage{

	private Actions action;
	//Account And List DropDownbutton
	
	@FindBy(xpath="//div//span[contains(text(),\"Account & Lists\")]")
	public WebElement AccountAndLists;
	
	//Sign In Button
	
	@FindBy(xpath="//div[@id=\"nav-flyout-ya-signin\"]")
	public WebElement SignIn_btn;
	
	//newCustomerStrtHere
	
	@FindBy(xpath="//div[@id=\"nav-flyout-ya-newCust\"]")
	public WebElement NewCustomeStartHere_lnk;
	
	@FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
	 public WebElement SearchBox_textField;
	
	@FindBy(xpath="//a[@id=\"nav-logo-sprites\"]")
	public WebElement amazonlogoHomepage;
	
	@FindBy(xpath="//a//h5[text()=\"Amazon Music\"]")
	public WebElement AmazonMusic_link;
	
	
	//consstructor
	
	/**
	 * Creted By:- Tejas Karale
	 *Add this to wait till page is get fully loaded thats why verifying logo
	 * @return 
	 */
	
	public WebElement getAmazonMusic_link() {
		wait.waitForVisibilityOfElement(AmazonMusic_link);
		return AmazonMusic_link;
	}
	
	public WebElement getAmazonlogoHomepage() {
		wait.waitForVisibilityOfElement(amazonlogoHomepage);
		return amazonlogoHomepage;
	}


	public Actions getAction() {
		return action;
	}


	public WebElement getSearchBox_textField() {
		wait.waitForVisibilityOfElement(SearchBox_textField);
		return SearchBox_textField;
	}


	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		 action= new Actions(driver);
	}
	
	
	public WebElement getAccountAndLists() {
		wait.waitForVisibilityOfElement(AccountAndLists);
		return AccountAndLists;
	}


	public WebElement getSignIn_btn() {
		wait.waitForInvisibilityOFElemnt(SignIn_btn);
		return SignIn_btn;
	}


	public WebElement getNewCustomeStartHere_lnk() {
		wait.waitForVisibilityOfElement(NewCustomeStartHere_lnk);
		return NewCustomeStartHere_lnk;
	}

//Actions Methods
	//open Registration Page
	public void openRegistrationpage() {
		action.moveToElement(getAccountAndLists()).perform();
		//
	}

	public void openSignInpage() {
		// TODO Auto-generated method stub
		action.moveToElement(getAccountAndLists()).perform();
        SignIn_btn.click();
	}
	
	public void SerachTheItemAndVerifyByText(String searchProduct) {
		 SearchBox_textField.sendKeys(searchProduct);
		 SearchBox_textField.sendKeys(Keys.ENTER);
	}
	
	

     public String getTitleOfThePage() {
		
	
       return driver.getTitle(); 
     }
}