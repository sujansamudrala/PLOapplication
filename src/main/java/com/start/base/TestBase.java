package com.start.base;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String usr;
	public static String pwd;
	public static ExtentTest test;
	public static WebDriverWait wait;


	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\start\\config\\config.properties");
			prop.load(fis);
		}
		catch(Exception e) {
			System.out.println("Not Able To Load the Properties File");
		}

		byte[] byteArray = Base64.decodeBase64(prop.getProperty("username").getBytes());
		byte[] byteArray1 = Base64.decodeBase64(prop.getProperty("password").getBytes());
		usr = new String(byteArray);
		pwd = new String(byteArray1);
		/*usr = new String(prop.getProperty("username"));
		pwd = new String(prop.getProperty("password"));*/
		}

	public static void intilization() {
		String browserName= prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			//DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();       
			//handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);			
			System.setProperty("webdriver.chrome.driver",".\\src\\main\\java\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			wait =new WebDriverWait(driver, 30);
			
			
			/*DesiredCapabilities capabilities = DesiredCapabilities.chrome();

			ChromeDriverService service = new ChromeDriverService.Builder()
			                    .usingDriverExecutable(new File(".\\src\\main\\java\\executables\\chromedriver.exe"))
			                    .usingAnyFreePort()
			                    .build();
			ChromeOptions options = new ChromeOptions();
			options.merge(capabilities); 
			ChromeDriver driver = new ChromeDriver(service, options);
			wait =new WebDriverWait(driver, 30);*/
		
			/*String exePath = "src\\main\\java\\executables\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			String downloadFilepath = "D:\\data\\download";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cap);
			driver = new ChromeDriver(options);
			wait =new WebDriverWait(driver, 30);*/
		
		}else if(browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\src\\main\\java\\executables\\gecko.exe");
			driver = new FirefoxDriver();
			wait =new WebDriverWait(driver, 30);
		}else if (browserName.contains("ie")) {
			System.setProperty("webdriver.ie.driver",".\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			wait =new WebDriverWait(driver, 30);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

}
