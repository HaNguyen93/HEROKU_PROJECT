package TESTCASE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DriverFactory.ChromeDriver2;
import page_object_Heroku.AddContact_page;
import page_object_Heroku.ContactDetail_page;
import page_object_Heroku.ContactListApp_page;
import page_object_Heroku.ContactList_page;
import page_object_Heroku.EditContact_page;

public class TC_Logout {
	WebDriver driver = ChromeDriver2.getChromeDriver();
	ContactListApp_page ContactListApp_page=new ContactListApp_page(driver);
	ContactList_page ContactList_page=new ContactList_page(driver);
	AddContact_page AddContact_page=new AddContact_page(driver);
	ContactDetail_page ContactDetail_page=new ContactDetail_page(driver);
	EditContact_page EditContact_page=new EditContact_page(driver);
	
	
	@BeforeMethod
	public void beforeMethod() {
			//1, Login success
		ContactListApp_page.UserLogin("hanguyen123@gmail.com", "1234567");
	}
			
	@Test	
	public void TC_040() {
		//Verify that logout successfully when click on Logout button on Contact List page
		
		//2, Click on Logout button on Contact List page
		
		ContactList_page.logoutBtnClick();
		//- Logout successfully
		//- Navigate to Contact List App page successfully
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactListApp_page.HeaderPage(),"Contact List App"));
		
		assertEquals(ContactListApp_page.HeaderPage().getText(),"Contact List App");

	}
		
	@Test	
	public void TC_041() {
		//Verify that logout successfully when click on Logout button on Add Contact page
		
		//2, Click on "Add a New Contact" button
		//3, Click on Logout button on Add Contact page
		
		ContactList_page.addNewContactBtnClick();
		AddContact_page.logoutBtnClick();
		//- Logout successfully
		//- Navigate to Contact List App page successfully
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactListApp_page.HeaderPage(),"Contact List App"));
		
		assertEquals(ContactListApp_page.HeaderPage().getText(),"Contact List App");
	}
		
	@Test	
	public void TC_042() {
		//Verify that logout successfully when click on Logout button on Contact Details page
		
		//2, Click on a  record in contact list table
		//3, Logout on Contact Details page
				
		driver.findElement(By.xpath("//tr[1]//td[2]")).click();
		ContactDetail_page.logoutBtnClick();
		//- Logout successfully
		//- Navigate to Contact List App page successfully
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactListApp_page.HeaderPage(),"Contact List App"));
		
		assertEquals(ContactListApp_page.HeaderPage().getText(),"Contact List App");
	}
	
	@Test	
	public void TC_043() {
		//Verify that logout successfully when click on Logout button on Edit Contact page
		
		//2, Click on a  record in contact list table
		//3, Click on Edit Contact button
		//4,  Logout on Edit Contact page
				
		driver.findElement(By.xpath("//tr[1]//td[2]")).click();
		ContactDetail_page.editContactBtnClick();
		EditContact_page.logoutBtnClick();
		//- Logout successfully
		//- Navigate to Contact List App page successfully
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactListApp_page.HeaderPage(),"Contact List App"));
		
		assertEquals(ContactListApp_page.HeaderPage().getText(),"Contact List App");
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
