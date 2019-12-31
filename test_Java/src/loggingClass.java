package lib;

import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

public class loggingClass {
	
	@Test(priority = 0)
	public void methodAddingNumber() {
		System.out.println("I am in method adddding num.");
	}
	
	@Test(priority = 1)
	public void devidedByZero() {
	System.out.println("I am in Devided by zero");
	int e = 1/0;
}
	
	@Test (dependsOnMethods =  {"devidedByZero"}   )
	public void MethodSkip() {
		System.out.println("Helloo.. Im in method skip");
		
	}
	
}
