package aiperi;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class RepairOrdersPage {



    public RepairOrdersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




   @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[1]")
     public WebElement selectAllCheckboxes;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[1]/div")
       public WebElement deselectAllCheckboxes;


     @FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[2]")
        public WebElement sortRepairReference;



    @FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[3]")
       public WebElement sortProductToReference;



     @FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[4]")
       public WebElement sortCustomers;


   @FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[5]")
        public WebElement sortDeliveryAddress;


    @FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[6]")
       public WebElement sortWarrantyExpiration;

   @FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[7]")
        public WebElement sortStatus;


}
