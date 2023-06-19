package utils;

import java.util.Date;

public class commonUtils {
	public static final int IMPLICT_WAIT_TIME= 10;
	public static final int PAGE_LOAD_TIME= 15;
	public static final int EXPLICIT_WAIT_BASIC_TIME= 30;
	
	public static String getEmailTimeStamp() {
		Date date = new Date();
		return "amlesh" + date.toString().replace(" ", "_").replace(":", "_") +"@gmail.com";
	}

}
