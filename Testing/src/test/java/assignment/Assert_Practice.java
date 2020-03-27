package assignment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Assert_Practice {
	
	//Scenario: Users will be able Log in
	//1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
	//2. Enter username: techfiosdemo@gmail.com
	//3. Enter password: abc123
	//4. Click login button
	//Validation
	
	@Test
	
	public void UserswillbeableLogin()  throws Exception   {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("abc123");
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		
		//boolean status=driver.findElement(By.linkText("Dashboard")).isDisplayed();
		
		//if(status==true)   {
			//System.out.println("Test Passed");
		//}
		//else  {
			//System.out.println("Test Failed");
		//}
		
		String ElementLocatorXpath="//*[contains(text(),'Dashboard')]";
		
		String ExpectedTitle="Dashboard- TechFios Test Application - Billing";
		
		String ActualTitle=driver.getTitle();
		
		Assert.assertEquals("Dashboard did not display", ExpectedTitle, ActualTitle);
		
		
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
		
	}
	

}
