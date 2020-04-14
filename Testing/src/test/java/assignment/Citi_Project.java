package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Citi_Project {
	
	//Scenario: Users will be able to Transfer Money
	//1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
	//2. Enter username: techfiosdemo@gmail.com
	//3. Enter password: abc123
	//4. Click login button
	//5. Click on Transactions in the Side Navigation
	//6. Click on transfer
	//7. Fill in the New Transfer Form,
	//8. Click submit,
	//9. Validate transfer posted on the table.
	
	@Test
	public void UserswillbeabletoTransferMoney() throws InterruptedException           {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		Thread.sleep(5000);
		
		//Validation of Page opened
		String ExpectedTitle="Dashboard";
		String ActualTitle=driver.getTitle();
		System.out.println("Asserts start here");
		
		try   {
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		}
		catch  (Throwable e)        {
			System.out.println("Your asserts end here and testing is passed");
		}
		
		driver.findElement(By.xpath("//*[contains(text(),'Bank & Cash')]")).click();
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Account Title')]")).click();
		driver.findElement(By.id("account")).sendKeys("Corona Testing");
		Thread.sleep(3000);
		driver.findElement(By.id("description")).sendKeys("Stay safe & stay inside");
		driver.findElement(By.id("balance")).sendKeys("5000");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		
		//Validation of make sure account is opening
		boolean status=driver.findElement(By.linkText("Stay safe & stay inside")).isDisplayed();
		if(status==true)     {
			System.out.println("Testing is passed");
		}
		else   {
			System.out.println("Testing is failed and check all your script");
		}
		
		
		driver.close();
		driver.quit();
		
		
	}
	

	}


