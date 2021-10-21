package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Admin_Endpoint_SettingPage;
import utility.DriverTestCase;

public class Admin_Endpoint_SettingTest extends DriverTestCase {

    Admin_Endpoint_SettingPage admin_endpoint_settingPage;

    @BeforeTest
    public void init() throws Exception {
        setup();
        admin_endpoint_settingPage = new Admin_Endpoint_SettingPage(getWebDriver());
    }

    @Test(priority = 1, description = "")
    public void openMenu(){
        admin_endpoint_settingPage.selectMenuHere();
    }

    @Test(priority = 2, description = "11")
    public void verifyCheckboxFunctionalityForEnabled(){
        admin_endpoint_settingPage.verifyEnableCheckbox(true);
    }

    @Test(priority = 3, description = "11")
    public void verifyCheckboxFunctionalityForDisabled(){
        admin_endpoint_settingPage.verifyEnableCheckbox(false);
    }

    @Test(priority = 4, description = "12")
    public void addAndDeleteNewExtension(){
        admin_endpoint_settingPage.addNewExtension(".tsting");
    }

    @Test(priority = 5, description = "13")
    public void deleteExtension(){
        admin_endpoint_settingPage.deleteExtension(".tsting");
    }


}
