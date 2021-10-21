package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.DriverPage;

public class Admin_ApplicationLogPage extends DriverPage {

    String loc;

    public Admin_ApplicationLogPage(WebDriver driver){
        super(driver);
    }

    public void selectAppLogMenu(){
        selectTopMenu("Administration");
        selectSideMenu("Manage", "Application Log");
    }

    public void verifyApplicationLog(){
        loc = "(//*[text()='"+Admin_AlertsPage.loc+"'])[1]";
        Assert.assertTrue(isElementPresent(loc));
        log.log("Application log is verified.");
    }
}
