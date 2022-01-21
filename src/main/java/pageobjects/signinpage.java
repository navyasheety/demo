package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signinpage {

	
	
	public WebDriver driver;
	
	public  signinpage (WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="(//a[@class='bui-button bui-button--secondary js-header-login-link'])[2]")
	
	public WebElement sigin;
	

	
}
