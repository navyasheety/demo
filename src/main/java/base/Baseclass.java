package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class Baseclass {
	
public static WebDriver driver;
	
	public static WebDriverWait wait;
	
	public static ExtentReports reporter;
	
	public static ExtentTest Logger;
	
	public static ExtentSparkReporter sparkReporter;
	
	public static  String filepath;
	
	@BeforeTest
	
	public void setup() {
		
		filepath="Reports/statusReport.html";
		
		sparkReporter = new ExtentSparkReporter(filepath);
		
		reporter = new ExtentReports();
		
		reporter.attachReporter(sparkReporter);
		
		
		
	}
	
	
	static {
		
     System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\eclipse-workspace\\demo\\src\\test\\resources\\chromedriver.exe");
     
     ChromeOptions options = new ChromeOptions();
     
     options.addArguments("start-maximized");
     
     options.addArguments("--incognito");
     
     options.addArguments("disable-popup-blocking");
     
     options.addArguments("disable-notifications");
     
    	
		driver=new ChromeDriver(options);
		
		
	}

	public void click (WebElement e) {
		
		e.click();
	}
	
	public void setValue (WebElement e,String value) {
		
		e.clear();
		
		e.sendKeys(value);
		
	}
	
	public void waitForElement(WebElement e) {
		
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(e));
		
			
	}
	
	public void addadult(WebElement e, int count ) {
		
		while(count>0) {
			
			
			
			e.click();
			
			count--;
			
			
			
			
		}
		
		
	}
	
	public void moveAndClick(WebElement e1 , WebElement e2) {
		
		Actions action= new Actions (driver);
		
		action.moveToElement(e1).click(e2).build().perform();
		
	}
	

	
	public  static String getProperty(String key) throws FileNotFoundException, IOException {
		
		Properties prop =new Properties();
		
		File f = new File ("src/test/resources/application.properties");
		
		prop.load(new FileInputStream(f));
		
		return prop.getProperty(key);
		
		
	}
	
	public void screenshot() throws IOException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String date = dateFormat.format(new Date());
		
		
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(f, new File ("./Screenshots/"+date+".png"));
		
		
		
		
	}
	
	public void screenshot(String status, String name) throws IOException {
		
		
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		if(status.equalsIgnoreCase("FAILURE")) {
			
			FileUtils.copyFile(f, new File ("./FailureScreenshots/"+name+".png"));
			
			
		}
		
		
		else if (status.equalsIgnoreCase("SUCESS")) {
			
			FileUtils.copyFile(f, new File ("./SucessScreenshots/"+name+".png"));
			
			
			
		}
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		
		
		if(ITestResult.FAILURE==result.getStatus()) {
			
			
			screenshot("FAILURE", result.getName());
			
			Logger.fail(result.getName()+ "is failed!!!!");
			
			
			
			
			
			
			
		}else {
			
			
			screenshot("SUCESS", result.getName());
			
			Logger.pass(result.getName()+ " is passed!!!");
			
			
			
			
			
		}
		
		
		
	}
	
	public void scrollToElement(WebElement e) {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",e);
		
		
	}
	
	public static String[][] getExcelData(String filename, String sheet) throws IOException{
		
		
	
		
		FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\demo\\src\\test\\resources\\navya.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh = wb.getSheet(sheet);
		
		int rows = sh.getLastRowNum();
		
		int cols = sh.getRow(0).getLastCellNum();
		
		String[][] data = new String [rows][cols];
		
for(int i=1;i<=rows;i++) {
	
	
	for(int j=0;j<cols;j++) {
		
		
		Cell c = sh.getRow(i).getCell(j);
		
		DataFormatter dataFormatter = new DataFormatter();
		
		String value = dataFormatter.formatCellValue(c);
		
		data[i-1][j]=value;
		
		
		
		
	}
}
			
			
		
		return data;
	}
	
	@AfterTest(enabled=true)
	public void closeDriver() {
		
		reporter.flush();
		driver.close();
		
		
	}
	

}
