package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	

	public WebDriver driver;
	
	public  loginpage (WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(name="username")
	
	public WebElement enterusername;
	
	@FindBy(xpath="//span[normalize-space()='Continue with email']")
	
	public WebElement contiuewithemail;
	
	@FindBy(name="password")
	
	public WebElement enterpassword;
	
    @FindBy(xpath="//button[@type='submit']")
	
	public WebElement sigin;
}
