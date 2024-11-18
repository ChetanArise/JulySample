package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot 
{
	public static void clickScreenShot(WebDriver driver,String filename) throws IOException
	{
//		 driver = new ChromeDriver();
//		 driver.get("https://www.saucedemo.com/");
		 
		 File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File destination = new File("E:\\QA Batch\\SwagLab\\Screenshot\\"+filename+".png");
		 FileHandler.copy(source,destination);
		 
		
	}

}
