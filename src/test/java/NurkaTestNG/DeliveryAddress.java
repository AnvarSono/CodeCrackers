package NurkaTestNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DeliveryAddressLandingPage;
import pages.LandingPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

public class DeliveryAddress {

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(Config.getProperty("briteErpUrl"));
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(Config.getProperty("briteUserEmail"));
        loginPage.passwordInput.sendKeys(Config.getProperty("briteUserPassword"));
        loginPage.logInButton.click();
        LandingPage landingPage = new LandingPage();
        landingPage.repairsModule.click();
    }
    @Test
    public void deliveryAddressEnter(){
        DeliveryAddressLandingPage deliveryAddressLandingPage = new DeliveryAddressLandingPage();
        deliveryAddressLandingPage.createButton.click();
        Assert.assertTrue(deliveryAddressLandingPage.createButton.isDisplayed(),"is not displayed, FAIL!");
        deliveryAddressLandingPage.deliveryAddress.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(deliveryAddressLandingPage.deliveryAddress));
        deliveryAddressLandingPage.dropDownButton.click();
        Assert.assertTrue(deliveryAddressLandingPage.dropDownButton.isDisplayed(),"if it is not clicked ,FAIL!");


    }
    @Test
    public void deliveryAddressClickSearchMore(){
        DeliveryAddressLandingPage deliveryAddressLandingPage = new DeliveryAddressLandingPage();
        deliveryAddressLandingPage.searchMore.click();
        Assert.assertTrue(deliveryAddressLandingPage.searchMore.isDisplayed(),"is not displayed , FAIL!");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(deliveryAddressLandingPage.deliveryAddress));


    }
    @Test
    public void deliveryAddressEdit(){
        DeliveryAddressLandingPage deliveryAddressLandingPage = new DeliveryAddressLandingPage();
        deliveryAddressLandingPage.createAndEdit.click();
        Assert.assertTrue(deliveryAddressLandingPage.createAndEdit.isDisplayed(),"is not displayed, FAIL!");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(deliveryAddressLandingPage.deliveryAddress));


    }

    @AfterClass
    public void tearDown(){

        Driver.getDriver().quit();
    }
}