package Utils.Common.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {
    public void onTestSuccess(ITestResult tr) {
        Listeners.log(System.currentTimeMillis()+"passed test "+tr.getMethod());
    }

    public void onTestFailure(ITestResult tr) {
        Listeners.log(System.currentTimeMillis()+"Failed test "+tr.getMethod());
    }

    public void onTestSkipped(ITestResult tr) {
        Listeners.log(tr.getTestName());
    }

    public void onTestFailedWithTimeout(ITestResult tr) {
        Listeners.log(tr.getTestName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
        Listeners.log(tr.getTestName());
    }
    public static void log(String message)
    {
        System.out.println(message);
    }
}
