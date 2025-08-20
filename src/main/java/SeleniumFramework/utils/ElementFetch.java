package SeleniumFramework.utils;


import SeleniumFramework.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {
    public WebElement getWebElement(String identifierType, String identifierValue){
        switch (identifierType){
            case "XPATH": return BaseClass.driver.findElement(By.xpath(identifierValue));
            case "CSS": return BaseClass.driver.findElement(By.cssSelector(identifierValue));
            case "ID": return BaseClass.driver.findElement(By.id(identifierValue));
            case "CLASSNAME": return BaseClass.driver.findElement(By.className(identifierValue));
            case "LINKTEXT": return BaseClass.driver.findElement(By.linkText(identifierValue));
            case "PARTIALLINKTEXT": return BaseClass.driver.findElement(By.partialLinkText(identifierValue));
            case "TAGNAME": return BaseClass.driver.findElement(By.tagName(identifierValue));
            case "NAME": return BaseClass.driver.findElement(By.name(identifierValue));
            default: return null;
        }
    }
    public List<WebElement> getWebElements(String identifierType, String identifierValue){
        switch (identifierType){
            case "XPATH": return BaseClass.driver.findElements(By.xpath(identifierValue));
            case "CSS": return BaseClass.driver.findElements(By.cssSelector(identifierValue));
            case "ID": return BaseClass.driver.findElements(By.id(identifierValue));
            case "CLASSNAME": return BaseClass.driver.findElements(By.className(identifierValue));
            case "LINKTEXT": return BaseClass.driver.findElements(By.linkText(identifierValue));
            case "PARTIALLINKTEXT": return BaseClass.driver.findElements(By.partialLinkText(identifierValue));
            case "TAGNAME": return BaseClass.driver.findElements(By.tagName(identifierValue));
            case "NAME": return BaseClass.driver.findElements(By.name(identifierValue));
            default: return null;
        }
    }
}
