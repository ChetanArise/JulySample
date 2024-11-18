package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.browser;
import pom.SwagLabCartPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;
import utility.Parameterization;
@Listeners (test.Listeners.class)
public class CartTest extends BaseTest {
	
	@BeforeMethod
	public void LaunchApplication()  throws IOException,InterruptedException
	{
		driver =browser.openbrowser();	
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername(Parameterization.getStringdata("Sheet1",0,0));
		swagLabLoginPage.enterPassword(Parameterization.getStringdata("Sheet1",0,1));
		swagLabLoginPage.ClickOnLogin();		
	}
	@Test
	public void verifyIfUserIsAbleToAddProductToCart() throws InterruptedException
	{
		test=reports.createTest("verifyIfUserIsAbleToAddProductToCart");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.ClickonAddtoCart(0);
		swagLabHomePage.ClickonAddtoCart(0);
		swagLabHomePage.ClickonAddtoCart(0);
		swagLabHomePage.ClickonAddtoCart(0);
		swagLabHomePage.ClickonAddtoCart(0);
		swagLabHomePage.ClickonAddtoCart(0);
		String ProductName1 = swagLabHomePage.getProductName(0);
		String ProductName2 = swagLabHomePage.getProductName(1);
		String ProductName3 = swagLabHomePage.getProductName(2);
		String ProductName4 = swagLabHomePage.getProductName(3);
		String ProductName5 = swagLabHomePage.getProductName(4);
		String ProductName6 = swagLabHomePage.getProductName(5);
		swagLabHomePage.ClickOnCart();
		SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
		Assert.assertEquals(swagLabCartPage.getCartItem(),5);
		Assert.assertEquals(swagLabCartPage.getProductName(0), ProductName1);
		Assert.assertEquals(swagLabCartPage.getProductName(1), ProductName2);
		Assert.assertEquals(swagLabCartPage.getProductName(2), ProductName3);
		Assert.assertEquals(swagLabCartPage.getProductName(3), ProductName4);
		Assert.assertEquals(swagLabCartPage.getProductName(4), ProductName5);
		Assert.assertEquals(swagLabCartPage.getProductName(5), ProductName6);		
	}	
	@Test 
	public void verifyIfUserIsAbleToRemoveProduct() throws InterruptedException
	{
		test=reports.createTest("verifyIfUserIsAbleToRemoveProduct");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		
		  swagLabHomePage.ClickonAddtoCart(0);
		  swagLabHomePage.ClickonAddtoCart(0);
		  swagLabHomePage.ClickonAddtoCart(0);
		  swagLabHomePage.ClickonAddtoCart(0);
		  swagLabHomePage.ClickonAddtoCart(0);
		  swagLabHomePage.ClickonAddtoCart(0);
		
		  Thread.sleep(2000);
		  swagLabHomePage.ClickonRemove(0);
		  swagLabHomePage.ClickonRemove(0);
		  swagLabHomePage.ClickonRemove(0);
		  swagLabHomePage.ClickonRemove(0);
		  swagLabHomePage.ClickonRemove(0);
		  swagLabHomePage.ClickonRemove(0);
		
	}
	
}
