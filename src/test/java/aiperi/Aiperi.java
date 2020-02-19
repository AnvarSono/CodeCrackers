package aiperi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

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



