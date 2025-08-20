package SeleniumFramework.PageEvents;


import SeleniumFramework.PageElements.HomePageElements;
import SeleniumFramework.utils.ElementFetch;

public class HomePageEvents {
    ElementFetch elem = new ElementFetch();
    public void clickOnLoginPage(){
        elem.getWebElement("XPATH", HomePageElements.loginPagelink).click();
    }
    public void clickOndynamicPage(){
        elem.getWebElement("XPATH", HomePageElements.dynamicModifPage).click();
    }
}
