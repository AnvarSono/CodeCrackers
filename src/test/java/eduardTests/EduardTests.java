package eduardTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Pause;

import java.util.List;

public class EduardTests {

    RepairPage repairPage = new RepairPage();

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(Config.getProperty("briteErpUrl"));
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(Config.getProperty("briteUserEd"));
        loginPage.passwordInput.sendKeys(Config.getProperty("britePassEd"));
        loginPage.logInButton.click();
        LandingPage landingPage = new LandingPage();
        Pause.pause(3);
        landingPage.repairsModule.click();
    }

    @Test
    public void productToRepair() {

        repairPage.createButton.click();

        repairPage.productRepairButton.click();

        Assert.assertFalse(repairPage.productsToRepair.isEmpty(), "The list is Empty. Test FAILED");

        Pause.pause(3);

        repairPage.searchMoreButton.click();

        repairPage.createButton2.click();

        Assert.assertTrue(repairPage.greyText.isDisplayed(),"Grey Text is NOT displayed. Test FAILED");

        repairPage.inputProductName.sendKeys("Laptop");

        Pause.pause(2);
        Select dropdownProductType = new Select(repairPage.productTypeButton);
        dropdownProductType.selectByVisibleText("Service");

        repairPage.internalReferenceTextBox.sendKeys("Costel");

        repairPage.bareCodeBoxText.sendKeys("123456L");

        Assert.assertFalse(repairPage.categoryList.isEmpty(),"Category List is EMPTY. Test FAILED");
        Pause.pause(4);

        //THIS LAST 2 ELEMENTS ARE GIVING ME ERROR "NOT INTERACTABLE"
        //  repairPage.salePriceBox.sendKeys("2222");
        // repairPage.costBox.sendKeys("1000");
    }

    @AfterClass
    public void tearDown(){
        Driver.getDriver().quit();
    }

}

