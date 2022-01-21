package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Baseclass;
import pageobjects.Searchobjects;
import pageobjects.loginpage;
import pageobjects.signinpage;

public class signintest extends Baseclass {

	signinpage Sign = new signinpage(driver);

	loginpage Login = new loginpage(driver);
	
	Searchobjects search = new Searchobjects(driver);
	

/**
 * This is a method to test  a scenario of the bookin.com
 * 
 * 
 * @return
 */
	@DataProvider(name = "logindata")

	public Object[][] testData() {

		return new Object[][] { { "navyashetty149@gmail.com", "@Asdfghjkl1" } };

	}

	@Test(dataProvider = "logindata")

	public void demo(String userName, String password) throws FileNotFoundException, IOException, InterruptedException {

		driver.get(getProperty("prod"));
		
		driver.manage().window().maximize();
		
		click(search.searhcity);
		
		setValue(search.Entercity, "Hyderabad");
		
		
		
		
		

		
		
		
		
		/*
		 * scrollToElement(search.Dublin);
		 * 
		 * click(search.Dublin);
		 * 
		 * screenshot();
		 */
		
		
		
		

		/*
		 * click(Sign.sigin);
		 * 
		 * setvalue(Login.enterusername, userName);
		 * 
		 * //screenshot();
		 * 
		 * click(Login.contiuewithemail);
		 * 
		 * Thread.sleep(2000);
		 * 
		 * setvalue(Login.enterpassword,password);
		 * 
		 * //screenshot();
		 * 
		 * click(Login.sigin);
		 */	
		
	}

}
