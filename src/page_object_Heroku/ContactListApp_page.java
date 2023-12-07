package page_object_Heroku;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import components.footer_component_BAITAP;

public class ContactListApp_page {

	private WebDriver driver;
	private By HeaderPage = By.cssSelector("h1");
	private By MsgWelcome= By.cssSelector(".welcome-message");
	private By LinkinMsgWelcome = By.cssSelector(".welcome-message a");
	private By titleFormLogin = By.cssSelector(".main-content p");
	private By emaiSelector =By.cssSelector("input[id='email']");
	private By passwordSelector= By.cssSelector("input[id='password']");
	private By submitbtn=By.cssSelector("button[id='submit']");
	private By signupbtn=By.cssSelector("button[id='signup']");
	private By errorSelector=By.cssSelector("span[id='error']");
	private String URL_LoginPage="https://thinking-tester-contact-list.herokuapp.com/";
	
	public ContactListApp_page(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement HeaderPage() {
		return driver.findElement(HeaderPage);
	}
	public <list>WebElement MsgWelcome() {
		return driver.findElement(MsgWelcome);
	}
	
	public WebElement LinkinMsgWelcome() {
		return driver.findElement(LinkinMsgWelcome);
	}
	
	public WebElement titleFormLogin() {
		return driver.findElement(titleFormLogin);
	}
	public WebElement email() {
		return driver.findElement(emaiSelector);
	}
	
	public WebElement password() {
		return driver.findElement(passwordSelector);
	}

	public WebElement SubmitBtn() {
		return driver.findElement(submitbtn);
	}
	
	public WebElement SignupBtn() {
		return driver.findElement(signupbtn);
	}
	
	public footer_component_BAITAP footer_component() {
		return new footer_component_BAITAP(driver);
	}
	
	public WebElement error() {
		return driver.findElement(errorSelector);
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
	//click Signup btn
		public void SignupBtnClick() {
			SignupBtn().click();
		}
		
	//getTitlepage
		public String getTitle_page() {
			return driver.getTitle();
		}
	//getErrorMessage
		public String getErrorMessage() {
			return error().getText();
		}
		
		public void UserLogin(String email, String password) {
			driver.get(URL_LoginPage);
			inputEmail(email);
			inputPassword(password);
			SubmitBtnClick();
		}
}
