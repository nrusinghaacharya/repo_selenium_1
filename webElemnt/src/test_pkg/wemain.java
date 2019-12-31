package test_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import java.awt.List;
import java.util.List;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import okio.Timeout;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;



public class wemain {
	
	
@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty(webdriver.chrome.driver, "")
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/test/newtours");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String titl= "Under Construction: Mercury Tours";
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		int i = 0;
		
		//Extract the link txts 
		
		for(WebElement e : linkElements )
		{
			linkTexts[i]= e.getText();
			//System.out.println("The links are:  " + e.getText() );
			i++;
		}
		
		for(String t: linkTexts)
		{
			driver.findElement(By.linkText(t)).click();
			if (driver.getTitle().equals(titl))
			{
				System.out.println("\"" + t + "\"" + "  is  under construction");
			}
			else
			{
				System.out.println("\"" + t + "\"" + "  is  working");
			}
			
			driver.navigate().back();
			driver.get("http://demo.guru99.com/test/newtours");
		}
		
		
		
		/*
		 * Code for Java WebTable*
		driver.get("http://demo.guru99.com/test/accessing-nested-table.html");
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]")).click();
        
        System.out.println("2nd row 2nd col a, again 1st row 1st col is :  " + driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[1]")).getText());
        System.out.println("2nd row 2nd col a, again 1st row 2nd col is :  " + driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]")).getText());
        System.out.println("2nd row 2nd col a, again 2nd row 1st col is :  " + driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]")).getText());
        System.out.println("2nd row 2nd col a, again 2nd row 2nd col is :  " + driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]")).getText());
        
        driver.get("http://demo.guru99.com/test/newtours/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
        System.out.println(" Lan table data :  " + driver.findElement(By.xpath("//table[@width='270']/tbody/tr[3]/td[2]")).getText());
        
        System.out.println(" Haat hat ht sale:  " + driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr[3]/td[1]/font")).getText());
        
        */
        
         
     
       // List<WebElement> elements = driver.findElements(By.name("name"));
     /*if ( driver.findElement(By.xpath("//input [@value = 'No']")).isSelected() == true) 
     {
    	 System.out.println("check box seleced");
     }
     else
     {
    	 System.out.println("check box not seleced");
     }
     */        
		
		
		
		driver.close();
		
}
	

}
