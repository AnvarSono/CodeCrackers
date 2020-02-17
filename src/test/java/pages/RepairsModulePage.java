package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RepairsModulePage {

    public RepairsModulePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@title='Advanced Search...']")
    public WebElement advancedSearchButton;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[3]")
    public WebElement filtersButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu o_filters_menu']")
    public WebElement filtersDropdownMenu;

    @FindBy(xpath = "//a[.='Quotations']")
    public WebElement quotationsFilter;

    @FindBy(xpath = "//span[contains(text(),'Quotations')]")
    public WebElement quotationsFilterInSearchBox;

    @FindBy(xpath = "(//li[@data-index='0'])[1]")
    public WebElement quotationsFilterSelectionCheckMark;

    @FindBy(linkText = "Repairs")
    public WebElement repairsModule;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement RepairOrderCreateButton;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[6]")
    public WebElement currentLocationBox;

    @FindBy(xpath = "//a[contains(text(),'Create and Edit...')]")
    public WebElement currentLocationCreateAndEdit;

 }
