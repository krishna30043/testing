package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Admin_ApplicationLogPage;
import utility.DriverTestCase;

public class ApplicationLogTest extends DriverTestCase {

    Admin_ApplicationLogPage admin_applicationLogPage;
    @BeforeTest
    public void initForAppLog() throws Exception {
        setup();
        admin_applicationLogPage = new Admin_ApplicationLogPage(getWebDriver());
        admin_applicationLogPage.selectAppLogMenu();
    }

    @Test(description = "10")
    public void verifyAppLog(){
        admin_applicationLogPage.verifyApplicationLog();
    }
}
