package TESTCASE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

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

public class TC_DeleteContact {
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
	
	String name =firstname+" "+lastname;

	
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
			//datatest: Name =Nguyen LYLY547
			
			List<WebElement> rows= driver.findElements(By.cssSelector(".contactTableBodyRow"));
			
			
			for (int i=1 ; i<rows.size();i++) {
				
				if(driver.findElement(By.xpath("//tr["+i+"]//td[2]")).getText().equals(name)) {
					driver.findElement(By.xpath("//tr["+i+"]//td[2]")).click();
					break;
				}
			}
			
			//3, Click on button Edit Contact on Contact Details page	
			ContactDetail_page.deleteContactBtnClick();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Test	
	public void TC_037_039() {
		//Verify that navigate to Edit Contact  when click on button Edit Contact on Contact Details page

		String textInPopup ="Are you sure you want to delete this contact?";
		assertEquals(driver.switchTo().alert().getText(),textInPopup);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.textToBePresentInElement(ContactList_page.headerPage(),"Contact List"));
		assertEquals(ContactList_page.headerPage().getText(),"Contact List");
		
		List<WebElement> rows= driver.findElements(By.cssSelector(".contactTableBodyRow"));
				
		for (int i=1 ; i<rows.size();i++) {

			if(driver.findElement(By.xpath("//tr["+i+"]//td[2]")).getText().equals(name)) {
				System.out.println("delete user ["+name+"]failed!");
				break;
			}	
		}
		System.out.println("delete user ["+name+"] success!");
	}		
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
