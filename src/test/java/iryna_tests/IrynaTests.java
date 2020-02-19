package iryna_tests;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.RepairsModulePage;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class IrynaTests {

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(Config.getProperty("briteErpUrl"));
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(Config.getProperty("briteUserEmail"));
        loginPage.passwordInput.sendKeys(Config.getProperty("briteUserPassword"));
        loginPage.logInButton.click();
        LandingPage landingPage = new LandingPage();

    }

    @Test
    public void quotationsFilterTest(){
        List<WebElement> originalOrdersStatusList = Driver.getDriver().findElements(By.xpath("//div//table//tbody//tr//td[@class='o_data_cell o_readonly_modifier']"));
        RepairsModulePage repairsModulePage = new RepairsModulePage();
        repairsModulePage.advancedSearchButton.click();
        Assert.assertTrue(repairsModulePage.filtersButton.isDisplayed(), "Filters button is not displayed. FAIL");
        repairsModulePage.filtersButton.click();
        Assert.assertTrue(repairsModulePage.filtersDropdownMenu.isDisplayed(), "Filters dropdown menu is not displayed. FAIL");
        repairsModulePage.quotationsFilter.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(repairsModulePage.quotationsFilterSelectionCheckMark));
        Assert.assertTrue(repairsModulePage.quotationsFilterInSearchBox.isDisplayed(), "\"Quotations\" filter option is not displayed in Search box. FAIL");
        Assert.assertTrue(repairsModulePage.quotationsFilterSelectionCheckMark.getAttribute("class").equals("selected"), "\"Quotations\" filter option is not selected. FAIL");
        List<WebElement> filteredOrdersStatusList = Driver.getDriver().findElements(By.xpath("//div//table//tbody//tr//td[@class='o_data_cell o_readonly_modifier']"));
        for(WebElement element: filteredOrdersStatusList){
            Assert.assertTrue(repairsModulePage.quotationsFilter.getText().contains(element.getText()), "Filtered orders list contains options that do not correspond to this filter");
        }

        repairsModulePage.quotationsFilter.click();

        Assert.assertTrue(repairsModulePage.quotationsFilterSelectionCheckMark.getAttribute("class").isEmpty(), "\"Quotations\" filter option is selected");

        try{
            Assert.assertFalse(repairsModulePage.quotationsFilterInSearchBox.isDisplayed(),"\"Quotations\" filter option is displayed in Search box");
        }catch (NoSuchElementException e){
            System.out.println("Element no longer exists. Verification PASSED");
        }


        List<WebElement> finalOrdersStatusList = Driver.getDriver().findElements(By.xpath("//div//table//tbody//tr//td[@class='o_data_cell o_readonly_modifier']"));

        Assert.assertTrue(originalOrdersStatusList.toString().equals(finalOrdersStatusList.toString()));




    }

    @AfterClass
    public void tearDown(){

        Driver.getDriver().quit();
    }
}
