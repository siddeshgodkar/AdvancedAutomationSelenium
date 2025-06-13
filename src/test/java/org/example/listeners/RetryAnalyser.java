package org.example.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3; //Set the max retry count

    public boolean retry(ITestResult iTestResult){
        if (retryCount < maxRetryCount){
            retryCount ++;
            return true;
        }
        return false;
    }




}
