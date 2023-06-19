package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.SearchPage;
import pages.SearchResultPage;
import utils.ConfigReader;

public class Search {
	
	WebDriver driver = DriverFactory.getDriver();
	private SearchPage searchPage;
	private SearchResultPage searchResultPage;
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
		driver.get(ConfigReader.initializeProprties().getProperty("url"));
	    
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
		searchPage = new SearchPage(driver);
		searchPage.searchBox(validProductText);
		
	   // driver.findElement(By.xpath("//input[@name='search']")).sendKeys(validProductText);
	}

	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
	//	driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
		searchResultPage=  searchPage.searchBtnClick();
	    
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	//	searchResultPage = new SearchResultPage(driver);
		Assert.assertTrue(searchResultPage.productMatchingSearchResult());
	    
	}

	

	@When("Users enters invalid product {string} into search box field")
	public void users_enters_invalid_product_into_search_box_field(String invalidProductText) {
	//	driver.findElement(By.xpath("//input[@name='search']")).sendKeys(invalidProductText);
		searchPage = new SearchPage(driver);
		searchPage.searchBox(invalidProductText);
	    
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	//	searchResultPage = new SearchResultPage(driver);
		Assert.assertTrue(searchResultPage.productMisMatchSearchResult().contains("There is no product that matches the search criteria."));
		Assert.fail();
	    
	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		
	//	driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
		searchPage = new SearchPage(driver);
		searchPage.searchBox("");
	}


}
