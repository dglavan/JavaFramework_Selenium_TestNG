package FirstSuite;

import SeleniumFramework.PageElements.FormPageElements;
import SeleniumFramework.PageEvents.FormPageEvents;
import SeleniumFramework.PageEvents.HomePageEvents;
import SeleniumFramework.base.BaseClass;
import SeleniumFramework.utils.Constants;
import SeleniumFramework.utils.LoggerHelper;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class textFieldTest extends BaseClass {
    HomePageEvents homePage = new HomePageEvents();
    FormPageEvents formPage = new FormPageEvents();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void textFieldModif(){
        LoggerHelper.info("Clicking on Form Page...");
        homePage.clickOnFormPage();

        LoggerHelper.info("Modifying text in field 1...");
        formPage.modifyInputText(FormPageElements.textField1, Constants.newInputText);

//        LoggerHelper.info("Waiting for changes to take effect");
//        formPage.waitForTextChange(FormPageElements.textField1);

        LoggerHelper.info("Checking text in field1...");
        softAssert.assertEquals(
                formPage.checkInputText(FormPageElements.textField1),
                Constants.newInputText,
                "Expected text was not found in field1!"
                );

        LoggerHelper.info("Modifying text in field 2...");
        formPage.modifyInputText(FormPageElements.textField2, Constants.newInputText);

//        LoggerHelper.info("Waiting for changes to take effect");
//        formPage.waitForTextChange(FormPageElements.textField2);

        LoggerHelper.info("Checking text in field2...");
        softAssert.assertEquals(
                formPage.checkInputText(FormPageElements.textField2),
                Constants.newInputText,
                "Expected text was not found in field2!"
                );

        LoggerHelper.info("Checking above assertions for test result...");
        softAssert.assertAll();
    }
}
