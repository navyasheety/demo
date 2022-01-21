package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Baseclass;
import pageobjects.Searchobjects;
import utils.ExcelUtils;

public class Completetest extends Baseclass {

	Searchobjects search = new Searchobjects(driver);
	
	/*
	 * @DataProvider(name="testdata") public Object[][] readData() throws
	 * FileNotFoundException, IOException{ Object [][] testData =
	 * getExcelData(getProperty("excel"), "login"); return testData;
	 * 
	 * }
	 */
	 
	  @DataProvider(name="testdata") 
	   public Object[][] readData(Method m) throws FileNotFoundException, IOException{ 
	   Object [][] testData = ExcelUtils.getDataFromExcel(getProperty("excel"), "data", m.getName()); 
	  return testData;
	  
	  }
	  
	  @Test(dataProvider="testdata")
		public void facebook(HashMap<String,String> data) throws FileNotFoundException, IOException {
		  
		  driver.get(getProperty("fb"));
			
			click(search.createAccount);
	
			waitForElement(search.firstname);
			
			setValue(search.firstname,data.get("first"));
			
			setValue(search.lastname,data.get("last"));
			
			setValue(search.fbemail,data.get("email"));
			
			setValue(search.fbpassword,data.get("password"));
			 
			
		}
	  
	
	

	@Test(dataProvider="testdata", enabled=false)

	public void sample(String first, String last,String mobile,String city ) throws FileNotFoundException, IOException, InterruptedException {

		driver.get(getProperty("prod"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		System.out.println(mobile+" "+city);
		

		//driver.manage().window().maximize();

		/*
		 * click(search.searhcity);
		 * 
		 * setvalue(search.searhcity, "hyd");
		 * 
		 * waitForElement(search.Entercity);
		 *
		 * moveAndClick(search.Entercity, search.Entercity);
		 * 
		 * click(search.gotocheckin);
		 * 
		 * Thread.sleep(2000);
		 * 
		 * moveAndClick(search.gotocheckin, search.checkindate);
		 * 
		 * moveAndClick(search.checkindate, search.checkoutdate);
		 * 
		 * waitForElement(search.selectcount);
		 */
		//click(search.selectcount);
		
		
		
		//addadult(search.selectadult, 2);
		
		

		//click(search.selectadult);
		
	

		/*
		 * waitForElement(search.Imtravelling);
		 * 
		 * click(search.Imtravelling);
		 * 
		 * waitForElement(search.buttonsearch);
		 * 
		 * click(search.buttonsearch);
		 * 
		 * screenshot();
		 */		  
		   

	}
	
	

}