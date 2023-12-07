package page_object_Heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditContact_page {

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
	
	private By firstnameLabel=By.cssSelector("label[for='firstName']");
	//private By lastnameLabel=By.cssSelector("label[for='lastName']");
	private By dateBirthLabel=By.cssSelector("label[for='birthdate']");
	//private By emailLabel=By.cssSelector("label[for='email']");
	private By countryLabel=By.cssSelector("label[for='country']");
	
	private By errorSelector=By.id("error");
	
	private By submitBtn=By.id("submit");
	private By cancelBtn=By.id("cancel");
	private By logoutBtn=By.id("logout");
	
	public EditContact_page(WebDriver driver) {
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
	public WebElement firstnameLabel() {
		return driver.findElement(firstnameLabel);
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
	public WebElement dateBirthLabel() {
		return driver.findElement(dateBirthLabel);
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
	
	public WebElement countryLabel() {
		return driver.findElement(countryLabel);
	}
	public WebElement submitBtn() {
		return driver.findElement(submitBtn);
	}
	
	public void submitBtnClick() {
		submitBtn().click();
	}
	public WebElement cancelBtn() {
		return driver.findElement(cancelBtn);
	}
	public void cancelBtnClick() {
		cancelBtn().click();
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
	
	public void EditContact(String firstname,String lastname,String dateBirth,String email, String phone, 
			String street1, String street2,String city, String stateOrProvince,String postalCode,String country) {
		//clear old data
		firstname().clear();
		lastname().clear();
		dateBirth().clear();
		phone().clear();
		email().clear();
		street1().clear();
		street2().clear();
		city().clear();
		stateOrprovince().clear();		
		postalCode().clear();
		country().clear();
		//input new data		
		inputFirstName(firstname);
		inputLastName(lastname);
		inputDateBirth(dateBirth);
		inputEmail(email);
		inputPhone(phone);
		inputStreet1(street1);
		inputStreet2(street2);
		inputCity(city);
		inputStateOrprovince(stateOrProvince);
		inputpostalCode(postalCode);
		inputCountry(country);	
		
		submitBtnClick();
	}
}
