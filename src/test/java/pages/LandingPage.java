package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LandingPage {

    public LandingPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //use this WebElement to go to repairs module page
    @FindBy(xpath = "//a[@href = '/web#menu_id=535&action=723']")
    public WebElement repairsModule;
}
