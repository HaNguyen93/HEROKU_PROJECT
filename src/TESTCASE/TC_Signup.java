package TESTCASE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

import java.time.Duration;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DriverFactory.ChromeDriver2;
import page_object_Heroku.AddUser_page;
import page_object_Heroku.ContactListApp_page;

public class TC_Signup {
	WebDriver driver = ChromeDriver2.getChromeDriver();
	ContactListApp_page ContactListApp_page=new ContactListApp_page(driver);
	AddUser_page AddUser_page=new AddUser_page(driver);
	
	@BeforeMethod
	public void beforetest() {
		//1, Go to link:  https://thinking-tester-contact-list.herokuapp.com/
			driver.get("https://thinking-tester-contact-list.herokuapp.com/");
	}
	@Test
	//Verify that Navigate to Add User successfully when click Sign-up button on Contact List App page
	public void TC_001() {
				
			//2, Click on Sign up button
			
			ContactListApp_page.SignupBtnClick();
			
			String actualTitle= driver.getTitle();
			String expectedTitle= "Add User";
			
			assertEquals(actualTitle, expectedTitle);
			assertEquals(AddUser_page.headerPage().getText(),"Add User");
			assertEquals(AddUser_page.pdescription().getText(),"Sign up to begin adding your contacts!");
			assertEquals(AddUser_page.firstname().getAttribute("placeholder"),"First Name");
			assertEquals(AddUser_page.lastname().getAttribute("placeholder"),"Last Name");
			assertEquals(AddUser_page.email().getAttribute("placeholder"),"Email");
			assertEquals(AddUser_page.password().getAttribute("placeholder"),"Password");
			
			assertEquals(AddUser_page.firstname().getAttribute("value"),"");
			assertEquals(AddUser_page.lastname().getAttribute("value"),"");
			assertEquals(AddUser_page.email().getAttribute("value"),"");
			assertEquals(AddUser_page.password().getAttribute("value"),"");
			
			assertTrue(AddUser_page.SubmitBtn().isDisplayed());
			assertTrue(AddUser_page.CancelBtn().isDisplayed());
	       	
			assertEquals(AddUser_page.footer_component().textFooter().getText(),"Created by Kristin Jackvony, Copyright 2021");
			assertEquals(AddUser_page.footer_component().imgFooter().getAttribute("src"),"https://thinking-tester-contact-list.herokuapp.com/img/thinkingTesterLogo.png");
									
	}
	@Test
	public void TC_002() {
		//Verify that back to Contact List App page successfully when click on Cancel button on Add user page	
		
			//2, Click on Sign up button
			ContactListApp_page.SignupBtnClick();
			//3, Click on Cancel on Add user page
			
			AddUser_page.CancelBtnClick();
			
			String actualTitle= driver.getTitle();
			System.out.println(actualTitle);
			String expectedTitle= "Contact List App";
			
			assertEquals(actualTitle, expectedTitle);
			assertEquals(ContactListApp_page.HeaderPage().getText(),"Contact List App");
			assertEquals(ContactListApp_page.LinkinMsgWelcome().getText(),"here");
			assertEquals(ContactListApp_page.LinkinMsgWelcome().getAttribute("href"),"https://documenter.getpostman.com/view/4012288/TzK2bEa8");
			//display login form
			assertEquals(ContactListApp_page.titleFormLogin().getText(),"Log In:");
			assertEquals(ContactListApp_page.email().getAttribute("placeholder"),"Email");
			assertEquals(ContactListApp_page.password().getAttribute("placeholder"),"Password");
			assertTrue(ContactListApp_page.SubmitBtn().isDisplayed());
			//display signup btn
			assertTrue(ContactListApp_page.SignupBtn().isDisplayed());
			
			//display footer
			assertEquals(AddUser_page.footer_component().textFooter().getText(),"Created by Kristin Jackvony, Copyright 2021");
			assertEquals(AddUser_page.footer_component().imgFooter().getAttribute("src"),"https://thinking-tester-contact-list.herokuapp.com/img/thinkingTesterLogo.png");		
	}
	@Test
	public void TC_003() {
		//Verify that show error when missing input First Name on Add User page
		
		//2, Click on Sign up button
		
			ContactListApp_page.SignupBtnClick();
		//3, On Add User page:
			//- Don't input First Name
			//- input valid Last Name, Email, Password
		  			  
		  AddUser_page.inputLastname("nguyen");
		  AddUser_page.inputEmail("hanguyen99@gmail.com");
		  AddUser_page.inputPassword("1234567"); 
		//4, Click on Submit button
		  AddUser_page.SubmitBtnClick();
		  
		  String expectedTitle="User validation failed: firstName: Path `firstName` is required.";
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		  wait.until(ExpectedConditions.textToBePresentInElement(AddUser_page.error(), expectedTitle));
    
		  String actualTitle= AddUser_page.getErrorContent();
		  System.out.println(actualTitle);
		  
		  assertEquals(actualTitle, expectedTitle);		
	}	
	@Test		
	public void TC_004() {
		//Verify that show error when missing input Last Name on Add User page
		
		//2, Click on Sign up button
		
		ContactListApp_page.SignupBtnClick();
		//3, On Add User page:
			//- Don't input Last Name
			//- input valid First Name, Email, Password
		  		  
		  AddUser_page.inputFirstname("Ha");
		  AddUser_page.inputEmail("hanguyen99@gmail.com");
		  AddUser_page.inputPassword("1234567"); 
		//4, Click on Submit button
		  AddUser_page.SubmitBtnClick();
		  
		  String expectedTitle="User validation failed: lastName: Path `lastName` is required.";
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		  wait.until(ExpectedConditions.textToBePresentInElement(AddUser_page.error(), expectedTitle));
    
		  String actualTitle= AddUser_page.getErrorContent();
		  System.out.println(actualTitle);
		  
		  assertEquals(actualTitle, expectedTitle);			
	}
	@Test		
	public void TC_005() {
		//Verify that show error when missing input Email on Add User page
		
		//2, Click on Sign up button
		
		ContactListApp_page.SignupBtnClick();
		//3, On Add User page:
		// - Don't input Email
		// - input valid First Name, Last Name, Password
		  		  
		  AddUser_page.inputFirstname("Ha");
		  AddUser_page.inputLastname("Nguyen");
		  AddUser_page.inputPassword("1234567"); 
		//4, Click on Submit button
		  AddUser_page.SubmitBtnClick();
		  
		  String expectedTitle="User validation failed: email: Email is invalid";
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		  wait.until(ExpectedConditions.textToBePresentInElement(AddUser_page.error(), expectedTitle));
    
		  String actualTitle= AddUser_page.getErrorContent();
		  System.out.println(actualTitle);
		  
		  assertEquals(actualTitle, expectedTitle);	
	
	}
	@Test		
	public void TC_006() {
		//Verify that show error when missing input Password on Add User page
		
		//2, Click on Sign up button
		
		ContactListApp_page.SignupBtnClick();
		//3, On Add User page:
		//- Don't input Password
		//- input valid First Name, Last Name, Email
		 	  
		  AddUser_page.inputFirstname("Ha");
		  AddUser_page.inputLastname("Nguyen");
		  AddUser_page.inputEmail("hanguyen99@gmail.com");
		//4, Click on Submit button
		  AddUser_page.SubmitBtnClick();
		  
		  String expectedTitle="User validation failed: password: Path `password` is required.";
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		  wait.until(ExpectedConditions.textToBePresentInElement(AddUser_page.error(), expectedTitle));
    
		  String actualTitle= AddUser_page.getErrorContent();
		  System.out.println(actualTitle);
		  
		  assertEquals(actualTitle, expectedTitle);			
	}
	@Test
	public void TC_007() {
		//Verify that show error when input password less than 7 characters on Add User page
		
		//2, Click on Sign up button
		
		ContactListApp_page.SignupBtnClick();
		//3, On Add User page:
		//- input Password less than 7 characters
		//- input valid First Name, Last Name, Email
		  			  
		  AddUser_page.inputFirstname("Ha");
		  AddUser_page.inputLastname("Nguyen");
		  AddUser_page.inputEmail("hanguyen99@gmail.com");
		  AddUser_page.inputPassword("123456"); 
		//4, Click on Submit button
		  AddUser_page.SubmitBtnClick();
		  
		  String expectedTitle="User validation failed: password: Path `password` (`123456`) is shorter than the minimum allowed length (7).";
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		  wait.until(ExpectedConditions.textToBePresentInElement(AddUser_page.error(), expectedTitle));
    
		  String actualTitle= AddUser_page.getErrorContent();
		  System.out.println(actualTitle);
		  
		  assertEquals(actualTitle, expectedTitle);	
							
		}
	@Test
	public void TC_008() {
		//Verify that show error when input email invalid on Add User page
		
		//2, Click on Sign up button
		
		ContactListApp_page.SignupBtnClick();
		//3, On Add User page:
		//- input email invalid 
		//- input valid First Name, Last Name, Password
		  		  
		  AddUser_page.inputFirstname("Ha");
		  AddUser_page.inputLastname("Nguyen");
		  AddUser_page.inputEmail("hanguyen99#gmail.com");
		  AddUser_page.inputPassword("1234567"); 
		//4, Click on Submit button
		  AddUser_page.SubmitBtnClick();
		  
		  String expectedTitle="User validation failed: email: Email is invalid";
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		  wait.until(ExpectedConditions.textToBePresentInElement(AddUser_page.error(), expectedTitle));
    
		  String actualTitle= AddUser_page.getErrorContent();
		  System.out.println(actualTitle);
		  
		  assertEquals(actualTitle, expectedTitle);		
		
		}
	@Test
	public void TC_009() {
		//Verify that show error when input email invalid on Add User page
		
		//2, Click on Sign up button
		
		ContactListApp_page.SignupBtnClick();
		//3, On Add User page:
		//- input  email exist
		//- input valid First Name, Last Name, Password
		  		  
		  AddUser_page.inputFirstname("Ha");
		  AddUser_page.inputLastname("Nguyen");
		  AddUser_page.inputEmail("hanguyen123@gmail.com");
		  AddUser_page.inputPassword("1234567"); 
		//4, Click on Submit button
		  AddUser_page.SubmitBtnClick();
		  
		  String expectedTitle="Email address is already in use";
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		  wait.until(ExpectedConditions.textToBePresentInElement(AddUser_page.error(), expectedTitle));
    
		  String actualTitle= AddUser_page.getErrorContent();
		  System.out.println(actualTitle);
		  
		  assertEquals(actualTitle, expectedTitle);
			
		}
	@Test
	public void TC_010() {
		//Verify that navigate to Contact List page successfully when create new account successfully
		Random rd = new Random();
		int number_random = rd.nextInt(5000);
			
		//2, Click on Sign up button
		
		ContactListApp_page.SignupBtnClick();
		//3, On Add User page:
		//- input valid First Name, Last Name, Email,Password
		 			  
		  AddUser_page.inputFirstname("Johny");
		  AddUser_page.inputLastname("truong");
		  AddUser_page.inputEmail("johnytruong"+number_random+"@gmail.com");
		  AddUser_page.inputPassword("1234567"); 
		//4, Click on Submit button
		  AddUser_page.SubmitBtnClick();
		  
		  String expectedTitle="My Contacts";
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  wait.until(ExpectedConditions.titleIs(expectedTitle));
    
		  String actualTitle= driver.getTitle();
		  System.out.println(actualTitle);
		  
		  assertEquals(actualTitle, expectedTitle);		

		}
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
