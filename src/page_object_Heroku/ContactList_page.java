package page_object_Heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import components.footer_component_heroku;

public class ContactList_page {

	private WebDriver driver;
	private By headerPage=By.cssSelector("h1");
	private By descriptionPage=By.cssSelector("p");
	private By addNewContactBtn= By.cssSelector("button[id='add-contact']");
	private By logoutBtn=By.cssSelector("button[id='logout']");
	private By contactTable=By.id("myTable");
	
	public ContactList_page(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement headerPage() {
		return driver.findElement(headerPage);
	}
	public WebElement descriptionPage() {
		return driver.findElement(descriptionPage);
	}
	public WebElement addNewContactBtn() {
		return driver.findElement(addNewContactBtn);
	}
	
	public WebElement logoutBtn() {
		return driver.findElement(logoutBtn);
	}
	
	public WebElement contactTable() {
		return driver.findElement(contactTable);
	}
	public footer_component_heroku footer_component() {
		return new footer_component_heroku(driver);
	}
	public void addNewContactBtnClick() {
		addNewContactBtn().click();
		
	}
	
	public void logoutBtnClick() {
		logoutBtn().click();		
	}
	
	
}
