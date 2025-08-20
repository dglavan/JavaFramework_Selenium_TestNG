package SeleniumFramework.utils;
import com.aventstack.extentreports.Status;

public class LoggerHelper {

        // Log an INFO message
        public static void info(String message) {
            ExtentReportListener.LoggerHelper().log(Status.INFO, message);
        }
}
