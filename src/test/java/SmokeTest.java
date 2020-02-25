import aiperi.RepairOrdersPage;
import eduardTests.RepairPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.RepairsModulePage;
import utilities.Config;
import utilities.Driver;
import utilities.Pause;

public class SmokeTest {

    RepairOrdersPage repairOrdersPage = new RepairOrdersPage();




    @BeforeClass
    public void setUp() {

        Driver.getDriver().get(Config.getProperty("briteErpUrl"));
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(Config.getProperty("briteManagerEmail"));
        loginPage.passwordInput.sendKeys(Config.getProperty("briteManagerPassword"));
        loginPage.logInButton.click();
        LandingPage landingPage = new LandingPage();
        Pause.pause(3);
        landingPage.repairsModule.click();


    }

    @Test(priority = 1)
    public void mainRepairOrdersPage() {
        Pause.pause(3);
        repairOrdersPage.selectAllCheckboxes.click();
        Pause.pause(3);
        repairOrdersPage.deselectAllCheckboxes.click();
        Pause.pause(3);

        repairOrdersPage.sortRepairReference.click();
        Pause.pause(3);

        repairOrdersPage.sortProductToReference.click();
        Pause.pause(3);

        repairOrdersPage.sortCustomers.click();
        Pause.pause(3);

        repairOrdersPage.sortDeliveryAddress.click();
        Pause.pause(3);

        repairOrdersPage.sortWarrantyExpiration.click();
        Pause.pause(3);

        repairOrdersPage.sortStatus.click();
        Pause.pause(3);

    }

    @Test(priority = 2)
    public void currentLocationTest() {


        RepairsModulePage repairsModulePage = new RepairsModulePage();
        repairsModulePage.repairsModule.click();
        utilities.Pause.pause(3);
        repairsModulePage.RepairOrderCreateButton.click();
        utilities.Pause.pause(3);
        repairsModulePage.currentLocationBox.click();
        //utilities.Pause.pause(3);
        repairsModulePage.currentLocationCreateAndEdit.click();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class='o_form_view o_form_nosheet o_form_editable']")).isDisplayed(), "Invalid, tests is failed");


    }

   
        @AfterClass
    public void tearDown(){

        Driver.getDriver().close();
    }



}







