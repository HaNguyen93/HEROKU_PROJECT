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
import page_object_Heroku.AddContact_page;
import page_object_Heroku.ContactListApp_page;
import page_object_Heroku.ContactList_page;

public class TC_AddNewContact {
	WebDriver driver = ChromeDriver2.getChromeDriver();
	ContactListApp_page ContactListApp_page=new ContactListApp_page(driver);
	ContactList_page ContactList_page=new ContactList_page(driver);
	AddContact_page AddContact_page=new AddContact_page(driver);
	
	
	@BeforeMethod
	public void beforetest() {
		//1, Login success
			
			ContactListApp_page.UserLogin("hanguyen123@gmail.com", "1234567");
	}
	
	@Test	
	public void TC_017() {
			//Verify that navigate to Add Contact Page successfully when click on Add a new Contact button on Contact List page
		
			//2, Click on Add a new Contact button
			ContactList_page.addNewContactBtnClick();
			
			//Navigate to Add Contact page successfully
			String actualTitle= driver.getTitle();
			String expectedTitle= "Add Contact";
			
			assertEquals(actualTitle, expectedTitle);
					
	}
	@Test	
	public void TC_018() {
			//Verify that back to Contact List page when click on Cancel button on Add Contact page
		
			//2, Click on Add a new Contact button
			//3, Click on Cancel button on Add Contact page
			ContactList_page.addNewContactBtnClick();
			AddContact_page.cancelBtnClick();
			
			//Back to Contact List page successfully
			String actualTitle= driver.getTitle();
			String expectedTitle= "My Contacts";
			assertEquals(actualTitle, expectedTitle);					
	}
	
	@Test	
	public void TC_019() {
			//Verify that show error when missing input Fist name and Last Name on Add Contact page
			//2, Click on Add a new Contact button
			//3, Don't input First Name and LastName
			//4, Click on Submit button
			ContactList_page.addNewContactBtnClick();
			//AddContact_page.inputFirstName("Nguyen");
			//AddContact_page.inputLastName("LYLY");
			AddContact_page.submitBtnClick();
			
			//show error
			String expectedTitle="Contact validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required.";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.textToBePresentInElement(AddContact_page.error(), expectedTitle));
			String actualTitle= AddContact_page.error().getText();
			assertEquals(actualTitle, expectedTitle);				
	}
	
	@Test	
	public void TC_020() {
			//Verify that show error when missing input Fist name on Add Contact page
			//2, Click on Add a new Contact button
			//3, Don't input First Name
			//4, Click on Submit button
			ContactList_page.addNewContactBtnClick();

			AddContact_page.inputLastName("LYLY");
			AddContact_page.submitBtnClick();
						
			//show error		
			String expectedTitle="Contact validation failed: firstName: Path `firstName` is required.";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.textToBePresentInElement(AddContact_page.error(), expectedTitle));
			String actualTitle= AddContact_page.error().getText();
			assertEquals(actualTitle, expectedTitle);
	}
	
	@Test	
	public void TC_021() {
			//Verify that show error when missing input Last name on Add Contact page
			//2, Click on Add a new Contact button
			//3, Don't input Last Name
			//4, Click on Submit button
			ContactList_page.addNewContactBtnClick();
			
			AddContact_page.inputFirstName("Nguyen");			
			AddContact_page.submitBtnClick();
						
			//show error		

			String expectedTitle="Contact validation failed: lastName: Path `lastName` is required.";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.textToBePresentInElement(AddContact_page.error(), expectedTitle));
			String actualTitle= AddContact_page.error().getText();
			assertEquals(actualTitle, expectedTitle);
	}
	
	@Test	
	public void TC_022() {
			//Verify that show error when input Date of Birth isn't correct format yyyy-mm-dd on Add Contact page
			//2, Click on Add a new Contact button
			//3, Input valid First name and Last name
			//4, Input Date of Birth isn't correct format yyyy-mm-dd (ex: 10/3/1999)
			//5, Click on Submit button
			ContactList_page.addNewContactBtnClick();
			
			AddContact_page.inputFirstName("Nguyen");
			AddContact_page.inputLastName("LYLY");
			AddContact_page.inputDateBirth("10/3/1999");
			AddContact_page.submitBtnClick();
						
			//show error		

			String expectedTitle="Contact validation failed: birthdate: Birthdate is invalid";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.textToBePresentInElement(AddContact_page.error(), expectedTitle));
			String actualTitle= AddContact_page.error().getText();
			assertEquals(actualTitle, expectedTitle);
	}
	@Test	
	public void TC_023() {
			//Verify that show error when input Email isn't correct format  Add Contact page
			 
			//2, Click on Add a new Contact button
			//3, Input valid First name and Last name
			//4, Input Email  isn't correct format
			//5, Click on Submit button
			ContactList_page.addNewContactBtnClick();
			
			AddContact_page.inputFirstName("Nguyen");
			AddContact_page.inputLastName("LYLY");
			AddContact_page.inputEmail("lylynguyen#gmail.com");
			AddContact_page.submitBtnClick();
						
			//show error		

			String expectedTitle="Contact validation failed: email: Email is invalid";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.textToBePresentInElement(AddContact_page.error(), expectedTitle));
			String actualTitle= AddContact_page.error().getText();
			assertEquals(actualTitle, expectedTitle);
	}
	@Test	
	public void TC_024() {
			//Verify that show error when input Phone isn't correct format  Add Contact page
			 
			//2, Click on Add a new Contact button
			//3, Input valid First name and Last name
			//4, Input phone  isn't correct format
			//5, Click on Submit button
			ContactList_page.addNewContactBtnClick();
			
			AddContact_page.inputFirstName("Nguyen");
			AddContact_page.inputLastName("LYLY");
			AddContact_page.inputPhone("text");
			AddContact_page.submitBtnClick();
						
			//show error		

			String expectedTitle="Contact validation failed: phone: Phone number is invalid";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.textToBePresentInElement(AddContact_page.error(), expectedTitle));
			String actualTitle= AddContact_page.error().getText();
			assertEquals(actualTitle, expectedTitle);
	}
	@Test	
	public void TC_025() {
			//Verify that Add new contact successfully when input valid Postal Code 
			 
			//2, Click on Add a new Contact button
			//3, Input valid First name and Last name
			//4, Input Postal Code   isn't correct format
			//5, Click on Submit button
			ContactList_page.addNewContactBtnClick();
			
			AddContact_page.inputFirstName("Nguyen");
			AddContact_page.inputLastName("LYLY");
			AddContact_page.inputpostalCode("text");
			AddContact_page.submitBtnClick();
						
			//show error		

			String expectedTitle="Contact validation failed: postalCode: Postal code is invalid";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.textToBePresentInElement(AddContact_page.error(), expectedTitle));
			String actualTitle= AddContact_page.error().getText();
			assertEquals(actualTitle, expectedTitle);
	}
	
	@Test	
	public void TC_026() {
			//Verify that Add new contact successfully when input valid all information
			 
			//2, Click on Add a new Contact button
			//3, Input valid First name and Last name
			//4, Input valid Date of Birth, Email, Phone, Street1,Street2, City, State of Province, Pastal Code, Country
			//5, Click on Submit button
			Random rd = new Random();
			int number_random = rd.nextInt(1000);
		
			String firstname ="Nguyen";
			String lastname ="LYLY"+number_random;
			String dateBirth ="1993-10-29";
			String email ="lylynguyen"+number_random+"@gmail.com";
			String phone ="0908199"+number_random;
			String street1 ="Le Loi 1";
			String street2 ="Le Loi 2";
			String city ="Ha Noi";
			String stateOrprovince ="Dong da";
			String postalCode ="4000";
			String country ="viet nam";
					
			ContactList_page.addNewContactBtnClick();
			
			AddContact_page.AddContact(firstname, lastname, dateBirth, email, phone, street1, street2, city, stateOrprovince, postalCode, country);
									
			//Navigate to Contact List successfully		
			String expectedTitle= "My Contacts";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			String actualTitle= driver.getTitle();
			
			assertEquals(actualTitle, expectedTitle);
			assertTrue(ContactList_page.contactTable().isDisplayed());
				
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
