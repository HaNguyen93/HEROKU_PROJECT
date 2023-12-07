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

public class TC_ReturntoContactList {
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
	public void TC_036() {
		//Verify that navigate to Contact List page successfully when click on Return to Contact List button on Contact Details page
		
		//2, Click on Name of Contact List to go Contact Detail page
		//3, Click on Return to Contact List button
				
		driver.findElement(By.xpath("//tr[1]//td[2]")).click();
		ContactDetail_page.returnBtnClick();
		
		//Navigate to Contact List page successfully
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactList_page.headerPage(),"Contact List"));
		
		assertEquals(ContactList_page.headerPage().getText(),"Contact List");
	}
		
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}

