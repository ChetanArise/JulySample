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
public class SwagLabHomeTest extends BaseTest {
WebDriver driver;
	
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
	public void VerifySortFeatureForZtoA()throws InterruptedException{
		test=reports.createTest("VerifySortFeatureForZtoA");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		String[] name = swagLabHomePage.getAllProductName();
		swagLabHomePage.sort("Name (Z to A)", driver);
		String[] sortedNames = swagLabHomePage.getAllProductName();
		Assert.assertEquals(name[0],sortedNames[5]);
		Assert.assertEquals(name[1],sortedNames[4]);
		Assert.assertEquals(name[2],sortedNames[3]);
		Assert.assertEquals(name[3],sortedNames[2]);
		Assert.assertEquals(name[4],sortedNames[1]);
		Assert.assertEquals(name[5],sortedNames[0]);
		Thread.sleep(3000);
	}
	@Test
	public void VerifySortFeatureForAtoZ() throws InterruptedException{
		test=reports.createTest("VerifySortFeatureForAtoZ");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.sort("Name (Z to A)", driver);
		String[] name = swagLabHomePage.getAllProductName();
		swagLabHomePage.sort("Name (A to Z)", driver);
		String[] sortedNames = swagLabHomePage.getAllProductName();
		Assert.assertEquals(name[0],sortedNames[5]);
		Assert.assertEquals(name[1],sortedNames[4]);
		Assert.assertEquals(name[2],sortedNames[3]);
		Assert.assertEquals(name[3],sortedNames[2]);
		Assert.assertEquals(name[4],sortedNames[1]);
		Assert.assertEquals(name[5],sortedNames[0]);
		Thread.sleep(3000);
}
	@Test
	public void VerifySortFeatureForPriceLowToHigh() throws InterruptedException
	{
		test=reports.createTest("VerifySortFeatureForPriceLowToHigh");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.sort("Price (low to high)", driver);
		double[] price =swagLabHomePage.getAllProductPrice();
		Assert.assertTrue(price[0]<price[1] && price[1]<price[2] &&price[2]<price[3] &&price[3]<price[4] &&price[4]<price[5]);
		Thread.sleep(3000);
	}
	@Test
	public void VerifySortFeatureForPriceHighToLow() throws InterruptedException
	{
		test=reports.createTest("VerifySortFeatureForPriceHighToLow");
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.sort("Price (high to low)", driver);
		double[] price =swagLabHomePage.getAllProductPrice();
		Assert.assertTrue(price[0]>price[1] && price[1]>price[2] &&price[2]>price[3] &&price[3]>price[4] &&price[4]>price[5]);
	}
	@Test
	public void verifyOnClickMenuAllTheMenuOptionsAreDisplayed()
	{
		test=reports.createTest("verifyOnClickMenuAllTheMenuOptionsAreDisplayed");
	 SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
	 swagLabHomePage.ClickonMenu();	
	 swagLabHomePage.GetAllItems();
	 swagLabHomePage.GetAbout();
	 swagLabHomePage.GetLogout();
	 swagLabHomePage.GetReset();
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
	      Thread.sleep(2000);
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
	 @Test (enabled = false)
	    public void verifyRemoveButton() throws IOException,InterruptedException
	    {
		 test=reports.createTest("verifyRemoveButton");
	    	SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
	    	swagLabHomePage.ClickonAddtoCart(0);
	    	Thread.sleep(2000);
	    	swagLabHomePage.ClickonAddtoCart(1);
	    	Thread.sleep(2000);
	    	swagLabHomePage.ClickonAddtoCart(2);
	    	Thread.sleep(2000);
	    	
	    	swagLabHomePage.ClickonRemove(0);
	    	Thread.sleep(2000);
	    	swagLabHomePage.ClickonRemove(1);
	    	Thread.sleep(2000);
	    	swagLabHomePage.ClickonRemove(2);
	    	Thread.sleep(2000);
	    }
	
	    @Test (enabled = false)
	    public void verifyOnClickAboutUserIsDirectedToAnotherPage() throws InterruptedException,IOException
	    {
	    	test=reports.createTest("verifyOnClickAboutUserIsDirectedToAnotherPage");
	    	SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
	    	swagLabHomePage.ClickonMenu();
	    	swagLabHomePage.ClickonAbout();
	    	Thread.sleep(3000);
	    	Assert.assertEquals(driver.getCurrentUrl(),"https://saucelabs.com/");
	    }
	    @Test
	    public void verifyOnClickLogoutUserIsSuccessfullyLogout() {
	    	test=reports.createTest("verifyOnClickLogoutUserIsSuccessfullyLogout");
	    	SwagLabHomePage swagLabHomePage= new SwagLabHomePage(driver);
	    	swagLabHomePage.ClickonMenu();
	    	swagLabHomePage.ClickonLogout();
	    	Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
	    }
	    
	    
}