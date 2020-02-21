package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Demo_Test {

	@Test
	public void UserWillAbleToFillUpTheForm() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.toolsqa.com/automation-practice-form/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// String ExpectedTitle="Automation Practice Form";
		// String ActualTitle=driver.getTitle();
		// System.out.println("Assert starts here");

		// try {
		// Assert.assertEquals(ExpectedTitle, ActualTitle);
		// }
		// catch (Throwable e) {
		// System.out.println("Assert end here and test is passed");
		// }
		// boolean status=driver.findElement(By.linkText("TUTORIAL")).isDisplayed();

		// if(status==true) {
		// System.out.println("Test is passed");
		// }
		// else {
		// System.out.println("Test is failed");
		// }

		driver.findElement(By.name("firstname")).sendKeys("Khadak");
		driver.findElement(By.id("lastname")).sendKeys("Kathayat");
		// driver.findElement(By.xpath("//*[contains(text(),'Simple
		// Button')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Sex')]")).click();
		driver.findElement(By.xpath("//*[@value='Male']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,400)");
		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//*[@name='exp']")).click();
		driver.findElement(By.xpath("//*[@value='4']")).click();
		driver.findElement(By.id("datepicker")).sendKeys("02/19/2020");
		driver.findElement(By.id("profession-0")).click();
		driver.findElement(By.xpath("/*[@value='Manual Tester']")).click();
		
		driver.close();
		driver.quit();

	}

}
