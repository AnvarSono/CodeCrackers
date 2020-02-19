package eduardTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        WebElement createButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_list_button_add']"));
        createButton.click();

        WebElement productRepairButton = Driver.getDriver().findElement(By.xpath("//input[@id='o_field_input_104']"));
        productRepairButton.click();

        List<WebElement> productsToRepair = Driver.getDriver().findElements(By.xpath("//ul[@id='ui-id-3']"));
        Assert.assertFalse(productsToRepair.isEmpty(), "The list is Empty. Test FAILED");

        Pause.pause(3);
        WebElement searchMoreButton = Driver.getDriver().findElement(By.xpath("//a[.='Search More...']"));
        searchMoreButton.click();


        WebElement createButton2 = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-primary']"));
        createButton2.click();

        WebElement greyText = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Product Name']"));
        Assert.assertTrue(greyText.isDisplayed(),"Grey Text is NOT displayed. Test FAILED");

        WebElement inputProductName = Driver.getDriver().findElement(By.id("o_field_input_496"));
        inputProductName.sendKeys("Laptop");

        WebElement productTypeButton = Driver.getDriver().findElement(By.id("o_field_input_503"));

        Select dropdownProductType = new Select(productTypeButton);
        dropdownProductType.selectByVisibleText("Service");

        WebElement internalReferenceTextBox = Driver.getDriver().findElement(By.id("o_field_input_504"));
        internalReferenceTextBox.sendKeys("Costel");

        WebElement bareCodeBoxText = Driver.getDriver().findElement(By.id("o_field_input_505"));
        bareCodeBoxText.sendKeys("123456L");

        List<WebElement> categoryList = Driver.getDriver().findElements(By.id("o_field_input_506"));
        Assert.assertFalse(categoryList.isEmpty(),"Category List is EMPTY. Test FAILED");

    }


//    @AfterClass
//    public void tearDown(){
//        Driver.getDriver().quit();
//    }
    }

