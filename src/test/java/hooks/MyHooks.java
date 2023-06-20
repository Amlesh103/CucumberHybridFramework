package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;

	@Before
	public void setup() {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\config\\systemprofile\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
        driver = new ChromeDriver();	
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
