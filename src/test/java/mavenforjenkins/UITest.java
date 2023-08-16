package mavenforjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UITest {

	@Parameters("BrowserVar")
	@Test
	public void startBrowser(String BrowserName) throws InterruptedException {
		
		// note:mvn cd projectlocation mvn clean test -DBrowserVar=Edge
	//	ChromeOptions op=new ChromeOptions();
	//	op.addArguments("headless");
//		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
//	System.setProperty("webdriver.gecko.driver","‪C:\\Program Files\\geckodriver-v0.33.0-win64\\geckodriver.exe");	
//		WebDriverManager.chromedriver().setup();

		WebDriver dr=null;
		if(BrowserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			dr = new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			dr = new EdgeDriver(); 
		}else if(BrowserName.contains("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			dr=new FirefoxDriver();
			
		}

		
		dr.manage().window().maximize();
		dr.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3);
		Assert.assertTrue(dr.getTitle().contains("OrangeHRM"),"OrangeHRM");
		dr.close();
		
	}
}
