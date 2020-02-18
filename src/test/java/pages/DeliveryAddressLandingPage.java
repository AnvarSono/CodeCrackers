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
}
