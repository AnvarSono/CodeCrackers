package elifs_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;


public class BrightErpCreatePages {
    public BrightErpCreatePages() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"o_field_input_69\"]")
    public WebElement customerField;
    @FindBy(xpath = "//*[@id=\"modal_135\"]/div/div/div[2]/input")
    public WebElement customName;
    @FindBy(xpath = "//div[@class=\"modal-body\"]/input")
    public WebElement createAndCustomerField;
    @FindBy(xpath = "(//ul[@class=\"ui-autocomplete ui-front ui-menu ui-widget ui-widget-content\"])[4]")
    public List<WebElement> customerList;

    @FindBy(xpath = "(//div[@class=\"o_input_dropdown\"]/input)[4]")
    public WebElement dropDown;

    @FindBy(linkText = "Search More...")
    public WebElement searchMore;

    @FindBy(xpath = "//h4[@class=\"modal-title\"]")
    public WebElement searchCustomerHeader;

    @FindBy(xpath = "(//input[@class=\"o_searchview_input\"])[1]")
    public WebElement searchField;

    @FindBy(linkText = "Create and Edit...")
    public WebElement createAndEdit;

    @FindBy(xpath = "//*[@id=\"o_field_input_116\"]")
    public WebElement nameBox;
    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-sm o-kanban-button-new\"]")
    public WebElement createButton2;
    @FindBy(xpath = "(//input[@class=\"o_field_char o_field_widget o_input o_required_modifier\"])[3]")
    public WebElement contactName;
    @FindBy(xpath = "//div[@class=\"modal-footer\"]/button[1]")
    public WebElement saveBttn;
    @FindBy(xpath = "//input[@id=\"o_field_input_99\"]")
    public WebElement deliveryBttn;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/table[1]/tbody/tr[5]/td[2]/div/button")
    public WebElement customLink;
    @FindBy(xpath = "(//div[@class=\"modal-footer\"]/button/span)[3]")
    public WebElement saveAndClose;
    @FindBy(xpath = "//div[@class=\"modal-header\"]/h4")
    public WebElement openCustomer;


}


