package mavenforjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UITest {

	@Test
	public void startBrowser() throws InterruptedException {
		
	//	ChromeOptions op=new ChromeOptions();
	//	op.addArguments("headless");
//		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
//	System.setProperty("webdriver.gecko.driver","‪C:\\Program Files\\geckodriver-v0.33.0-win64\\geckodriver.exe");	
//		WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	WebDriver dr = new FirefoxDriver();
		
		dr.manage().window().maximize();
		dr.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3);
		Assert.assertTrue(dr.getTitle().contains("OrangeHRM"),"OrangeHRM");
		dr.close();
		
	}
}
