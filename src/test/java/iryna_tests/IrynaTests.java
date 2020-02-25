package iryna_tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LandingPage;
import pages.LoginPage;
import pages.RepairsModulePage;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class IrynaTests {


    @BeforeMethod
    public void setUp(){
        //get the BriteERP login page:
        Driver.getDriver().get(Config.getProperty("briteErpUrl"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void quotationsFilterTest() throws InterruptedException {
        RepairsModulePage repairsModulePage = new RepairsModulePage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = new LandingPage();

        //enter valid e-mail:
        loginPage.emailInput.sendKeys(Config.getProperty("briteUserEmail"));

        //enter valid password:
        loginPage.passwordInput.sendKeys(Config.getProperty("briteUserPassword"));

        //click the login button to login:
        loginPage.logInButton.click();

        //click repairs module box to go to repairs module:
        landingPage.repairsModule.click();

        //check if filter is already displayed or you need to click advanced search button in order to see it:
        if(repairsModulePage.advancedSearchButtonPlus.isDisplayed()){
            repairsModulePage.advancedSearchButtonPlus.click();
        }

        //creating a list in order to store all the existing orders' statuses:
        List<WebElement> originalOrdersStatusList = repairsModulePage.listOfOrders;

        //wait.until(ExpectedConditions.visibilityOf(repairsModulePage.filtersButton));

        Thread.sleep(3000);

        //verify if filters button is displayed:
        Assert.assertTrue(repairsModulePage.filtersButton.isDisplayed(), "Filters button is not displayed. FAIL");

        //click the filter button:
        repairsModulePage.filtersButton.click();

        //verify if filter dropdown menu is displayed:
        Assert.assertTrue(repairsModulePage.filtersDropdownMenu.isDisplayed(), "Filters dropdown menu is not displayed. FAIL");

        //click the desired filter:
        repairsModulePage.quotationsFilter.click();

        //verify if filter is displayed in a search box:
        Assert.assertTrue(repairsModulePage.quotationsFilterInSearchBox.isDisplayed(), "\"Quotations\" filter option is not displayed in Search box. FAIL");

        //verify if filter is selected in the list:
        Assert.assertTrue(repairsModulePage.quotationsFilterSelectionCheckMark.getAttribute("class").equals("selected"), "\"Quotations\" filter option is not selected. FAIL");

        //get the filtered list of repairs orders':
        List<WebElement> filteredOrdersStatusList = repairsModulePage.quotationsListOfOrders;

        //wait until the filter is selected:
        wait.until(ExpectedConditions.visibilityOf(repairsModulePage.quotationsFilter));
        Thread.sleep(5000);
        //verify if list contains only filtered orders:
        for(WebElement element: filteredOrdersStatusList){

            Assert.assertTrue(repairsModulePage.quotationsFilter.getText().contains(element.getText()), "Filtered orders list contains options that do not correspond to this filter");
        }

        //click the filter once again to deselect:
        repairsModulePage.quotationsFilter.click();

        //verify if filter is deselected:
        Assert.assertTrue(repairsModulePage.quotationsFilterSelectionCheckMark.getAttribute("class").isEmpty(), "\"Quotations\" filter option is selected");

        //verify that the filter is not displayed in search box anymore:
        try{
            Assert.assertFalse(repairsModulePage.quotationsFilterInSearchBox.isDisplayed(),"\"Quotations\" filter option is displayed in Search box");
        }catch (NoSuchElementException e){
            System.out.println("Element no longer exists. Verification PASSED");
        }

        //create a list to store the orders after the filter is deselected:
        List<WebElement> finalOrdersStatusList = repairsModulePage.listOfOrders;

        //verify that the list contains all of the orders as before the filter selection and deselection:
        Assert.assertTrue(originalOrdersStatusList.toString().equals(finalOrdersStatusList.toString()));
    }


    @Test
    public void confirmedFilterTest() throws InterruptedException {

        RepairsModulePage repairsModulePage = new RepairsModulePage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = new LandingPage();

        //enter valid e-mail:
        loginPage.emailInput.sendKeys(Config.getProperty("briteUserEmail"));

        //enter valid password:
        loginPage.passwordInput.sendKeys(Config.getProperty("briteUserPassword"));

        //click the login button to login:
        loginPage.logInButton.click();

        //click repairs module box to go to repairs module:
        landingPage.repairsModule.click();

        //check if filter is already displayed or you need to click advanced search button in order to see it:
        if(repairsModulePage.advancedSearchButtonPlus.isDisplayed()){
            repairsModulePage.advancedSearchButtonPlus.click();
        }

        //creating a list in order to store all the existing orders' statuses:
        List<WebElement> originalOrdersStatusList = repairsModulePage.listOfOrders;

        //wait.until(ExpectedConditions.visibilityOf(repairsModulePage.filtersButton));
        Thread.sleep(2000);
        //verify if filters button is displayed:
        Assert.assertTrue(repairsModulePage.filtersButton.isDisplayed(), "Filters button is not displayed. FAIL");

        //click the filter button:
        repairsModulePage.filtersButton.click();

        //verify if filter dropdown menu is displayed:
        Assert.assertTrue(repairsModulePage.filtersDropdownMenu.isDisplayed(), "Filters dropdown menu is not displayed. FAIL");

        //click the desired filter:
        repairsModulePage.confirmedFilter.click();
        Thread.sleep(1000);
        //verify if filter is displayed in a search box:
        Assert.assertTrue(repairsModulePage.confirmedFilterInSearchBox.isDisplayed(), "\"Confirmed\" filter option is not displayed in Search box. FAIL");

        //verify if filter is selected in the list:
        Assert.assertTrue(repairsModulePage.confirmedFilterSelectionCheckMark.getAttribute("class").equals("selected"), "\"Confirmed\" filter option is not selected. FAIL");

        //get the filtered list of repairs orders':
        List<WebElement> filteredOrdersStatusList = repairsModulePage.confirmedListOfOrders;

        //wait until the filter is selected:
        wait.until(ExpectedConditions.visibilityOf(repairsModulePage.confirmedFilter));


        Thread.sleep(5000);
        //verify if list contains only filtered orders:
        for(WebElement element: filteredOrdersStatusList){
            System.out.println("Order status: " + element.getText());
            Assert.assertTrue(repairsModulePage.confirmedFilter.getText().contains(element.getText()), "Filtered orders list contains options that do not correspond to this filter");
        }

        //click the filter once again to deselect:
        repairsModulePage.confirmedFilter.click();

        //verify if filter is deselected:
        Assert.assertTrue(repairsModulePage.confirmedFilterSelectionCheckMark.getAttribute("class").isEmpty(), "\"Confirmed\" filter option is selected");

        //verify that the filter is not displayed in search box anymore:
        try{
            Assert.assertFalse(repairsModulePage.confirmedFilterInSearchBox.isDisplayed(),"\"Confirmed\" filter option is displayed in Search box");
        }catch (NoSuchElementException e){
            System.out.println("Element no longer exists. Verification PASSED");
        }

        //create a list to store the orders after the filter is deselected:
        List<WebElement> finalOrdersStatusList = repairsModulePage.listOfOrders;

        //verify that the list contains all of the orders as before the filter selection and deselection:
        Assert.assertTrue(originalOrdersStatusList.toString().equals(finalOrdersStatusList.toString()));
    }

    @Test
    public void readyToRepairFilterTest() throws InterruptedException {

        RepairsModulePage repairsModulePage = new RepairsModulePage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = new LandingPage();

        //enter valid e-mail:
        loginPage.emailInput.sendKeys(Config.getProperty("briteUserEmail"));

        //enter valid password:
        loginPage.passwordInput.sendKeys(Config.getProperty("briteUserPassword"));

        //click the login button to login:
        loginPage.logInButton.click();

        //click repairs module box to go to repairs module:
        landingPage.repairsModule.click();

        //check if filter is already displayed or you need to click advanced search button in order to see it:
        if(repairsModulePage.advancedSearchButtonPlus.isDisplayed()){
            repairsModulePage.advancedSearchButtonPlus.click();
        }

        //creating a list in order to store all the existing orders' statuses:
        List<WebElement> originalOrdersStatusList = repairsModulePage.listOfOrders;

      //  wait.until(ExpectedConditions.visibilityOf(repairsModulePage.filtersButton));
        Thread.sleep(3000);
        //verify if filters button is displayed:
        Assert.assertTrue(repairsModulePage.filtersButton.isDisplayed(), "Filters button is not displayed. FAIL");

        //click the filter button:
        repairsModulePage.filtersButton.click();

        //verify if filter dropdown menu is displayed:
        Assert.assertTrue(repairsModulePage.filtersDropdownMenu.isDisplayed(), "Filters dropdown menu is not displayed. FAIL");

        //click the desired filter:
        repairsModulePage.readyToRepairFilter.click();

        //verify if filter is displayed in a search box:
        Assert.assertTrue(repairsModulePage.readyToRepairFilterInSearchBox.isDisplayed(), "\"Ready To Repair\" filter option is not displayed in Search box. FAIL");

        //verify if filter is selected in the list:
        Assert.assertTrue(repairsModulePage.readyToRepairFilterSelectionCheckMark.getAttribute("class").equals("selected"), "\"Ready To Repair\" filter option is not selected. FAIL");

        //get the filtered list of repairs orders':
        List<WebElement> filteredOrdersStatusList = repairsModulePage.readyToRepairListOfOrders;

        //wait until the filter is selected:
        wait.until(ExpectedConditions.visibilityOf(repairsModulePage.readyToRepairFilter));

        //verify if list contains only filtered orders:
        for(WebElement element: filteredOrdersStatusList){
              Assert.assertTrue(repairsModulePage.readyToRepairFilter.getText().equalsIgnoreCase(element.getText()), "Filtered orders list contains options that do not correspond to this filter");
        }

        //click the filter once again to deselect:
        repairsModulePage.readyToRepairFilter.click();

        //verify if filter is deselected:
        Assert.assertTrue(repairsModulePage.readyToRepairFilterSelectionCheckMark.getAttribute("class").isEmpty(), "\"Ready To Repair\" filter option is selected");

        //verify that the filter is not displayed in search box anymore:
        try{
            Assert.assertFalse(repairsModulePage.readyToRepairFilterInSearchBox.isDisplayed(),"\"Ready To Repair\" filter option is displayed in Search box");
        }catch (NoSuchElementException e){
            System.out.println("Element no longer exists. Verification PASSED");
        }

        //create a list to store the orders after the filter is deselected:
        List<WebElement> finalOrdersStatusList = repairsModulePage.listOfOrders;

        //verify that the list contains all of the orders as before the filter selection and deselection:
        Assert.assertTrue(originalOrdersStatusList.toString().equals(finalOrdersStatusList.toString()));
    }

    @Test
    public void invoicedFilterTest() throws InterruptedException {

        RepairsModulePage repairsModulePage = new RepairsModulePage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = new LandingPage();

        //enter valid e-mail:
        loginPage.emailInput.sendKeys(Config.getProperty("briteUserEmail"));

        //enter valid password:
        loginPage.passwordInput.sendKeys(Config.getProperty("briteUserPassword"));

        //click the login button to login:
        loginPage.logInButton.click();

        //click repairs module box to go to repairs module:
        landingPage.repairsModule.click();

        //check if filter is already displayed or you need to click advanced search button in order to see it:
        if(repairsModulePage.advancedSearchButtonPlus.isDisplayed()){
            repairsModulePage.advancedSearchButtonPlus.click();
        }

        //creating a list in order to store all the existing orders' statuses:
        List<WebElement> originalOrdersStatusList = repairsModulePage.listOfOrders;

       // wait.until(ExpectedConditions.visibilityOf(repairsModulePage.filtersButton));
        Thread.sleep(2000);
        //verify if filters button is displayed:
        Assert.assertTrue(repairsModulePage.filtersButton.isDisplayed(), "Filters button is not displayed. FAIL");

        //click the filter button:
        repairsModulePage.filtersButton.click();

        //verify if filter dropdown menu is displayed:
        Assert.assertTrue(repairsModulePage.filtersDropdownMenu.isDisplayed(), "Filters dropdown menu is not displayed. FAIL");

        //click the desired filter:
        repairsModulePage.invoicedFilter.click();

        wait.until(ExpectedConditions.visibilityOf(repairsModulePage.invoicedFilterInSearchBox));

        //verify if filter is displayed in a search box:
        Assert.assertTrue(repairsModulePage.invoicedFilterInSearchBox.isDisplayed(), "\"Invoiced\" filter option is not displayed in Search box. FAIL");

        //verify if filter is selected in the list:
        Assert.assertTrue(repairsModulePage.invoicedFilterSelectionCheckMark.getAttribute("class").equals("selected"), "\"Invoiced\" filter option is not selected. FAIL");

        //click the filter once again to deselect:
        repairsModulePage.invoicedFilter.click();

        //verify if filter is deselected:
        Assert.assertTrue(repairsModulePage.invoicedFilterSelectionCheckMark.getAttribute("class").isEmpty(), "\"Invoiced\" filter option is selected");

        //verify that the filter is not displayed in search box anymore:
        try{
            Assert.assertFalse(repairsModulePage.invoicedFilterInSearchBox.isDisplayed(),"\"Invoiced\" filter option is displayed in Search box");
        }catch (NoSuchElementException e){
            System.out.println("Element no longer exists. Verification PASSED");
        }

        //create a list to store the orders after the filter is deselected:
        List<WebElement> finalOrdersStatusList = repairsModulePage.listOfOrders;

        //verify that the list contains all of the orders as before the filter selection and deselection:
        Assert.assertTrue(originalOrdersStatusList.toString().equals(finalOrdersStatusList.toString()));
    }

}









