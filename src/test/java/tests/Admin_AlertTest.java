package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Admin_AlertsPage;
import utility.DriverTestCase;

public class Admin_AlertTest extends DriverTestCase {

    Admin_AlertsPage admin_alertsPage;

    @BeforeTest
    public void initForAlerts() throws Exception {
        setup();
        admin_alertsPage = new Admin_AlertsPage(getWebDriver());
        admin_alertsPage.selectAdminMenu();
    }

    @Test(description = "6")
    public void createAlertWithSeverityInfo(){
        admin_alertsPage.clickOnCreateAlertButton();
        admin_alertsPage.enterAlertName("Alert Name");
        admin_alertsPage.selectType("Activity Less Than X Hours");
        admin_alertsPage.selectSeverity("Info");
        admin_alertsPage.sendEmailTo("mohit.testing1@gmail.com");
        admin_alertsPage.clickOnSaveButton();
        admin_alertsPage.verifyAlertIsSaved();
    }

    @Test(description = "7")
    public void createAlertWithSeverityCritical(){
        admin_alertsPage.clickOnCreateAlertButton();
        admin_alertsPage.enterAlertName("Alert Name");
        admin_alertsPage.selectType("Activity Less Than X Hours");
        admin_alertsPage.selectSeverity("Critical");
        admin_alertsPage.sendEmailTo("mohit.testing1@gmail.com");
        admin_alertsPage.clickOnSaveButton();
        admin_alertsPage.verifyAlertIsSaved();
    }

    @Test(description = "8")
    public void createAlertWithFileOperationDeleted(){
        admin_alertsPage.clickOnCreateAlertButton();
        admin_alertsPage.enterAlertName("Testing");
        admin_alertsPage.selectType("File operation on agents");
        admin_alertsPage.selectSeverity("Info");
        admin_alertsPage.sendEmailTo("mohit.testing1@gmail.com");
        admin_alertsPage.enterFileFolder("file");
        admin_alertsPage.enterRunScriptInAgent("agent");
        admin_alertsPage.clickOnSaveButton();
        admin_alertsPage.verifyAlertIsSaved();
    }

    @Test(description = "9")
    public void createAlertWithFileOperationModified(){
        admin_alertsPage.clickOnCreateAlertButton();
        admin_alertsPage.enterAlertName("Testing");
        admin_alertsPage.selectType("File operation on agents");
        admin_alertsPage.selectSeverity("Info");
        admin_alertsPage.sendEmailTo("mohit.testing1@gmail.com");
        admin_alertsPage.enterFileFolder("file");
        admin_alertsPage.selectOperation("Modified");
        admin_alertsPage.enterRunScriptInAgent("agent");
        admin_alertsPage.clickOnSaveButton();
        admin_alertsPage.verifyAlertIsSaved();
    }

    @Test(description = "22")
    public void editExistingAlerts(){
        admin_alertsPage.editExistingAlert();
    }

    @Test(description = "21")
    public void deleteExistingAlert(){
        admin_alertsPage.deleteExistingAlert();
    }
}
