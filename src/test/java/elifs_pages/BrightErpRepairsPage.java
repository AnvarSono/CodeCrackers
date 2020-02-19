package elifs_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrightErpRepairsPage {
    public BrightErpRepairsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@data-menu=\"535\"]/span")
    public WebElement repairButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/button[1]")
    public WebElement createButton;
    //(//div[@class='o_field_widget o_field_many2one']//input[@class='o_input ui-autocomplete-input'])[1]

}

