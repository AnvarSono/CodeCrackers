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

public class BrightErpRepairsTest {
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

        Thread.sleep(5000);
        brightErpRepairsPage.repairButton.click();
        Thread.sleep(5000);
        brightErpRepairsPage.createButton.click();
        Thread.sleep(5000);
        brightErpCreatePages.customerField.click();
        //brightErpCreatePages.customerField.
        brightErpCreatePages.dropDown.sendKeys("elif");
        Thread.sleep(3000);

        for(WebElement lists :brightErpCreatePages.customerList){
            Assert.assertTrue(lists.getText().contains("elif"),"not found");
        }




    }
    @Test
    public void searchCustomer() throws InterruptedException {
        Thread.sleep(5000);
        brightErpRepairsPage.repairButton.click();
        Thread.sleep(5000);
        brightErpRepairsPage.createButton.click();
        Thread.sleep(5000);

        brightErpCreatePages.customerField.click();
        Thread.sleep(8000);
        brightErpCreatePages.searchMore.click();
        Thread.sleep(3000);
        //brightErpCreatePages.searchField.sendKeys("elif");

        String actualSearchHeader = brightErpCreatePages.searchCustomerHeader.getText();
        String expectedSearchHeader = "Search: Customer";
        //System.out.println(actualSearchHeader);
        Assert.assertTrue(actualSearchHeader.equals(expectedSearchHeader));

    }

    @Test
    public void newCustomer() throws InterruptedException {
        Thread.sleep(5000);
        brightErpRepairsPage.repairButton.click();
        Thread.sleep(5000);
        brightErpRepairsPage.createButton.click();
        Thread.sleep(5000);
        brightErpCreatePages.customerField.click();
        Thread.sleep(8000);
        brightErpCreatePages.createAndEdit.click();
        Thread.sleep(3000);
        brightErpCreatePages.nameBox.sendKeys("elif");
        Thread.sleep(3000);
        brightErpCreatePages.saveBttn.click();
        //String actualText = brightErpCreatePages.customerField.getText();
        Thread.sleep(3000);
        brightErpCreatePages.customLink.click();
        Thread.sleep(3000);
        brightErpCreatePages.createButton2.click();
        Thread.sleep(3000);
        brightErpCreatePages.contactName.sendKeys("ayse");
        String expected = "ayse";
        Thread.sleep(5000);
        //String actual = brightErpCreatePages.contactName.getText();
        //Assert.assertTrue(actual.contains(expected));
        brightErpCreatePages.saveAndClose.click();
        String expectedTitle = "Open: Customer";
        Thread.sleep(8000);
        System.out.println(brightErpCreatePages.openCustomer.getText());
        if(brightErpCreatePages.openCustomer.getText().contains(expectedTitle)){
            System.out.println("Test is passed");
        }else{
            System.out.println("test is failed");
        }




    }
}


