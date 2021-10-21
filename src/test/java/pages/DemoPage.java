package pages;

import locators.DemoLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.DriverPage;
import utility.DriverTestCase;

public class DemoPage extends DriverPage {

    public DemoPage(WebDriver driver){
        super(driver);
    }

    public void dragAndDropMethod(){
        Actions ac = new Actions(getWebDriver());
        WebElement src = getWebDriver().findElement(By.xpath(DemoLocators.scr));
        WebElement tar = getWebDriver().findElement(By.id(DemoLocators.target));

        ac.clickAndHold(src).moveToElement(tar).release(tar).build().perform();


//        ac.dragAndDrop(src, tar).perform();
    }
}
