package web.demo_new_work.web_module.webtestclasses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import web.demo_new_work.web_module.webpageclasses.Home_screen;
import web.demo_new_work.web_module.webpageclasses.Service_screen;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.Utilities;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class TC_TC_Dev extends BaseClass {
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	private String browserName = "chrome";
	public boolean isElementDispalyed = false;


	public TC_TC_Dev() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC_TC_Dev.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("tc_tc_dev.properties");
	}

	@BeforeTest
	@Parameters("browser")
	public void browserName(String browser) throws Exception {
		browserName = browser;
	}

	
	public void setUP() throws Exception {
		driver = launchBrowser(browserName, configFileObj);
	}

	public void Home_screenTest(int i) throws Exception {

	 try{
		int datasetScreencount = 1;
		Home_screen objHome_screen = PageFactory.initElements(driver, Home_screen.class);
		testLogHeader("Verify Home_screen page");
		objHome_screen.clkaServices_473114();
		printSuccessLogAndReport( logger,  "Text is displayed as : ServicesLink");

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport( logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	

	public void Service_screenTest(int i) throws Exception {

	 try{
		int datasetScreencount = 2;
		Service_screen objService_screen = PageFactory.initElements(driver, Service_screen.class);
		testLogHeader("Verify Service_screen page");
		objService_screen.clkaBusinessAssuranceValidation_473404();
		printSuccessLogAndReport( logger,  "Text is displayed as : BusinessAssuranceValidationLink");

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport( logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void screensTest() throws Exception {
		for(int datasets = 1; datasets <= configFileObj.getIntProperty("datasetsLength"); datasets++) {
			isElementDispalyed = true;			
			setUP();			
			setTestcaseName(browserName,"TC_TC_Dev - " + configFileObj.getProperty("dataset" + (datasets)));
			Home_screenTest(datasets);
			Service_screenTest(datasets);
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		driver.quit();
	}
}