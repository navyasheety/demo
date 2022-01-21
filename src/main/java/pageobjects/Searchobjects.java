package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchobjects {
	
	
public WebDriver driver;
	
	public  Searchobjects (WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(name="ss")
	
	public WebElement searhcity;
	
	@FindBy(xpath="(//span[text()='Hyderabad'])")
	
	public WebElement Entercity;
	
	@FindBy(xpath="//div[@data-mode='checkin']")
	
	public WebElement gotocheckin;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	
	public WebElement buttonsearch;
	
	@FindBy(xpath="(//div[@class='bui-calendar__wrapper'])[1]//tbody/tr[3]//td//span[text()='12']")
	
	public WebElement checkindate;
	
	@FindBy(xpath="(//div[@class='bui-calendar__wrapper'])[2]//tbody/tr[1]//td//span[text()='5']")
	
	public WebElement checkoutdate;
	
	
	
	@FindBy(xpath="(//span[@class='bui-avatar-block__title'])")
	
	public WebElement youraccount;
	
	@FindBy(className="xp__guests__count")
	
	public WebElement selectcount;
	
	
	
	@FindBy(xpath="(//button[contains(@class,'bui-button')])[4]")
			
	public WebElement selectadult;
	
	
	@FindBy(xpath="//div[@class='promotion-postcard__large']")		
	
	public WebElement Dublin;
	
	@FindBy(xpath="(//label[contains(@class,'bui-checkbox')])[2]")
	
	public WebElement Imtravelling;
			
			
	@FindBy(xpath="//a[text()='Create New Account']")
	
	public WebElement createAccount;
	
   @FindBy(name="firstname")
	
	public WebElement firstname;
	
	
   @FindBy(name="lastname")
	
	public WebElement lastname;
	
   

   @FindBy(name="reg_email__")
	
	public WebElement fbemail;
	
	
   @FindBy(name="reg_passwd__")
	
  	public WebElement fbpassword;
  	
	
	
}
