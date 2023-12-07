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
import page_object_Heroku.EditContact_page;

public class TC_EditContact {
	WebDriver driver = ChromeDriver2.getChromeDriver();
	ContactListApp_page ContactListApp_page=new ContactListApp_page(driver);
	ContactList_page ContactList_page=new ContactList_page(driver);
	AddContact_page AddContact_page=new AddContact_page(driver);
	ContactDetail_page ContactDetail_page=new ContactDetail_page(driver);
	EditContact_page EditContact_page=new EditContact_page(driver);
	
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
	
	int number_random2 = rd.nextInt(1000);

	String firstname2 ="TRUONG";
	String lastname2 ="LYLY"+number_random2;
	String dateBirth2 ="1999-11-30";
	String email2 ="lylynguyen"+number_random2+"@gmail.com";
	String phone2 ="0908199"+number_random2;
	String street1_2 ="Quang Trung 1";
	String street2_2 ="Quang Trung 2";
	String city2 ="Da Nang";
	String stateOrprovince2 ="Hai Chau";
	String postalCode2 ="5000";
	String country2 ="viet nam 2";
	
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

			//2, Click on Name of Contact List
			String name =firstname+" "+lastname;
			List<WebElement> rows= driver.findElements(By.cssSelector(".contactTableBodyRow"));
			
			
			for (int i=1 ; i<rows.size();i++) {
				
				if(driver.findElement(By.xpath("//tr["+i+"]//td[2]")).getText().equals(name)) {
					driver.findElement(By.xpath("//tr["+i+"]//td[2]")).click();
					break;
				}
			}
			
			//3, Click on button Edit Contact on Contact Details page	
			ContactDetail_page.editContactBtnClick();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Test	
	public void TC_028() {
		//Verify that navigate to Edit Contact  when click on button Edit Contact on Contact Details page

		//Navigate to Edit Details page successfully
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.textToBePresentInElement(EditContact_page.countryLabel(),"Country:"));
	
		
		assertEquals(EditContact_page.headerPage().getText(),"Edit Contact");
		assertEquals(EditContact_page.firstname().getAttribute("value"),firstname);
		assertEquals(EditContact_page.lastname().getAttribute("value"),lastname);
		assertEquals(EditContact_page.dateBirth().getAttribute("value"),dateBirth);
		assertEquals(EditContact_page.email().getAttribute("value"),email);
		assertEquals(EditContact_page.phone().getAttribute("value"),phone);
		assertEquals(EditContact_page.street1().getAttribute("value"),street1);
		assertEquals(EditContact_page.street2().getAttribute("value"),street2);
		assertEquals(EditContact_page.city().getAttribute("value"),city);
		assertEquals(EditContact_page.stateOrprovince().getAttribute("value"),stateOrprovince);
		assertEquals(EditContact_page.postalCode().getAttribute("value"),postalCode);
		assertEquals(EditContact_page.country().getAttribute("value"),country);
		 
	}
	
	@Test	
	public void TC_029() {
		//Verify that back to Contact Details page when click on Cancel button on Edit Contact page
		
		//4, Click on  Cancel button on Edit Contact page
		EditContact_page.cancelBtnClick();
		
		//back to Contact Details page
		String headerPage ="Contact Details";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(ContactDetail_page.headerPage(),headerPage));
	
		assertEquals(ContactDetail_page.headerPage().getText(),headerPage);
	}
	
	@Test	
	public void TC_030() {
		//Verify that show error when edit First Name, Last Name to empty on Edit contact page
		
		//4, Delete First Name, Last Name
		//5, Click Submit button
		EditContact_page.firstname().clear();
		EditContact_page.lastname().clear();
		EditContact_page.submitBtnClick();
		
		//show error
		String error ="Validation failed: lastName: Path `lastName` is required., firstName: Path `firstName` is required.";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(EditContact_page.error(),error));
	
		assertEquals(EditContact_page.error().getText(),error);
	}
		
	@Test	
	public void TC_031() {
		//Verify that show error when edit Date of Birthday isn't correct format yyyy/mm/dd on Edit contact page
		
		//4, Edit Date of Birthday isn't correct format yyyy/mm/dd
		//5, Click Submit button
		
		EditContact_page.dateBirth().clear();
		EditContact_page.inputDateBirth("25/11/1999");
		EditContact_page.submitBtnClick();
		
		//show error
		String error ="Validation failed: birthdate: Birthdate is invalid";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(EditContact_page.error(),error));
	
		assertEquals(EditContact_page.error().getText(),error);
	}
	
	@Test	
	public void TC_032() {
		//Verify that show error when edit Email isn't correct format on Edit contact page
		
		//4, Edit Email isn't correct format  (ex: ha123%gmail.com)
		//5, Click Submit button
		
		EditContact_page.email().clear();
		EditContact_page.inputEmail("ha123%gmail.com");
		EditContact_page.submitBtnClick();
		
		//show error
		String error ="Validation failed: email: Email is invalid";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(EditContact_page.error(),error));
	
		assertEquals(EditContact_page.error().getText(),error);
	}
	
	@Test	
	public void TC_033() {
		//Verify that show error when edit Phone isn't correct format on Edit contact page
		//4, Edit Phone isn't correct format  (ex:Phone = hanguyen)
		//5, Click Submit button
		
		EditContact_page.phone().clear();
		EditContact_page.inputPhone("hanguyen");
		EditContact_page.submitBtnClick();
		
		//show error
		String error ="Validation failed: phone: Phone number is invalid";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(EditContact_page.error(),error));
	
		assertEquals(EditContact_page.error().getText(),error);
	}
	
	@Test	
	public void TC_034() {
		//Verify that show error when edit Postal Code isn't correct format on Edit contact page
		//4, Edit Postal Code isn't correct format  (ex:Postal Code = hanguyen)
		//5, Click Submit button
		
		EditContact_page.postalCode().clear();
		EditContact_page.inputpostalCode("hanguyen");
		EditContact_page.submitBtnClick();
		
		//show error
		String error ="Validation failed: postalCode: Postal code is invalid";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.textToBePresentInElement(EditContact_page.error(),error));
	
		assertEquals(EditContact_page.error().getText(),error);
	}
	
	@Test	
	public void TC_035() {
		//Verify that Edit all of contact information is successfully
		//4, Edit all of contact information is correct  
		//5, Click Submit button
		
		EditContact_page.EditContact(firstname2, lastname2, dateBirth2, email2, phone2, street1_2, street2_2, city2, stateOrprovince2, postalCode2, country2);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		assertEquals(ContactDetail_page.headerPage().getText(),"Contact Details");
		assertEquals(ContactDetail_page.firstname().getText(),firstname2);
		assertEquals(ContactDetail_page.lastname().getText(),lastname2);
		assertEquals(ContactDetail_page.dateBirth().getText(),dateBirth2);
		assertEquals(ContactDetail_page.email().getText(),email2);
		assertEquals(ContactDetail_page.phone().getText(),phone2);
		assertEquals(ContactDetail_page.street1().getText(),street1_2);
		assertEquals(ContactDetail_page.street2().getText(),street2_2);
		assertEquals(ContactDetail_page.city().getText(),city2);
		assertEquals(ContactDetail_page.stateOrprovince().getText(),stateOrprovince2);
		assertEquals(ContactDetail_page.postalCode().getText(),postalCode2);
		assertEquals(ContactDetail_page.country().getText(),country2);
	
	}
	
	
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
