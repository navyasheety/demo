package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="(//div[@class='bui-calendar__wrapper'])[1]//tbody/tr[3]/td[2]")
	
	public WebElement checkindate;
	
	@FindBy(xpath="(//div[@class='bui-calendar__wrapper'])[2]//td[3]")
	
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
	
   @FindBy(xpath="//div[@data-testid='title']")
   
   public List<WebElement> hotelNames;
   
   
   @FindBy(name="reg_email__")
	
	public WebElement fbemail;
	
	
   @FindBy(name="reg_passwd__")
	
  	public WebElement fbpassword;
   
   public WebElement getcheckin(String date) {
	   
	   return driver.findElement(By.xpath(String.format("//td[@data-date='%s']", date)));
	   
	   
	   
   }
  	
	
	
}
