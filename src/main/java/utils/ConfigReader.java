package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties initializeProprties() {
		Properties prop = new Properties();
		FileInputStream	fis;
	
		try {
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/config/config.properties"));
		    prop.load(fis);
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}

}
