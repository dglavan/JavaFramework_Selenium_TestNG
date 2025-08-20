package SeleniumFramework.PageEvents;


import SeleniumFramework.PageElements.LoginPageElements;
import SeleniumFramework.base.BaseClass;
import SeleniumFramework.utils.Constants;
import SeleniumFramework.utils.ElementFetch;
import org.openqa.selenium.Alert;


public class LoginPageEvents {
    ElementFetch elem = new ElementFetch();
    public void enterCredentials(){
        elem.getWebElement("XPATH", LoginPageElements.userNameField).sendKeys(Constants.username);
        elem.getWebElement("XPATH", LoginPageElements.passwordField).sendKeys(Constants.password);
        elem.getWebElement("XPATH", LoginPageElements.loginButton).click();
    }

    public boolean validateLogin(){
        Alert alert = BaseClass.driver.switchTo().alert();
        String alertText = alert.getText();
        if(alertText.equalsIgnoreCase("You have successfully logged in.")){
            return true;
        }
        return false;
    }
}
