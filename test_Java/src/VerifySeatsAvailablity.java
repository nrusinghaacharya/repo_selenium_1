package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VerifySeatsAvailablity extends TestBase {

	@Test
	public void testEventListener() {

		driver.get(
				"https://www.redbus.in/search?fromCityName=Hyderabad%20(All%20Locations)&fromCityId=124&toCityName=Visakhapatnam%20(All%20Locations)&toCityId=248&onward=10-Jun-2019&opId=0&busType=Any");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='mBWrapper']//div[@id='root']//div[@class = 'search']//div[@class='srp-data clearfix']//div[@class='result-sec']//li[@id='10659067']//div[@class = 'clearfix bus-item']//div[@class='clearfix m-top-16']//div[@class='button view-seats fr']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		int seats = Integer.parseInt(driver.findElement(By.xpath("//li[@id='10659067']//div[@class='seat-left m-top-16']")).getText());
		
		driver.findElement(By.xpath("//canvas[@data-type= 'upper']")).getText();
	}

}
