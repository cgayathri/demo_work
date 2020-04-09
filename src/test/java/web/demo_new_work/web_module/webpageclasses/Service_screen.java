package web.demo_new_work.web_module.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;

public class Service_screen extends BaseClass {
	public static String projectName = "demo_new_work";
	public WebDriver driver;

	public Service_screen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Business Assurance Validation')]")	
	private WebElement	BusinessAssuranceValidation_473404a;
	public String clkaBusinessAssuranceValidation_473404() {
		waitForExpectedElement(driver, BusinessAssuranceValidation_473404a);		
		String text = BusinessAssuranceValidation_473404a.getText();
		BusinessAssuranceValidation_473404a.click();
		return text;
	}

}