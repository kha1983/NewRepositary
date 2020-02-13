package assignment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class GoogleTest {

	@Test
	public void techfios_test() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techfios.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		boolean status = driver.findElement(By.linkText("Student Portal")).isDisplayed();

		if (status == true) {
			System.out.println("Element is visible and test is passed");
		} else {
			System.out.println("element is not visible");

			throw new RuntimeException("Test failed");
		}

		driver.close();
		driver.quit();

	}

}
