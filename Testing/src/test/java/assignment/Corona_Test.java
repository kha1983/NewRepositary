package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Corona_Test {
	
	@Test
	public void UserWillAbleToOpenTheSite() throws InterruptedException        {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=login/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder='Email Address']")).sendKeys(" techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		Thread.sleep(3000);
		
		String ExpectedTitle="Dashboard";
		String ActualTitle=driver.getTitle();
		System.out.println("Your asserts starts here");
		
		try    {
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		}
		catch (Throwable e)     {
			System.out.println("Asserts ends here ");
		}
		driver.findElement(By.linkText("Transactions")).click();
		driver.findElement(By.linkText("Transfer")).click();
		Thread.sleep(2000);
		
		boolean status=driver.findElement(By.xpath("//*[contains(text(),'New Transfer')]")).isDisplayed();
		if(status==true)    {
			System.out.println("The testing is sucessfully passed");
		}
		else   {
			System.out.println("The test is failed and try again");
		}
		Thread.sleep(1000);
		driver.close();
		driver.quit();
	}

}
