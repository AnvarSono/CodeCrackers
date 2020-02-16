package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    } @FindBy(xpath = "//input[@id=\"login\"]")
    public WebElement eMailAdd;
    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement passWord;
    @FindBy (xpath = "//button[@type=\"submit\"]")
    public WebElement submitButton;

}
