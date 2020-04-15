package web.demo_new_work.web_module.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;

public class Home_screen extends BaseClass {
	public static String projectName = "demo_new_work";
	public WebDriver driver;

	public Home_screen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//li[@id='menu-item-399']/a")	
	private WebElement	Services_473114a;
	public String clkaServices_473114() {
		waitForExpectedElement(driver, Services_473114a);		
		String text = Services_473114a.getText();
		Services_473114a.click();
		return text;
	}

}