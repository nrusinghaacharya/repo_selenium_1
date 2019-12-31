package lib;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class ListenersClass extends TestListenerAdapter {

	@Override
	public void onTestStart(ITestResult tr) {
	
	
		
	}
	
	

	@Override
	public void onTestFailure(ITestResult tr) {
	//	log("test ' " + tr.getName() + "' failed.");
	//	log(tr.getTestClass());
		
		
	}
	
	@Override 
	public void  onTestSuccess(ITestResult tr) {
		
	}
}
