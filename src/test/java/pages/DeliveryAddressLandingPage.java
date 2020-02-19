package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeliveryAddressLandingPage {
    public DeliveryAddressLandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/button[1]")
    public WebElement createButton;
    @FindBy(xpath = "//*[@id=\"o_field_input_109\"]")
    public WebElement deliveryAddress;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/table[1]/tbody/tr[6]/td[2]/div/div/span")
    public WebElement dropDownButton;
    @FindBy(xpath = "//*[@id=\"ui-id-65\"]/a")
    public  WebElement searchMore;
    @FindBy(xpath = "//*[@id=\"ui-id-53\"]/a")
    public WebElement createAndEdit;
}
