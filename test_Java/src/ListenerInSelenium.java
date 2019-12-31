package lib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

//import org.apache.commons.*;

public class ListenerInSelenium extends TestBase implements ITestListener {

	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}  
		
	

	 @Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		
		
		//File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) ;
		//destFile = 
		
		//FileUtils.copyFile(srcFile, destFile);

	}

	@Override
	public void onTestSuccess(ITestResult result) {


	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		
			//TakesScreenshot ts = (TakesScreenshot)driver ;
			if(result.getStatus() ==  ITestResult.FAILURE ) {
				try {
					
					//File srcFile = ts.getScreenshotAs(OutputType.FILE);
					
					File srcFile = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
					File destFile = new File("D:\\SELENIUM\\eclipse-workspace\\for exel\\screenShots\\" + result.getName() + ".png");
					FileUtils.copyFile(srcFile, destFile);
					System.out.println("screen shot taken");
					
				} catch (Exception e) 
				{
					System.out.println("Exception while taking snapshot: " +  e.getMessage());
				}
				
				driver.close();
				
				/*if (result.isSuccess()) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
				String MethodName = result.getName();
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try {
					String reportDir = new File(System.getProperty("user.dir")).getAbsolutePath() + "src/test/java";
					File destFile = new File(reportDir + "/SuccessScreenShots/" + MethodName + formater.format(cal.getTime()) + ".png");
					FileUtils.copyFile(srcFile, destFile);

					Reporter.log("<a href = '" + destFile.getAbsolutePath() + "'> <img src = '" + destFile.getAbsolutePath()
							+ "' height = '100' width ='100'/> </a>");

				} catch (IOException e) {
					e.printStackTrace();
				}
			} */ 
			
				
				
				
			}
			
			
		
		
		
		
	}

}
