package eduardTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Pause;

import java.util.List;

public class EduardTests {

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
    public void productToRepair(){

        WebElement createButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_list_button_add']"));
        createButton.click();

        WebElement productRepairButton = Driver.getDriver().findElement(By.xpath("//input[@id='o_field_input_104']"));
        productRepairButton.click();

        List<WebElement> productsToRepair = Driver.getDriver().findElements(By.xpath("//ul[@id='ui-id-3']"));
        Assert.assertFalse(productsToRepair.isEmpty(),"The list is Empty. Test FAILED");
        }

      // WebElement searchMoreButton = Driver.getDriver().findElement()
    }

