package com.amzon.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.basetest.BaseTest;

public class HomePageTest extends BaseTest {

	@Test	
	
	
	/**
	 * Verify SUer Is able to serch the item
	 *Open Browser
	 *Serch ip[hone
	 *Get list of web element
	 *Veriy it contains iphine text
	 */
	public void VerifyUserCanSearchItem()  {
		//Thread.sleep(3000);
		homepage.getAmazonlogoHomepage();
		Assert.assertEquals(homepage.getTitleOfThePage(),"Amazon.com. Spend less. Smile more.","Heading Is not Expected");
		
	  homepage.SerachTheItemAndVerifyByText("iphone");
	  List<WebElement> productTitles = driver.findElements(By.xpath("//a//h2//span"));
	  String searchItem = "iphone";

	  for (WebElement product : productTitles) {

	      String actualText = product.getText();
	      System.out.println(actualText);

	      Assert.assertTrue(
	          actualText.toLowerCase().contains(searchItem.toLowerCase()),
	          "Product title does not contain: " + searchItem
	      );
	  }
	  
	}
	
	  @Test
	  public void verifyAmazonMusicLink() throws InterruptedException {
		  homepage.getAmazonlogoHomepage();
		  homepage.AmazonMusic_link.click();
		  Thread.sleep(3000);
		 String title2= homepage.getTitleOfThePage();
		 Assert.assertEquals(title2, "Amazon Music Unlimited | Stream 100 Million Songs & Podcasts"
		 		, "Title found");
		  System.out.println(title2);
	  }
}
