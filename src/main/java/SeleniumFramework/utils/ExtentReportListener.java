package SeleniumFramework.utils;

import SeleniumFramework.base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ExtentReportListener implements ITestListener, ISuiteListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();

    @Override
    public void onStart(ISuite suite){
        String reportPath = System.getProperty("user.dir")+ File.separator+"reports"+File.separator+"Test_Report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Test Run Report");

        extent.setSystemInfo("Host Name", "ebollass-PC");
        extent.setSystemInfo("User Name", "ebollass");

        System.out.println("[INFO] Extent Report initialized.");
    }

    @Override
    public void onFinish(ISuite suite){
        if(extent!=null){
            extent.flush();
            System.out.println("[INFO] Extent Report flushed.");
        }
    }

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testLogger.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ExtentTest test = testLogger.get(); // get the correct logger for this test method, on this thread.
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ " PASSED", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result){
        ExtentTest test = testLogger.get(); // get the correct logger for this test method, on this thread.
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " FAILED", ExtentColor.RED));
        test.fail(result.getThrowable());

        // Screenshot
        File screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getName() + ".png";
        try {
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){
        ExtentTest test = testLogger.get(); // get the correct logger for this test method, on this thread.
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.ORANGE));
    }

    public static ExtentTest LoggerHelper() {
        return testLogger.get(); // get the correct logger for this test method, on this thread.
    }
}
