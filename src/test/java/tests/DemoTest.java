package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DemoPage;
import utility.DriverTestCase;

public class DemoTest extends DriverTestCase {

    DemoPage dp;
    @BeforeTest
    public void init() throws Exception {
        setup();
        dp = new DemoPage(getWebDriver());
    }

    @Test
    public void doTest(){
        dp.dragAndDropMethod();
    }

}
