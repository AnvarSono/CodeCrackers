package aiperi;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Pause;



public class Aiperi {

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
    @Test
    public void mainRepairOrdersPage(){
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





}



