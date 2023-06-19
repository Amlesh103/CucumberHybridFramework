package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class AccountCreationSuccessPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountCreationSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	private WebElement accountCreationMessage;
	
	public String displayAccountCreationMessage() {
	//	return accountCreationMessage.getText();
		return elementUtils.getTextFromElement(accountCreationMessage, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
