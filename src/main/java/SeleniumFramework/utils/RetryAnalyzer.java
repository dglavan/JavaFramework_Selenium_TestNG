package SeleniumFramework.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 0; // How many times the test has been retried
    int retryCount = 1; // Max number of retries allowed
    public boolean retry(ITestResult iTestResult){
        while (count<retryCount){
            count++;      // increment counted retries
            return true; // tells testNG to retry test
        }
        return false; // no more retries allowed -> test marked as failed
    }
}
