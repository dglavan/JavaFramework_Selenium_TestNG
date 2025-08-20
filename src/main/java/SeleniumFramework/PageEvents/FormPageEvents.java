package SeleniumFramework.PageEvents;

import SeleniumFramework.PageElements.FormPageElements;
import SeleniumFramework.base.BaseClass;
import SeleniumFramework.utils.Constants;
import SeleniumFramework.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPageEvents {
    ElementFetch elem = new ElementFetch();

    public void modifyInputText(String field, String s){
        var field1 = elem.getWebElement("XPATH", FormPageElements.textField1);
        var field2 = elem.getWebElement("XPATH", FormPageElements.textField2);

        Actions actions = new Actions(BaseClass.driver);
        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        if(field.equalsIgnoreCase(FormPageElements.textField1)){
            actions.click(field1)
                    .keyDown(cmdCtrl)
                    .sendKeys("a")
                    .sendKeys(Keys.DELETE)
                    .keyUp(cmdCtrl)
                    .sendKeys(s)
                    .perform();
        }
        else {
            actions.click(field2)
                    .sendKeys(s)
                    .perform();
        }
    }

    public String checkInputText(String field){
        var field1 = elem.getWebElement("XPATH", FormPageElements.textField1);
        var field2 = elem.getWebElement("XPATH", FormPageElements.textField2);

        if(field.equalsIgnoreCase(FormPageElements.textField1)){
            return field1.getAttribute("value");
        } else if (field.equalsIgnoreCase(FormPageElements.textField2)) {
            return field2.getAttribute("value");
        } else return null;
    }

    // helper Method if Wait needed for changes
    public void waitForTextChange(String field) {
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));
        By locator;

        if(field.equalsIgnoreCase(FormPageElements.textField1)) {
            locator = By.xpath(FormPageElements.textField1);
        } else if (field.equalsIgnoreCase(FormPageElements.textField2)) {
            locator = By.xpath(FormPageElements.textField2);
        } else {
            System.out.println("Enter a valid field");
            return;
        }

        wait.until(driver -> driver.findElement(locator)
                .getAttribute("value")
                .equals(Constants.newInputText));
    }
}
