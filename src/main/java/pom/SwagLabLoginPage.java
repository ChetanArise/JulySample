package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{
	@FindBy (xpath = "//input [@data-test='username']") private WebElement username;
	@FindBy (xpath = "//input [@data-test='password']") private WebElement password;
	@FindBy (xpath ="//input [@data-test='login-button']") private WebElement Login;
	@FindBy (xpath = "//h3[@data-test='error']") private WebElement warning;
	
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void enterUsername(String user)
	{
		username.sendKeys(user);
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void ClickOnLogin()
	{
		Login.click();;
	}
	public boolean isWarningLabelDisplayed() 
	{
     try {
	 return warning.isDisplayed();
         }
     catch (Exception e)  {
	 return false;
        }
	}
	public String getWarningMessage() 
	{
		return warning.getText();
	}	
}
