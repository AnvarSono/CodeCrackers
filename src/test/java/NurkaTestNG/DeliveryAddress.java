package NurkaTestNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
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
        deliveryAddressLandingPage.createButton.sendKeys(Keys.ENTER);
        Assert.assertTrue(deliveryAddressLandingPage.createButton.isDisplayed(),"is not displayed, FAIL!");



    }
    @Test
    public void deliveryAddressClickSearchMore(){

    }
    @Test
    public void deliveryAddressEdit(){

    }
}