package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class HomePage {
	
	 WebDriver driver;
	 private ElementUtils elementUtils;
	 
	 public HomePage(WebDriver driver) {
		 this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
				 
	 }
	 
	 @FindBy(xpath = "//span[text()='My Account']")
	 private WebElement myAccountLink;
	 
	 public void clickOnMyAccount() {
		 elementUtils.clickOnElement(myAccountLink,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	 }
	 
	 @FindBy(xpath = "//a[text()='Login']")
	 private WebElement loginBtnLink;
	 
	 public LoginPage clickonLogin() {
		 elementUtils.clickOnElement(loginBtnLink,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 return new LoginPage(driver);
	 }
	 
	 @FindBy(linkText= "Register")
	 private WebElement registerBtnLink;
	 
	 public RegisterPage clickOnRegister() {
		 elementUtils.clickOnElement(registerBtnLink,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 return new RegisterPage(driver);
	 } 
	 
	 
	 

}
