package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(id= "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id= "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id= "input-email")
	private WebElement emailField;
	
	@FindBy(id= "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id= "input-password")
	private WebElement passwordField;
	
	@FindBy(id= "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath= "//input[@name='agree']")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath= "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath= "//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterButton;
	
	@FindBy(xpath= "//div[contains(text(),'First Name')]")
	private WebElement firstNameFieldWarningMessage;
	
	@FindBy(xpath= "//div[contains(text(),'Last Name')]")
	private WebElement lastNameFieldWarningMessage;
	
	@FindBy(xpath= "//div[contains(text(),'E-Mail')]")
	private WebElement emailFieldWarningMessage;
	
	@FindBy(xpath= "//div[contains(text(),'Telephone')]")
	private WebElement telephoneFieldWarningMessage;
	
	@FindBy(xpath= "//div[contains(text(),'Password')]")
	private WebElement passwordFieldWarningMessage;
	
	@FindBy(xpath= "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyFieldWarningMessage;
	
	@FindBy(xpath= "//div[contains(@class,'alert-danger')]")
	private WebElement duplicateEmailWarningMessage;
	
	public void enterFirstName(String firstName) {
		// firstNameField.sendKeys(firstName);
		 elementUtils.typeTextIntoElement(firstNameField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, firstName);
	}
	
	public void enterLastname(String lastName) {
	//	lastNameField.sendKeys(lastName);
		elementUtils.typeTextIntoElement(lastNameField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, lastName);
		
	}
	
	public void enterEmail(String email) {
	//	emailField.sendKeys(email);
		elementUtils.typeTextIntoElement(emailField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, email);
	}
	
	public void enterTelephone(String telephone) {
	//	telephoneField.sendKeys(telephone);
		elementUtils.typeTextIntoElement(telephoneField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, telephone);
	}
	
	public void enterPassword(String password) {
	//	passwordField.sendKeys(password);
		elementUtils.typeTextIntoElement(passwordField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
	//	confirmPasswordField.sendKeys(confirmPassword);
		elementUtils.typeTextIntoElement(confirmPasswordField, commonUtils.EXPLICIT_WAIT_BASIC_TIME, confirmPassword);
	}
	
	public void clickOnPrivacyPolicyCheckbox() {
	//	privacyPolicyCheckBox.click();
		elementUtils.clickOnElement(privacyPolicyCheckBox, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountCreationSuccessPage clickOnContinue() {
	//	continueButton.click();
		elementUtils.clickOnElement(continueButton, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		return new AccountCreationSuccessPage(driver);
	}
	
	public void clickOnNewsLetter() {
	//	newsLetterButton.click();
		
		elementUtils.clickOnElement(newsLetterButton, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String displayFirstNameFieldWarningMessage() {
	//	return firstNameFieldWarningMessage.getText();
		
		return elementUtils.getTextFromElement(firstNameFieldWarningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
    public String displayLastNameFieldWarningMessage() {
	//	return lastNameFieldWarningMessage.getText();
		return elementUtils.getTextFromElement(lastNameFieldWarningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
    
    public String displayEmailFieldWarningMessage() {
	//	return emailFieldWarningMessage.getText();
		
		return elementUtils.getTextFromElement(emailFieldWarningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
    
    public String displayTelephoneFieldWarningMessage() {
	//	return telephoneFieldWarningMessage.getText();
		return elementUtils.getTextFromElement(telephoneFieldWarningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
    
    public String displayPasswordFieldWarningMessage() {
	//	return passwordFieldWarningMessage.getText();
		return elementUtils.getTextFromElement(passwordFieldWarningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
    
    public String displayPrivacyPolicyFieldWarningMessage() {
	//	return privacyPolicyFieldWarningMessage.getText();
		
		return elementUtils.getTextFromElement(privacyPolicyFieldWarningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String displayDuplicateEmailWarningMessage() {
	//	return duplicateEmailWarningMessage.getText();
		return elementUtils.getTextFromElement(duplicateEmailWarningMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
