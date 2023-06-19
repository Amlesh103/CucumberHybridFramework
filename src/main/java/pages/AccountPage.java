package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class AccountPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText = "Edit your account information" )
	private WebElement accountInfoLink;
	
	public boolean displayLoginStatus() {
		//return accountInfoLink.isDisplayed();
		
		return elementUtils.displayStatusOnElements(accountInfoLink,commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
