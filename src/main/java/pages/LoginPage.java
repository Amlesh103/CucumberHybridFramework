package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	
	@FindBy(xpath= "//input[@id='input-email']")
	private WebElement emailField;
	
	public void sendValueinEmailField(String emailText) {
		
	//	emailField.sendKeys(emailText);
		elementUtils.typeTextIntoElement(emailField,commonUtils.EXPLICIT_WAIT_BASIC_TIME,emailText);
	}
	
	@FindBy(xpath= "//input[@id='input-password']")
	private WebElement passwordField;
	
	public void enterPassword(String passwordText) {
      //  passwordField.sendKeys(passwordText);
        elementUtils.typeTextIntoElement(passwordField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, passwordText);
		
	}
	
	@FindBy(xpath= "//input[@value='Login']")
	private WebElement loginBtn;
	
	public AccountPage clickLoginBtn() {
	//	loginBtn.click();
		elementUtils.clickOnElement(loginBtn, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement credentialsErrorMessage;
	
	public String errorMessageVerify() {
		//return credentialsErrorMessage.getText();
		return elementUtils.getTextFromElement(credentialsErrorMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
