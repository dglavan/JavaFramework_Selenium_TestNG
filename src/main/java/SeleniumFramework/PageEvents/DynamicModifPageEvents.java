package SeleniumFramework.PageEvents;


import SeleniumFramework.PageElements.DynamicModifPageElements;
import SeleniumFramework.base.BaseClass;
import SeleniumFramework.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class DynamicModifPageEvents {
    ElementFetch elem = new ElementFetch();

    // pressing button to modify element dynamicly
    public void pressActionButton(){
        elem.getWebElement("ID", DynamicModifPageElements.actionButton).click();
    }
    // read text of element on page
    public String readElemText(){
       return elem.getWebElement("ID", DynamicModifPageElements.elementModif).getText();
    }
    // Check if button Status -> was pressed or not
    public boolean validatePressed(String s){
        if(s.equals("new element")){
            return true;
        }
        return false;
    }
//    public boolean validatePressed(String s){
//        return s != null && s.equals("new element");
//    }
//    public void waitDelay(){
//        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.textToBe(By.id(DynamicModifPageElements.elementModif),"new element"));
//    }
    public void waitForTextChange(String oldText) {
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("element-to-remove"), "new element"));
    }
}
