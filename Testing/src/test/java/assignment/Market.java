package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Market {
	
	@Test
	public void UserWillAbleToTransferMoneyToNewAccount() throws InterruptedException       {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://techfios.com/test/billing/?ng=login/");
		driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		
		//Validation if the page open
		String ExpectedTitle="Dashboard";
		String ActualTitle=driver.getTitle();
		System.out.println("Your assert starts here");
		 try   {
			 Assert.assertEquals(ExpectedTitle, ActualTitle);
		 }
		 catch (Throwable e)     {
			 System.out.println("Your asserts ends here");
		 }
		 
		 driver.findElement(By.linkText("Bank & Cash")).click();
		 driver.findElement(By.linkText("New Account")).click();
		 driver.findElement(By.id("account")).sendKeys("Retirement");
		 Thread.sleep(5000);
		 driver.findElement(By.id("description")).sendKeys("My saving for future");
		 driver.findElement(By.id("balance")).sendKeys("7000");
		 driver.findElement(By.id("submit")).click();
		 
		 //Validation if there is transfer done
		 boolean status=driver.findElement(By.linkText("My saving for future")).isDisplayed();
		 if(status==true)     {
			 System.out.println("The automation is passed");
		 }
		 else   {
			 System.out.println("The automation failed and please try again");
			
		 }
		 driver.close();
		 driver.quit();
		 
	}

}
