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
    public WebElement createButton2;

    @FindBy(xpath = "//input[@placeholder='Product Name']")
    public WebElement greyText;

    @FindBy(id = "o_field_input_496")
    public WebElement inputProductName;

    @FindBy(id = "o_field_input_503")
   public WebElement productTypeButton;

    @FindBy(id = "o_field_input_504")
    public WebElement internalReferenceTextBox;

    @FindBy(id = "o_field_input_505")
   public WebElement bareCodeBoxText;

    @FindBy(id = "o_field_input_506")
     public List<WebElement> categoryList;

    @FindBy(xpath = "//input[@id='o_field_input_507']")
    public WebElement salePriceBox;

    @FindBy(id = "o_field_input_511")
    public WebElement costBox;
}
