package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountCreationSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.commonUtils;


public class Register {
	WebDriver driver= DriverFactory.getDriver();
	private HomePage homePage;
	private RegisterPage registerPage;
	private AccountCreationSuccessPage accountCreationSuccessPage;
	
	@Given("User navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.clickOnRegister();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();			    
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
	//	registerPage = new RegisterPage(driver);
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	//	driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		registerPage.enterFirstName(dataMap.get("firstName"));
	//	driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		registerPage.enterLastname(dataMap.get("lastName"));
	//	driver.findElement(By.id("input-email")).sendKeys(getEmailTimeStamp());
		registerPage.enterEmail(commonUtils.getEmailTimeStamp());
	//	driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		registerPage.enterTelephone(dataMap.get("telephone"));
	//	driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		registerPage.enterPassword(dataMap.get("password"));
	//	driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
	}
	
	@When("User enters the details into below fields with duplicate fields")
	public void user_enters_the_details_into_below_fields_with_duplicate_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
//		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
//		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	//	registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastname(dataMap.get("lastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		

	}	

	@And("User selects privacy policy")
	public void user_selects_privacy_policy() {
	 //   driver.findElement(By.xpath("//input[@name='agree']")).click();
		registerPage.clickOnPrivacyPolicyCheckbox();
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		
	//	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	//	registerPage = new RegisterPage(driver);
		accountCreationSuccessPage = registerPage.clickOnContinue();
	    
	}


	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	//	accountCreationSuccessPage = new AccountCreationSuccessPage(driver);
	
	    Assert.assertEquals("Your Account Has Been Created!", accountCreationSuccessPage.displayAccountCreationMessage());
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
	//	driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		registerPage.clickOnNewsLetter();
	    
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals("Warning: E-Mail Address is already registered!", registerPage.displayDuplicateEmailWarningMessage());
	    
	}

	@When("User dont enters any details into fields")
	public void user_dont_enters_any_details_into_fields() {
		
	    
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
		
		Assert.assertTrue(registerPage.displayFirstNameFieldWarningMessage().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerPage.displayLastNameFieldWarningMessage().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerPage.displayEmailFieldWarningMessage().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(registerPage.displayTelephoneFieldWarningMessage().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(registerPage.displayPasswordFieldWarningMessage().contains("Password must be between 4 and 20 characters!"));
		Assert.assertTrue(registerPage.displayPrivacyPolicyFieldWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
	    
	}
	
//	public String getEmailTimeStamp() {
//		Date date = new Date();
//		return "amlesh" + date.toString().replace(" ", "_").replace(":", "_") +"@gmail.com";
//	}

}
