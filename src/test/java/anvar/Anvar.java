package anvar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LandingPage;
import pages.LoginPage;
import pages.RepairsModulePage;
import utilities.Config;
import utilities.Driver;




public class Anvar {

    @BeforeMethod
    public void setUp() {
        //get the BriteERP login page:
        Driver.getDriver().get(Config.getProperty("brUrl"));
    }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();
    }

    @Test
    public void currentLocationCreat() throws InterruptedException {
        RepairsModulePage repairsModulePage = new RepairsModulePage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = new LandingPage();

        //enter valid e-mail:
        loginPage.emailInput.sendKeys(Config.getProperty("briteMUsername"));

        //enter valid password:
        loginPage.passwordInput.sendKeys(Config.getProperty("briteMPassword"));

        //click the login button to login:
        loginPage.logInButton.click();

        //click repairs module box to go to repairs module:
        landingPage.repairsModule.click();

        utilities.Pause.pause(5);
        repairsModulePage.RepairOrderCreateButton.click();
        utilities.Pause.pause(5);
        repairsModulePage.currentLocationBox.click();
        //utilities.Pause.pause(3);
        repairsModulePage.currentLocationCreateAndEdit.click();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class='o_form_view o_form_nosheet o_form_editable']")).isDisplayed(), "Invalid, tests is failed");


    }

    @Test
    public void currentLocationSearch() throws InterruptedException {
        RepairsModulePage repairsModulePage = new RepairsModulePage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = new LandingPage();

        //enter valid e-mail:
        loginPage.emailInput.sendKeys(Config.getProperty("briteMUsername"));

        //enter valid password:
        loginPage.passwordInput.sendKeys(Config.getProperty("briteMPassword"));

        //click the login button to login:
        loginPage.logInButton.click();

        //click repairs module box to go to repairs module:
        landingPage.repairsModule.click();

        utilities.Pause.pause(5);
        repairsModulePage.RepairOrderCreateButton.click();
        utilities.Pause.pause(5);
        repairsModulePage.currentLocationBox.click();
        //utilities.Pause.pause(3);
        repairsModulePage.currentLocarionSearchMore.click();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h4")).isDisplayed(), "Invalid, tests is failed");


    }
}
