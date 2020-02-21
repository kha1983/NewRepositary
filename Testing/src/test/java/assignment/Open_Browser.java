package assignment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Open_Browser {

	@Test
	public void UserWillAbleToOpenBrowser() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.adomyinfo.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("khadak.kathayat100@gmail.com");

		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Oliver100%");

		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(5000);
		
		System.out.println("Assert start here");
		boolean status = driver.findElement(By.linkText("LOGOUT")).isDisplayed();
		Assert.assertTrue("Assert passed", status);
		System.out.println("Assert finish");

		//if (status == true) {
		//	System.out.println("Element is displayed and test is passed");
		//} else {
		//	System.out.println("Test is failed because element is not visible");

			//throw new RuntimeException("Please try again");
		//}

		//Thread.sleep(5000);

		//driver.close();
		//driver.quit();
		
		//String ExpectedTitle="Adecco";
		//String ActualTitle=driver.getTitle();
		//System.out.println("Assert start here");
		
		//try  {
		//Assert.assertEquals(ExpectedTitle, ActualTitle);
		//} catch(Throwable t)   {
		//System.out.println("Assert sucess");
		
		driver.close();
		driver.quit();
			
		
		


	}

}
