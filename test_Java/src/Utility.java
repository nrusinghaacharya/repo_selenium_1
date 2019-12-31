package lib;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	ChromeDriver driver;
	
	
	public void testScreenShot() {
		System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	   File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File destFile = new File("D:\\SELENIUM\\eclipse-workspace\\for exel\\screenShots\\error_"+ System.currentTimeMillis() + ".png");
	   
	   //FileUtils.copyFile(srcFile, destFile);
		
	}

}
