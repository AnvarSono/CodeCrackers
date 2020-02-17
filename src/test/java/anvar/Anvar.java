package anvar;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.RepairsModulePage;
import utilities.Config;
import utilities.Driver;

public class Anvar {
   @BeforeClass
    public void setUp(){
        Driver.getDriver().get(Config.getProperty("brUrl"));
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(Config.getProperty("briteMUsername"));
        loginPage.passwordInput.sendKeys(Config.getProperty("briteMPassword"));
        loginPage.logInButton.click();
        LandingPage landingPage = new LandingPage();
        landingPage.repairsModule.click();

    }
    @Test
    public void currentLocationTest(){


        RepairsModulePage repairsModulePage = new RepairsModulePage();
        repairsModulePage.repairsModule.click();
        repairsModulePage.RepairOrderCreateButton.click();
        repairsModulePage.currentLocationBox.click();
        //utilities.Pause.pause(3);
        repairsModulePage.currentLocationCreateAndEdit.click();


    }
}
