package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCartPage {
@FindBy (xpath="//div[@class='cart_item']")private List<WebElement> CartItem;
@FindBy (xpath = "//div [@class='inventory_item_name ']") private List<WebElement> ProductName;

public SwagLabCartPage(WebDriver driver) {
  PageFactory.initElements(driver,this);
}

public int getCartItem()
{
	return CartItem.size();
}
public String getProductName(int index)
{
	return ProductName.get(index).getText();
}

}
