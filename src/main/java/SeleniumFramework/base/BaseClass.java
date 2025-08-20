package SeleniumFramework.base;

// WebDriver related logic

import SeleniumFramework.utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;



    @BeforeMethod
    //Called before testMethod()- in this case the test is the testMethod (named by getMethod.getName())
    //✅ Your browser is opened, navigated to the URL.
    @Parameters("browser")
    public void beforeMethod(String browser) {
        setupDriver(browser);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }


    // Helper Method to Try driver setup and init depending on value of parameter 'browser' passed into the method
    public void setupDriver(String browser) {
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } catch (Exception e) {
            // Fallback to manual path if WebDriverManager fails
            System.out.println("WebDriverManager failed: " + e.getMessage());

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\ebollass\\Selenium\\MyFramework\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\ebollass\\Selenium\\MyFramework\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "C:\\ebollass\\Selenium\\MyFramework\\drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
            }
        }
    }
}
