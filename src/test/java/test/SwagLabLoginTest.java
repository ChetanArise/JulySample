package test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.browser;
import pom.SwagLabLoginPage;
import utility.Parameterization;
import utility.Reports;

@Listeners (test.Listeners.class)
public class SwagLabLoginTest extends BaseTest
{
	
	@BeforeMethod
	public void LaunchApplication()
	{
		driver =browser.openbrowser();		
	}
//	@AfterMethod

	
	@Test
	public void verifyIfUserIsAbleToLoginWithValidCredentials() throws IOException
	{
		test=reports.createTest("verifyIfUserIsAbleToLoginWithValidCredentials");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername(Parameterization.getStringdata("Sheet1",0,0));
		swagLabLoginPage.enterPassword(Parameterization.getStringdata("Sheet1",0,1));
		swagLabLoginPage.ClickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
	}
	@Test
	public void verifyIfWarningMessageIsDisplayedForLockedUser() throws IOException
	{
		test=reports.createTest("verifyIfWarningMessageIsDisplayedForLockedUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername(Parameterization.getStringdata("Sheet1",1,0));
		swagLabLoginPage.enterPassword(Parameterization.getStringdata("Sheet1",0,1));
		swagLabLoginPage.ClickOnLogin();	
		SoftAssert obj = new SoftAssert();
		obj.assertFalse(swagLabLoginPage.isWarningLabelDisplayed());
		obj.assertEquals(swagLabLoginPage.getWarningMessage(),"Epic sadface: Sorry, this user has been locked out.");
		System.out.println("Validation done");
		obj.assertAll();
//		Assert.assertFalse(swagLabLoginPage.isWarningLabelDisplayed());
//		Assert.assertEquals(swagLabLoginPage.getWarningMessage(),"Epic sadface: Sorry, this user has been locked out.");
	
	}
}
