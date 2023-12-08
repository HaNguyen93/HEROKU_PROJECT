package page_object_Heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import components.footer_component_heroku;

public class AddUser_page {

	private WebDriver driver;
	private By headerPage=By.cssSelector("h1");
	private By pSelector=By.cssSelector("p");
	private By firstnameSelector = By.cssSelector("input[id='firstName']");
	private By lastnameSelector = By.cssSelector("input[id='lastName']");
	private By emailSelector = By.cssSelector("input[id='email']");
	private By passwordSelector = By.cssSelector("input[id='password']");
	private By submitbtn= By.cssSelector("button[id='submit']");
	private By cancelbtn= By.cssSelector("button[id='cancel']");
		
	private By errorSelector= By.cssSelector("span[id='error']");
	//private By footerSelector=By.cssSelector()
	
	public AddUser_page(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement headerPage() {
		return driver.findElement(headerPage);
	}
	
	public WebElement pdescription() {
		return driver.findElement(pSelector);
	}
	public WebElement firstname() {
		return driver.findElement(firstnameSelector);
	}
	
	public WebElement lastname() {
		return driver.findElement(lastnameSelector);
	}
	
	public WebElement email() {
		return driver.findElement(emailSelector);
	}
	
	public WebElement password() {
		return driver.findElement(passwordSelector);
	}

	public WebElement SubmitBtn() {
		return driver.findElement(submitbtn);
	}
	
	public WebElement CancelBtn() {
		return driver.findElement(cancelbtn);
	}
	
	public footer_component_heroku footer_component() {
		return new footer_component_heroku(driver);
	}
	
	public WebElement error() {
		return driver.findElement(errorSelector);
	}
	
	//input firstname
	public void inputFirstname(String firstname) {
		firstname().sendKeys(firstname);
	}
	//input lastname
	public void inputLastname(String lastname) {
		lastname().sendKeys(lastname);
	}
	//input email
	public void inputEmail(String email) {
		email().sendKeys(email);
	}
	//input password
	public void inputPassword(String password) {
		password().sendKeys(password);
	}
	//click Submit btn
	public void SubmitBtnClick() {
		SubmitBtn().click();
	}
	
	//click Cancel btn
	public void CancelBtnClick() {
			CancelBtn().click();
		}
	//get content error message
	public String getErrorContent() {
		return error().getText();
	}
	
	
}
