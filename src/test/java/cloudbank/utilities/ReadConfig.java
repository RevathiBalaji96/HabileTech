package cloudbank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		
		File src=new File("./configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			 System.out.println("exception is"+ e.getMessage());
		}
		
		
		
	}
	
	public String geturl() {
		String url=pro.getProperty("Baseurl");
		return url;
	}
	public String getusername() {
		String u_name=pro.getProperty("Username");
		return u_name;
	}
	public String getpassword() {
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String getchromepath() {
		String path=pro.getProperty("chromepath");
		return path;
	}
}
