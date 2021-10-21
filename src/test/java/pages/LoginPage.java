package pages;

import locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.ConstantsUtil;
import utility.DriverPage;
import utility.PropertyReader;

public class LoginPage extends DriverPage {

    private String loc;
    PropertyReader prop = new PropertyReader();

    public LoginPage(WebDriver webdriver){
        super(webdriver);
    }

    public void enterUserName(String username){
        putWait(ConstantsUtil.minWait);
        sendKeys(LoginPageLocators.userName, username);
        log.log("Entered username as "+username);
    }

    public void enterPassword(String password){
        sendKeys(LoginPageLocators.password, password);
        log.log("Entered password as "+password);
    }

    public void clickOnLoginButton(){
        clickOn(LoginPageLocators.loginButton);
        log.log("Clicked on login button");
    }

    public void verifyLogin(){
        loc = LoginPageLocators.sideMenu.replaceAll("@override", prop.readProperty("username"));
        waitForElementPresent(loc, 10);
        Assert.assertTrue(isElementPresent(loc));
    }
}
