package lib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener_simple1 extends TestBase implements ITestListener  {

	

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test case failed and details are : " + result.getName());
		
		
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test case skipped and details are : " + result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
	
		System.out.println("test case started and details are : "+ result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test case finished and details are : "+ result.getTestName()); 
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
