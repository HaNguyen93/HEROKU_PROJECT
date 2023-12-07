package TESTCASE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DriverFactory.ChromeDriver2;
import page_object_Heroku.AddContact_page;
import page_object_Heroku.ContactDetail_page;
import page_object_Heroku.ContactListApp_page;
import page_object_Heroku.ContactList_page;

public class TC_ContactDetail {
	WebDriver driver = ChromeDriver2.getChromeDriver();
	ContactListApp_page ContactListApp_page=new ContactListApp_page(driver);
	ContactList_page ContactList_page=new ContactList_page(driver);
	AddContact_page AddContact_page=new AddContact_page(driver);
	ContactDetail_page ContactDetail_page=new ContactDetail_page(driver);
	
	Random rd = new Random();
	int number_random = rd.nextInt(3000);

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
	@BeforeTest
	public void beforetest() {
		//add new contact success before edit it 
		ContactListApp_page.UserLogin("hanguyen123@gmail.com", "1234567");
		ContactList_page.addNewContactBtnClick();
		AddContact_page.AddContact(firstname, lastname, dateBirth, email, phone, street1, street2, city, stateOrprovince, postalCode, country);
		AddContact_page.logoutBtnClick();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		//1, Login success
	ContactListApp_page.UserLogin("hanguyen123@gmail.com", "1234567");
	
	}
	@Test	
	public void TC_027() {
		//Verify that navigate to Contact Details page when click on Name of Contact List
			
			
			//2, Click on Name of Contact List	
			
			String name =firstname+" "+lastname;
			List<WebElement> rows= driver.findElements(By.cssSelector(".contactTableBodyRow"));
			for (int i=1 ; i<rows.size();i++) {
				
				if(driver.findElement(By.xpath("//tr["+i+"]//td[2]")).getText().equals(name)) {
					driver.findElement(By.xpath("//tr["+i+"]//td[2]")).click();
					break;
				}
			}
			System.out.println("Detail contact of user: "+name);
			
			//wait 		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElement(ContactDetail_page.country(),country));
			
			//Displays correct information of the selected contact record
			assertEquals(ContactDetail_page.headerPage().getText(),"Contact Details");
			assertEquals(ContactDetail_page.firstname().getText(),firstname);
			assertEquals(ContactDetail_page.lastname().getText(),lastname);
			assertEquals(ContactDetail_page.dateBirth().getText(),dateBirth);
			assertEquals(ContactDetail_page.email().getText(),email);
			assertEquals(ContactDetail_page.phone().getText(),phone);
			assertEquals(ContactDetail_page.street1().getText(),street1);
			assertEquals(ContactDetail_page.street2().getText(),street2);
			assertEquals(ContactDetail_page.city().getText(),city);
			assertEquals(ContactDetail_page.stateOrprovince().getText(),stateOrprovince);
			assertEquals(ContactDetail_page.postalCode().getText(),postalCode);
			assertEquals(ContactDetail_page.country().getText(),country);
					
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
