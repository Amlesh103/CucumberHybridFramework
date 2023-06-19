package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;

	@Before
	public void setup() {
	    driver = DriverFactory.initializeBrowser(ConfigReader.initializeProprties().getProperty("browser"));
//	    driver = DriverFactory.getDriver();
	    driver.get(ConfigReader.initializeProprties().getProperty("url"));
	    
	}
	
	@After
	public void tearDown(Scenario scenario) {
		//driver = DriverFactory.getDriver();
		String failedScenarioName = scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed()) {
			byte[] srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreenShot, "image/png", failedScenarioName);			
		}
		driver.quit();
	}
}
