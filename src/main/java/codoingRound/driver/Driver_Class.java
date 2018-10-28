package codoingRound.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.javafx.PlatformUtil;

public class Driver_Class {

	protected WebDriver driver;

	public void initialization(String browserName,String Url){
	  setDriverPath(browserName);
	  setBrowser(browserName);
	  driver.get(Url);
	}

	public void setBrowser(String browserName){
		if(browserName.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("firefox")){
		    driver = new FirefoxDriver();
		}
		
	}
	
	public void setDriverPath(String browserName) {
		    String userDir=System.getProperty("user.dir");
		    if(browserName.equalsIgnoreCase("chrome")){
		    	if (PlatformUtil.isMac()) {
		            System.setProperty("webdriver.chrome.driver", userDir+"/chromedriver");
		        }
		        if (PlatformUtil.isWindows()) {
		            System.setProperty("webdriver.chrome.driver", userDir+"/chromedriver.exe");
		        }
		        if (PlatformUtil.isLinux()) {
		            System.setProperty("webdriver.chrome.driver", userDir+"/chromedriver.linux");
		        }
		    } else if(browserName.equalsIgnoreCase("firefox")) {
		    	if (PlatformUtil.isMac()) {
		            System.setProperty("webdriver.firefox.driver", userDir+"/chromedriver");
		        }
		        if (PlatformUtil.isWindows()) {
		            System.setProperty("webdriver.firefox.driver", userDir+"/chromedriver.exe");
		        }
		        if (PlatformUtil.isLinux()) {
		            System.setProperty("webdriver.firefox.driver", userDir+"/chromedriver.linux");
		        }
		    }
		    
	        
	}

	public void exitBrowser() {
		driver.quit();
		
	}

}



