package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabHomePage 
{
	@FindBy (xpath = "//div [@class='inventory_item_name ']") private List<WebElement> ProductName;
	@FindBy (xpath = "//div [@class='inventory_item_price']") private List<WebElement> ProductPrice;
	@FindBy (xpath = "//button [text()='Add to cart']") private List<WebElement> AddtoCart;
	@FindBy (xpath="//button[text()='Remove']") private List<WebElement> Remove;
	@FindBy (xpath = "//select [@class='product_sort_container']") private WebElement sort;
	@FindBy (xpath = "//img [@class='inventory_item_img']") private List<WebElement> Image;
	@FindBy (xpath = "//div [@class='inventory_item_desc']") private List<WebElement> Description;
	@FindBy (xpath = "// button [text()='Open Menu']") private WebElement Menu;
	@FindBy (xpath="//a[@id='inventory_sidebar_link']") private WebElement AllItems;
	@FindBy (xpath = "//a [@id='about_sidebar_link']") private WebElement About;
	@FindBy (xpath = "//a [@id='logout_sidebar_link']") private WebElement Logout;	
	@FindBy (xpath = "//a [@id='reset_sidebar_link']") private WebElement Reset;	
	@FindBy (xpath="//a[@class='shopping_cart_link']") private WebElement Cart;
	
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public String getProductName(int index)
	{
		return ProductName.get(index).getText();
	}
	public String[] getAllProductName() {
		String[] name= new String[ProductName.size()]; //array with fixed size int[] a = new int[5]
		for(int i=0;i<ProductName.size();i++)
		{
			name[i]= ProductName.get(i).getText();
		}
		 return name;				
	}
	public String getProductPrice(int index)
	{
		return ProductPrice.get(index).getText();
	}
	public double[] getAllProductPrice() {
		double[] price = new double[ProductPrice.size()];
		for(int i=0;i<ProductPrice.size();i++)
		{
			String amount=ProductPrice.get(i).getText().substring(1);
			price[i]=Double.parseDouble(amount);
		}
		return price;
	}
	
//	public void ClickonAddtoCart(int index)
//	{
//	    AddtoCart.get(index).click();
//	}
    public void ClickonAddtoCart(int index)
    {
    
    	AddtoCart.get(index).click();;
    }
	
	
	public void ClickonRemove(int index)
	{
	    Remove.get(index).click();
	}
//	public void sort(String text,WebDriver driver)
//	{
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(sort));
//		Select obj = new Select(sort);
//	    obj.selectByVisibleText(text);
//	}
	public void sort(String text,WebDriver driver)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(30000));
		wait.pollingEvery(Duration.ofMillis(1000));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(sort));
		Select obj = new Select(sort);
	    obj.selectByVisibleText(text);
	}
	public void ClickonMenu()
	{
	    Menu.click();
	}
	public void GetAllItems()
	{
		System.out.println( AllItems.getText());
	}
	public void ClickonAbout()
	{
	    About.click();
	}
	public void GetAbout()
	{
		System.out.println(About.getText()); 
	}
	
	public void ClickonLogout()
	{
	    Logout.click();
	}
	public void GetLogout()
	{
	    System.out.println(Logout.getText()); 
	}
	public void ResetAppState()
	{
		Reset.click();
	}
	public void GetReset() {
		System.out.println(Reset.getText());
	}
	public void ClickOnCart()
	{
		Cart.click();
	}
	

}
  