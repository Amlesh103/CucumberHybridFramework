package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class SearchPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public SearchPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);	
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath= "//input[@name='search']")
	private WebElement searchBox;
	
	@FindBy(xpath= "//button[contains(@class,'btn-default')]")
	private WebElement searchBtn;
	
	public void searchBox(String validProductText) {
	//	searchBox.sendKeys(validProductText);
		elementUtils.typeTextIntoElement(searchBox, commonUtils.EXPLICIT_WAIT_BASIC_TIME, validProductText);
		
	}
	
	public SearchResultPage searchBtnClick() {
	//	searchBtn.click();
		elementUtils.clickOnElement(searchBtn, commonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultPage(driver);
	}

}
