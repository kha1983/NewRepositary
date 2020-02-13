package assignment;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;


public class Yahoo_Test {
	
	
	@Test
	public void yahoo_site_check()   throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
	

	}

}
