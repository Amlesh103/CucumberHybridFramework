package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.commonUtils;

public class Login {
	
	WebDriver driver= DriverFactory.getDriver();
	private LoginPage loginPage;
	private AccountPage accountPage;

	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		HomePage homePage = new HomePage(driver);
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    homePage.clickOnMyAccount();
		//driver.findElement(By.xpath("//a[text()='Login']")).click();
	    loginPage = homePage.clickonLogin();
		
	   	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
	//	loginPage = new LoginPage(driver);
	//	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailText);
		loginPage.sendValueinEmailField(emailText);
		
	    
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passwordText);
		loginPage.enterPassword(passwordText);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
	   // driver.findElement(By.xpath("//input[@value='Login']")).click();
		accountPage = loginPage.clickLoginBtn();
	}

	@Then("User should be successfully logged in")
	public void user_should_be_successfully_logged_in() {
	//	accountPage = new AccountPage(driver);
	  //  Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		Assert.assertTrue(accountPage.displayLoginStatus());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
	//	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(getEmailTimeStamp());
	//	loginPage = new LoginPage(driver);
		loginPage.sendValueinEmailField(commonUtils.getEmailTimeStamp());
	    
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
	//	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(invalidPasswordText);
		loginPage.enterPassword(invalidPasswordText);
	    
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		//Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText() );
		
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", loginPage.errorMessageVerify() );
		
	    
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
	//	loginPage = new LoginPage(driver);
		loginPage.sendValueinEmailField("");
	    
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginPage.enterPassword("");
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
	    
	}
	
//	public String getEmailTimeStamp() {
//		Date date = new Date();
//		return "amlesh" + date.toString().replace(" ", "_").replace(":", "_") +"@gmail.com";
//	}
	


}
