package pages;

import locators.Admin_AlertsLocators;
import locators.Admin_Endpoint_SettingLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.ConstantsUtil;
import utility.DriverPage;

public class Admin_Endpoint_SettingPage extends DriverPage {

    public Admin_Endpoint_SettingPage(WebDriver driver){
        super(driver);
    }

    public void selectMenuHere(){
        selectTopMenu("Administration");
        log.log("Administration menu is selected.");
        selectSideMenu("Endpoints", "Settings");
        log.log("Endpoints-> Settings menu is selected.");
        putWait(ConstantsUtil.minWait);
        clickOn(Admin_Endpoint_SettingLocators.fileExtension);
        log.log("File extension tab is selected.");
    }


    public void verifyEnableCheckbox(boolean status){
        clickOn(Admin_Endpoint_SettingLocators.fileExtension);
        String loc = "//label[text()='Enabled']/ancestor::form[1]/div[2]";
        if(status){
            boolean flag = getWebDriver().findElement(By.xpath(Admin_Endpoint_SettingLocators.enableCheckbox)).isSelected();

            if(flag){
                Assert.assertTrue(getWebDriver().findElement(By.xpath(loc)).getAttribute("class").equals("form-group "));
                log.log("Form is disabled.");
            }
            else {
                getWebDriver().findElement(By.xpath(Admin_Endpoint_SettingLocators.enableCheckbox)).click();
                Assert.assertFalse(getWebDriver().findElement(By.xpath(loc)).getAttribute("class").equals("form-group "));
                log.log("Form is enabled.");
            }
        }
        else {
            boolean flag = getWebDriver().findElement(By.xpath(Admin_Endpoint_SettingLocators.enableCheckbox)).isSelected();
            if(!flag){
                Assert.assertTrue(getWebDriver().findElement(By.xpath(loc)).getAttribute("class").equals("form-group disabledDiv"));
                log.log("Form is disabled.");
            }
            else {
                getWebDriver().findElement(By.xpath(Admin_Endpoint_SettingLocators.enableCheckbox)).click();
                Assert.assertFalse(getWebDriver().findElement(By.xpath(loc)).getAttribute("class").equals("form-group disabledDiv"));
                log.log("Form is enabled.");
            }
            getWebDriver().findElement(By.xpath(Admin_Endpoint_SettingLocators.enableCheckbox)).click();
        }
    }

    public void addNewExtension(String ext){
        sendKeys(Admin_Endpoint_SettingLocators.enterExtension, ext);
        log.log("Enter new extension as "+ext);
        clickOn(Admin_Endpoint_SettingLocators.addNewExtensionBtn);
        log.log("clicked on add button to add new extension.");
        putWait(ConstantsUtil.oneMinWait);

        String loc = Admin_Endpoint_SettingLocators.deleteExtension.replaceAll("@override", ext);
        Assert.assertTrue(isElementPresent(loc));
        log.log("New extension is added");

        clickOn(loc);
        putWait(ConstantsUtil.oneMinWait);
        Assert.assertFalse(isElementPresent(loc));
        log.log("Extension is deleted.");
    }

    public void deleteExtension(String ext){
        sendKeys(Admin_Endpoint_SettingLocators.enterExtension, ext);
        log.log("Enter new extension as "+ext);
        clickOn(Admin_Endpoint_SettingLocators.addNewExtensionBtn);
        log.log("clicked on add button to add new extension.");
        putWait(ConstantsUtil.oneMinWait);

        String loc = Admin_Endpoint_SettingLocators.deleteExtension.replaceAll("@override", ext);
        Assert.assertTrue(isElementPresent(loc));
        log.log("New extension is added");

        clickOn(loc);
        putWait(ConstantsUtil.oneMinWait);
        Assert.assertFalse(isElementPresent(loc));
        log.log("Extension is deleted.");
    }
}
