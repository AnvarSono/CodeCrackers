package aiperi;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;


public class Aiperi {


    @BeforeClass
    public void setUp() {

        Driver.getDriver().get(Config.getProperty("briteErpUrl"));
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(Config.getProperty("briteManagerEmail"));
        loginPage.passwordInput.sendKeys(Config.getProperty("briteManagerPassword"));
        loginPage.logInButton.click();
        LandingPage landingPage = new LandingPage();
        landingPage.repairsModule.click();


    }


    @Test
    public void  mainCheckbox(){


    }

}



