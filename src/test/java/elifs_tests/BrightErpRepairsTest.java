package elifs_tests;

import elifs_pages.BrightErpCreatePages;
import elifs_pages.BrightErpRepairsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.Pause;

public class BrightErpRepairsTest {
    //Comment
    WebDriver driver;
    BrightErpRepairsPage brightErpRepairsPage = new BrightErpRepairsPage();
    BrightErpCreatePages brightErpCreatePages = new BrightErpCreatePages();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(Config.getProperty("brightErpUrl"));
        loginPage.eMailAdd.sendKeys(Config.getProperty("ErpEmailAddress"));
        loginPage.passWord.sendKeys(Config.getProperty("ErpPassword"));
        loginPage.submitButton.click();

    }

    @Test
    public void navigateToCreatePage() throws InterruptedException {


        Pause.pause(5);
        brightErpRepairsPage.repairButton.click();
        Pause.pause(5);
        brightErpRepairsPage.createButton.click();

        Pause.pause(5);
        brightErpCreatePages.customerField.click();
        //brightErpCreatePages.customerField.
        brightErpCreatePages.dropDown.sendKeys("elif");

        Pause.pause(3);

        for(WebElement lists :brightErpCreatePages.customerList){
            Assert.assertTrue(lists.getText().contains("elif"),"not found");
        }




    }
    @Test
    public void searchCustomer() throws InterruptedException {

        Pause.pause(5);
        brightErpRepairsPage.repairButton.click();

        Pause.pause(5);
        brightErpRepairsPage.createButton.click();

        Pause.pause(5);

        brightErpCreatePages.customerField.click();

        Pause.pause(3);
        brightErpCreatePages.searchMore.click();

        Pause.pause(3);
        //brightErpCreatePages.searchField.sendKeys("elif");

        String actualSearchHeader = brightErpCreatePages.searchCustomerHeader.getText();
        String expectedSearchHeader = "Search: Customer";
        //System.out.println(actualSearchHeader);
        Assert.assertTrue(actualSearchHeader.equals(expectedSearchHeader));

    }

    @Test
    public void newCustomer() throws InterruptedException {
        //Thread.sleep(5000)
        Pause.pause(5);
        brightErpRepairsPage.repairButton.click();
        //Thread.sleep(5000);
        Pause.pause(5);
        brightErpRepairsPage.createButton.click();
        //Thread.sleep(5000);
        Pause.pause(5);
        brightErpCreatePages.customerField.click();
        //Thread.sleep(8000);
        Pause.pause(5);
        brightErpCreatePages.createAndEdit.click();
        //Thread.sleep(3000);
        Pause.pause(3);
        brightErpCreatePages.nameBox.sendKeys("elif");
        //Thread.sleep(3000);
        Pause.pause(3);
        brightErpCreatePages.saveBttn.click();
        //String actualText = brightErpCreatePages.customerField.getText();
        //Thread.sleep(3000);
        Pause.pause(3);
        brightErpCreatePages.customLink.click();
        //Thread.sleep(3000);
        Pause.pause(3);
        brightErpCreatePages.createButton2.click();
        //Thread.sleep(3000);
        Pause.pause(3);
        brightErpCreatePages.contactName.sendKeys("ayse");
        String expected = "ayse";
        //Thread.sleep(5000);
        Pause.pause(5);
        //String actual = brightErpCreatePages.contactName.getText();
        //Assert.assertTrue(actual.contains(expected));
        brightErpCreatePages.saveAndClose.click();
        String expectedTitle = "Open: Customer";
        //Thread.sleep(8000);
        Pause.pause(5);
        System.out.println(brightErpCreatePages.openCustomer.getText());
        if(brightErpCreatePages.openCustomer.getText().contains(expectedTitle)){
            System.out.println("Test is passed");
        }else{
            System.out.println("test is failed");
        }




    }
}


