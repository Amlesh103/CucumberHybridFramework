package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class SearchResultPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public SearchResultPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText= "HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath= "//p[contains(text(),'no product')]")
	private WebElement invalidProduct;
	
	public boolean productMatchingSearchResult() {
	//	return validProduct.isDisplayed();
		return elementUtils.displayStatusOnElements(validProduct, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String productMisMatchSearchResult() {
	//	return invalidProduct.getText();
		return elementUtils.getTextFromElement(invalidProduct, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
