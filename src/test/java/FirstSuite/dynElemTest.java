package FirstSuite;


import SeleniumFramework.PageEvents.DynamicModifPageEvents;
import SeleniumFramework.PageEvents.HomePageEvents;
import SeleniumFramework.base.BaseClass;
import SeleniumFramework.utils.LoggerHelper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import static SeleniumFramework.utils.ExtentReportListener.LoggerHelper;

public class dynElemTest extends BaseClass {
    HomePageEvents homePage = new HomePageEvents();
    DynamicModifPageEvents dynamicPage = new DynamicModifPageEvents();
    WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));

    @Test
    public void dynamicElemCheck(){
        LoggerHelper.info("Accessing Dynamic Modified Page...");
        homePage.clickOndynamicPage();

        LoggerHelper.info("Reading element text before clicking...");
        String oldText = dynamicPage.readElemText();

        LoggerHelper.info("Pressing action button");
        dynamicPage.pressActionButton();

        LoggerHelper.info("Waiting up to 1 second to check element...");
        dynamicPage.waitForTextChange(oldText);

        LoggerHelper.info("Inspecting element");
        boolean elemText = dynamicPage.validatePressed(dynamicPage.readElemText());
        Assert.assertTrue(elemText, "Element was not modified at time of reading...");
    }

}
