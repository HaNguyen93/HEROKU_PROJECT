package DriverFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriver2 {
	public static WebDriver getChromeDriver() {
		
		String currentProjectLocation=System.getProperty("user.dir");
		String chromeDriverRelativePath="/src/test/resources_test/";
		String chromeDriverLocation =currentProjectLocation.concat(chromeDriverRelativePath);
		
		System.getProperty("webdriver.chrome.driver", chromeDriverLocation);
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
	}

}
