package extent_report_demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;


import org.apache.commons.io.FileUtils;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;


public class NopCommerceTest {
	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentRep;
	public ExtentTest test;

	@BeforeTest
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/myReport.html");
		
		htmlReporter.config().setDocumentTitle(" Doc titled doc");
		htmlReporter.config().setReportName("my reporter TAG");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extentRep = new ExtentReports();
		extentRep.attachReporter(htmlReporter);
		
	}
	
	@AfterTest
	public void endReport() {
	
		extentRep.flush();
	}
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/demo");
		
	}
	
	@Test
	public void  NoComTitleTest() {
		test = extentRep.createTest("noCommerceTitleTest");
		
		String title = driver.getTitle();
		System.out.println("Title of the Page is: "  +  title);
		Assert.assertEquals(title, "nopcommerce demo store");
				
	}
	
	
	@Test
	public void NopCommerceLogoTest() {
		test = extentRep.createTest("nopcommerce logo test");
		boolean status =  driver.findElement(By.xpath("//img[@title='nopCommerce']")).isDisplayed();
		Assert.assertTrue(status);
		
	}
	
	@Test
	public void NopCommerceLoginTest() {
		test = extentRep.createTest("NopCommerceLoginTest");
		Assert.assertTrue(true);
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		
		if(result.getStatus() ==  ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is:" + result.getName());  // to add name to extent report
			test.log(Status.FAIL, "Test Case Failed is:" + result.getThrowable()); // Add Exception e

			String screenShotpath = NopCommerceTest.getScreenShot(driver, result.getName());
			test.addScreenCaptureFromPath(screenShotpath);
			}
		
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test case skipped is" + result.getName());
		}
		
		else if(result.getStatus() ==  ITestResult.SUCCESS) {
			test.log(Status.PASS, "test case passed is: " + result.getName());
		}
		
		
		driver.quit();
		
		
			
	}
	
	public static String getScreenShot (WebDriver driver, String ScreenShotName) throws IOException {
		String datename = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	    
		//TakesScreenshot ts =  (TakesScreenshot) driver;
		//File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File srcFile = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		
		
		//After execution
		
		String dest = System.getProperty("user.dir") + "/ScreenShots/" + ScreenShotName + datename + ".png";
		File destFile = new File (dest);
		FileUtils.copyFile(srcFile, destFile);
		return dest;
		
		
	}
	
}
 