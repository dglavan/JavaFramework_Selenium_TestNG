package FirstSuite;


import SeleniumFramework.PageEvents.HomePageEvents;
import SeleniumFramework.PageEvents.LoginPageEvents;
import SeleniumFramework.base.BaseClass;
import SeleniumFramework.utils.LoggerHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import static SeleniumFramework.utils.ExtentReportListener.LoggerHelper;

public class loginTest extends BaseClass {
    HomePageEvents homePage = new HomePageEvents();
    LoginPageEvents loginPage = new LoginPageEvents();

    @Test
    public void loginValidation(){
        LoggerHelper.info("Clicking on LoginPage...");
        homePage.clickOnLoginPage();
        LoggerHelper.info("Entering credentials...");
        loginPage.enterCredentials();
        boolean loginSuccess = loginPage.validateLogin();
        LoggerHelper.info("Checking Login Status...");
        Assert.assertTrue(loginSuccess, "Login alert was not displayed");
    }
}
