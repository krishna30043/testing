package locators;

public class Admin_Endpoint_SettingLocators {

    public final static String enableCheckbox = "//label[text()='Enabled']/../input";
    public static final String fileAudit = "//span[text()='File Audit']";
    public static final String fileExtension = "//span[text()='File Extensions']";
    public static final String addNewExtensionBtn = "//*[@title='Add New Extension']";
    public static final String enterExtension = "//*[@title='Add New Extension']/../../input";
    public static final String deleteExtension = "//div[text()='@override']/following-sibling::button/i[@title='Delete']";
}
