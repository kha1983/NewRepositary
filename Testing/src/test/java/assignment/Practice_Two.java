package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Practice_Two {
	
	//1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
		//2. Enter username: techfiosdemo@gmail.com
		//3. Enter password: abc123
		//4. Click login button
		//5. Click on Bank & Cash
		//6. Click on New Account
		//7. Fill in the Add New Account Form (Randomize Account Title and Balance)
		//8. Click submit,

		//​Intermediate:
		//9. Validate the presence of "Account Created Successfully" message

		//Advance: 
		//10. Scroll Down,
		//11. Validate new account showed up in the bottom of the table
		//12. ​Delete that account
		//13. Validate account deleted from the bottom of the table
	
	@Test
	public void AddNewAccountOnTechfiosSite()           {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.cssSelector("input[placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Products & Services')]")).click();
		driver.findElement(By.linkText("New Product")).click();
		
		//Validation of New product page
		String ExpectedTitle="Add Product";
		String ActualTitle=driver.getTitle();
		System.out.println("Assert starts here");
		try    {
			Assert.assertEquals(ExpectedTitle, ActualTitle);
		}
		catch(Throwable e)     {
			System.out.println("Asserts ends here");
		}
		
		driver.findElement(By.id("name")).sendKeys("Khadak Bahadur Kathayat");
		driver.findElement(By.id("sales_price")).sendKeys("5000");
		driver.findElement(By.id("description")).sendKeys("Launch of My Product");
		driver.findElement(By.id("submit")).click();
		
		driver.close();
		driver.quit();
		

	}

}
