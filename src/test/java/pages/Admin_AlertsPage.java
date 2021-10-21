package pages;

import locators.Admin_AlertsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.ConstantsUtil;
import utility.DriverPage;

public class Admin_AlertsPage extends DriverPage {

    static String loc;

    public Admin_AlertsPage(WebDriver driver){
        super(driver);
    }

    public void selectAdminMenu(){
        selectTopMenu("Administration");
    }

    public void clickOnCreateAlertButton() {
        clickOn(Admin_AlertsLocators.createAlertBtn);
        putWait(ConstantsUtil.minWait);
        log.log("Clicked on create alert button");
    }

    public void selectType(String type){
        clickOn(Admin_AlertsLocators.selectType);
        putWait(ConstantsUtil.minWait);
        getWebDriver().findElement(By.xpath("//li[text()='"+type+"']")).click();

    }

    public void enterAlertName(String name){
        loc = name+getRandomNumber();
        sendKeys(Admin_AlertsLocators.alertName, loc);
        log.log("Alert name entered.");
    }

    public void selectSeverity(String severity){
        clickOn(Admin_AlertsLocators.severity);
        putWait(ConstantsUtil.minWait);
        getWebDriver().findElement(By.xpath("//li[text()='"+severity+"']")).click();
    }

    public void sendEmailTo(String email){
        clickOn(Admin_AlertsLocators.emailCheckbox);
        sendKeys(Admin_AlertsLocators.sendEmailTo, email);
        log.log("Email entered.");
    }

    public void clickOnSaveButton(){
        clickOn(Admin_AlertsLocators.saveButton);
        log.log("Clicked on save button");
    }

    public void verifyAlertIsSaved(){
        isElementPresent("//*[text()='"+loc+"']");
        log.log("Alert is verified.");
    }

    public void enterFileFolder(String file){
        sendKeys(Admin_AlertsLocators.fileFolder, file);
        log.log("Enter file/folder");
    }

    public void enterRunScriptInAgent(String script){
        sendKeys(Admin_AlertsLocators.runScriptInAgent, script);
        log.log("Entered run script agent");
    }

    public void selectOperation(String ope){
        clickOn(Admin_AlertsLocators.operation);
        putWait(ConstantsUtil.minWait);
        getWebDriver().findElement(By.xpath("//li[text()='"+ope+"']")).click();
        log.log("Operation is selected asf "+ope);
    }

    public void editExistingAlert(){
        loc = Admin_AlertsLocators.editAlert.replaceAll("@override", loc);
        clickOn(loc);
        log.log("Clicked on edit button on alert");
        putWait(ConstantsUtil.oneMinWait);
        enterAlertName("Alert_updatedName");
        clickOnSaveButton();
        verifyAlertIsSaved();
    }

    public void deleteExistingAlert(){
        loc = Admin_AlertsLocators.deleteAlert.replaceAll("@override", loc);
        clickOn(loc);
        waitForElementPresent(Admin_AlertsLocators.deleteOKButton, 10);
        log.log("Clicked on delete button to delete alert");
        putWait(ConstantsUtil.minWait);
        clickOn(Admin_AlertsLocators.deleteOKButton);
        putWait(ConstantsUtil.minWait);
        Assert.assertFalse(isElementPresent(loc));
        log.log("Alert is deleted and not displaying anymore");
    }
}
