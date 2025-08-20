package SeleniumFramework.PageEvents;

import SeleniumFramework.PageElements.DroppablePageElements;
import SeleniumFramework.base.BaseClass;
import SeleniumFramework.utils.ElementFetch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppablePageEvents {
    ElementFetch elem = new ElementFetch();

    public String readTarget(){
        return elem.getWebElement("XPATH", DroppablePageElements.dropTarget).getText();
    }

    public void dragAndDrop(){
        WebElement dragElem = elem.getWebElement("XPATH", DroppablePageElements.droppable);
        WebElement dropTarget = elem.getWebElement("XPATH", DroppablePageElements.dropTarget);
        new Actions(BaseClass.driver).dragAndDrop(dragElem,dropTarget).perform();
    }
    public boolean validateTarget(String s){
        if(s.equalsIgnoreCase("Drop here")){
            return true;
        }
        return false;
    }
    public boolean validateDrop(String s){
        if(s.equalsIgnoreCase("Dropped!")){
            return true;
        }
        return false;
    }
}
