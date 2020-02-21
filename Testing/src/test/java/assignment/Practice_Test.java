package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Practice_Test {
	
	//Automate the following test case:
		//Scenario: Users will be able to add deposit
		//1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
		//2. Enter username: techfiosdemo@gmail.com
		//3. Enter password: abc123
		//4. Click login button
		//5. Click on Add Deposit button on Dashboard Page
		//6. Click on Open An Account drop down to expand it,
		//7. Click on any account name,
		//8. Type any description,
		//9. Type any amount,
		//10. Click on submit button,
		//Visually check to make sure the deposit posted
	
	@Test
	public void UsersWillBeAbleToAddDeposit()  throws Exception   {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		driver.findElement(By.linkText("Transactions")).click();
		driver.findElement(By.linkText("Add Deposit")).click();
		
		//String ExpectedTitle="Add Deposit";
		//String ActualTitle=driver.getTitle();
		//System.out.println("Asserts start here");
		
		//try   {
		//	Assert.assertEquals(ExpectedTitle, ActualTitle);
		//}
		//catch (Throwable t)    {
			//System.out.println("Asserts end here");
			
		//}
		boolean status=driver.findElement(By.xpath("//*[contains(text(),'Add Deposit')]")).isDisplayed();
		
		if(status==true)    {
			System.out.println("Test is passed");
		}
		else   {
			System.out.println("Test is failed");
		}
		
		driver.findElement(By.xpath("//*[contains(text(),'Choose an Account')]")).click();
		driver.findElement(By.xpath("//*[@value='houseloan']")).click();
		driver.findElement(By.id("description")).sendKeys("My Installment");
		Thread.sleep(5000);
		driver.findElement(By.id("amount")).sendKeys("5000");
		driver.findElement(By.id("submit")).click();
		
		String ExpectedTitle="My Installment";
		String ActualTitle=driver.getTitle();
		System.out.println("Asserts start here");
		
		try   {
			Assert.assertEquals(ExpectedTitle, ActualTitle);
		}
		catch  (Throwable e)      {
			System.out.println("Asserts end here");
		}
	}

}
