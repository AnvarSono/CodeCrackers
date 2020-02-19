package anvar;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
        utilities.Pause.pause(5);
        repairsModulePage.RepairOrderCreateButton.click();
        utilities.Pause.pause(5);
        repairsModulePage.currentLocationBox.click();
        //utilities.Pause.pause(3);
        repairsModulePage.currentLocationCreateAndEdit.click();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class='o_form_view o_form_nosheet o_form_editable']")).isDisplayed(), "Invalid, tests is failed");




    }
    @AfterClass
    public void tearDown(){

        Driver.getDriver().quit();
    }

}
