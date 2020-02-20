package eduardTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RepairPage {

    public RepairPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement createButton;

    @FindBy(xpath = "//input[@id='o_field_input_104']")
    public WebElement productRepairButton;

    @FindBy(xpath = "//ul[@id='ui-id-3']")
    public List<WebElement> productsToRepair;

    @FindBy(xpath = "//a[.='Search More...']")
    public WebElement searchMoreButton;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    WebElement createButton2;

    @FindBy(xpath = "//input[@placeholder='Product Name']")
    WebElement greyText;

    @FindBy(id = "o_field_input_496")
    WebElement inputProductName;

    @FindBy(id = "o_field_input_503")
    WebElement productTypeButton;

    @FindBy(id = "o_field_input_504")
    WebElement internalReferenceTextBox;

    @FindBy(id = "o_field_input_505")
    WebElement bareCodeBoxText;

    @FindBy(id = "o_field_input_506")
    List<WebElement> categoryList;

    @FindBy(xpath = "//input[@id='o_field_input_507']")
    public WebElement salePriceBox;

    @FindBy(id = "o_field_input_511")
    public WebElement costBox;
}
