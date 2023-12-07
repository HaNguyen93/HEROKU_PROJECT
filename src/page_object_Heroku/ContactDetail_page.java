package page_object_Heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactDetail_page {
	
	private WebDriver driver;
	private By headerPage=By.cssSelector("h1");
	private By firstnameSelector=By.id("firstName");
	private By lastnameSelector=By.id("lastName");
	private By dateofBirthSelector=By.id("birthdate");
	private By emailSelector=By.id("email");
	private By phoneSelector=By.id("phone");
	private By streetAddress1Selector=By.id("street1");
	private By streetAddress2Selector=By.id("street2");
	private By citySelector=By.id("city");
	private By stateOrprovinceSelector=By.id("stateProvince");
	private By postalCodeSelector=By.id("postalCode");
	private By countrySelector=By.id("country");
	
	private By errorSelector=By.id("error");
	
	private By editContactBtn=By.id("edit-contact");
	private By deleteContactBtn=By.id("delete");
	private By returnBtn=By.id("return");
	private By logoutBtn=By.id("logout");
	
	public ContactDetail_page(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement headerPage() {
		return driver.findElement(headerPage);
	}	
	public WebElement firstname() {
		return driver.findElement(firstnameSelector);
	}
	public void inputFirstName(String firstname) {
		firstname().sendKeys(firstname);
	}
	public WebElement lastname() {
		return driver.findElement(lastnameSelector);
	}
	public void inputLastName(String lastname) {
		lastname().sendKeys(lastname);
	}
	public WebElement dateBirth() {
		return driver.findElement(dateofBirthSelector);
	}
	public void inputDateBirth(String dateBirth) {
		dateBirth().sendKeys(dateBirth);
	}
	public WebElement email() {
		return driver.findElement(emailSelector);
	}
	public void inputEmail(String email) {
		email().sendKeys(email);
	}
	public WebElement phone() {
		return driver.findElement(phoneSelector);
	}
	public void inputPhone(String phone) {
		phone().sendKeys(phone);
	}
	public WebElement street1() {
		return driver.findElement(streetAddress1Selector);
	}
	public void inputStreet1(String street1) {
		street1().sendKeys(street1);
	}
	public WebElement street2() {
		return driver.findElement(streetAddress2Selector);
	}
	public void inputStreet2(String street2) {
		street2().sendKeys(street2);
	}
	public WebElement city() {
		return driver.findElement(citySelector);
	}
	public void inputCity(String city) {
		city().sendKeys(city);
	}
	public WebElement stateOrprovince() {
		return driver.findElement(stateOrprovinceSelector);
	}
	public void inputStateOrprovince(String stateOrProvince) {
		stateOrprovince().sendKeys(stateOrProvince);
	}
	public WebElement postalCode() {
		return driver.findElement(postalCodeSelector);
	}
	public void inputpostalCode(String postalCode) {
		postalCode().sendKeys(postalCode);
	}
	public WebElement country() {
		return driver.findElement(countrySelector);
	}
	public void inputCountry(String country) {
		country().sendKeys(country);
	}
	public WebElement editContactBtn() {
		return driver.findElement(editContactBtn);
	}
	
	public void editContactBtnClick() {
		editContactBtn().click();
	}
	public WebElement deleteContactBtn() {
		return driver.findElement(deleteContactBtn);
	}
	public void deleteContactBtnClick() {
		deleteContactBtn().click();
	}
	public WebElement returnBtn() {
		return driver.findElement(returnBtn);
	}
	public void returnBtnClick() {
		returnBtn().click();
	}
	public WebElement logoutBtn() {
		return driver.findElement(logoutBtn);
	}
	public void logoutBtnClick() {
		logoutBtn().click();
	}
	
	public WebElement error() {
		return driver.findElement(errorSelector);
	}

}
