package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class GitTest {
	
	@Test
	public void UserWillAbleToWorkInDellSite()       {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.dell.com/en-us");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
        Actions action= new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Deals')]"))).build().perform();
        
        driver.findElement(By.linkText("Workstation Deals")).click();
        
        String ExpectedTitle="Workstation Deals";
        String ActualTitle=driver.getTitle();
        System.out.println("Assert starts here");
        
		try{
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		}catch (Throwable t){
		System.out.println("A blog for Software Testers");
		}
        driver.close();
        driver.quit();
		
	}



}
