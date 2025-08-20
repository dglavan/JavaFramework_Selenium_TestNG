package FirstSuite;

import SeleniumFramework.PageEvents.DroppablePageEvents;
import SeleniumFramework.PageEvents.HomePageEvents;
import SeleniumFramework.base.BaseClass;
import SeleniumFramework.utils.LoggerHelper;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class dropTest extends BaseClass {
    HomePageEvents homePage = new HomePageEvents();
    DroppablePageEvents dropPage = new DroppablePageEvents();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void dragAndDrop(){
        LoggerHelper.info("Clicking on LoginPage...");
        homePage.clickOnDropPage();

        LoggerHelper.info("Reading initial value...");
        dropPage.readTarget();

        LoggerHelper.info("Validating Target availability.");
        softAssert.assertTrue(dropPage.validateTarget(dropPage.readTarget()), "Drop Target Not Ready");

        LoggerHelper.info("Dragging to Drop Target...");
        dropPage.dragAndDrop();

        LoggerHelper.info("Final check of Target after Drop...");
        softAssert.assertTrue(dropPage.validateDrop(dropPage.readTarget()), "Drop was not successful!");

        LoggerHelper.info("Asserting all soft asserts now...");
        softAssert.assertAll();

    }
}
