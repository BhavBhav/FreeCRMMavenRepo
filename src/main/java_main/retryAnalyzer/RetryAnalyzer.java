package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		int counter=0;
		int retryLimit = 1;
		if(counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
