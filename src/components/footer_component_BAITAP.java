package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class footer_component_BAITAP {

	private WebDriver driver;
	private By textFooterSelector = By.cssSelector("footer p");
	private By imgFooterSelector = By.cssSelector("footer img");
	
	public footer_component_BAITAP(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement textFooter() {
		return driver.findElement(textFooterSelector);
	}
	
	public WebElement imgFooter() {
		return driver.findElement(imgFooterSelector);
	}
	
}
