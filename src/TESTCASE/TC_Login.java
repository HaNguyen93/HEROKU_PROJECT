package TESTCASE;

import static org.testng.Assert.*;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DriverFactory.ChromeDriver2;
import page_object_Heroku.ContactListApp_page;
import page_object_Heroku.ContactList_page;

public class TC_Login {

	WebDriver driver = ChromeDriver2.getChromeDriver();
	ContactListApp_page ContactListApp_page=new ContactListApp_page(driver);
	ContactList_page ContactList_page=new ContactList_page(driver);
	@BeforeMethod
	public void beforeMethod() {
		
		//1, Go to link:  https://thinking-tester-contact-list.herokuapp.com/
		driver.get("https://thinking-tester-contact-list.herokuapp.com/");
	}
	@Test
	public void TC_011() {
		//Verify that Navigate to Contact List App page successfully

		  String expectedTitle="Contact List App";
		  String actualTitle= ContactListApp_page.getTitle_page();
		  System.out.println(actualTitle);
		  
		  assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void TC_012() {
		//Verify that show error when missing input email
		
		//2, Input password
		//3, Don’t input email
		//4,Click on Submit button
		
		ContactListApp_page.inputPassword("1234567");
		ContactListApp_page.SubmitBtnClick();
		
		String expectedTitle="Incorrect username or password";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactListApp_page.error(), expectedTitle));
		  
		String actualTitle= ContactListApp_page.getErrorMessage();
		System.out.println(actualTitle);
		  
		assertEquals(actualTitle, expectedTitle);
				
	}
	@Test
	public void TC_013() {
		//Verify that show error when missing input password 
		//2, Input email
		//3, Don’t input password
		//4, Click on Submit button
		
		ContactListApp_page.inputEmail("hanguyen123@gmail.com");
		ContactListApp_page.SubmitBtnClick();
		
		String expectedTitle="Incorrect username or password";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactListApp_page.error(), expectedTitle));
		  
		String actualTitle= ContactListApp_page.getErrorMessage();
		System.out.println(actualTitle);
		
		assertEquals(actualTitle, expectedTitle);		
	}
	
	public void TC_014() {
		//Verify that show error when input unregistered email in the system 
		//2, Input unregistered email in the system
		//3, Click on Submit button
		
		ContactListApp_page.inputEmail("test_123@gmail.com");
		ContactListApp_page.inputPassword("1234567");
		ContactListApp_page.SubmitBtnClick();
		
		String expectedTitle="Incorrect username or password";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactListApp_page.error(), expectedTitle));
		  
		String actualTitle= ContactListApp_page.getErrorMessage();
		System.out.println(actualTitle);
		
		assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void TC_015() {
		//Verify that show error when input password incorrect
		//2, Input correct email
		//3, Input incorrect password
		//4, Click on Submit button
		
		ContactListApp_page.inputEmail("hanguyen123@gmail.com");
		ContactListApp_page.inputPassword("12345678");
		ContactListApp_page.SubmitBtnClick();
		
		String expectedTitle="Incorrect username or password";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactListApp_page.error(), expectedTitle));
		  
		String actualTitle= ContactListApp_page.getErrorMessage();
		System.out.println(actualTitle);
		  
		assertEquals(actualTitle, expectedTitle);
	}		
	@Test
	public void TC_016() {
		//Verify that Login successfully when input correct email and password
		//2, Input correct email
		//3, Input correct password
		//4, Click on Submit button
		
		ContactListApp_page.inputEmail("hanguyen123@gmail.com");
		ContactListApp_page.inputPassword("1234567");
		ContactListApp_page.SubmitBtnClick();
		
		//Navigate to Contact List page successfully			
		String expectedTitle="My Contacts";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		  
		String actualTitle= driver.getTitle();
		//System.out.println(actualTitle);
		
		assertEquals(actualTitle, expectedTitle);
		assertEquals(ContactList_page.headerPage().getText(),"Contact List");
		assertEquals(ContactList_page.descriptionPage().getText(),"Click on any contact to view the Contact Details");
		assertEquals(ContactList_page.addNewContactBtn().getText(),"Add a New Contact");
		assertEquals(ContactList_page.logoutBtn().getText(),"Logout");
				
		assertTrue(ContactList_page.addNewContactBtn().isDisplayed());
		assertTrue(ContactList_page.logoutBtn().isDisplayed());
		//assertFalse(ContactList_page.contactTable().isDisplayed());
       	
		assertEquals(ContactList_page.footer_component().textFooter().getText(),"Created by Kristin Jackvony, Copyright 2021");
		assertEquals(ContactList_page.footer_component().imgFooter().getAttribute("src"),"https://thinking-tester-contact-list.herokuapp.com/img/thinkingTesterLogo.png");
			
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}

}
