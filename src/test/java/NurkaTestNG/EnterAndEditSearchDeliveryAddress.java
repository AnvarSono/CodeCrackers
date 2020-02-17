package NurkaTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class EnterAndEditSearchDeliveryAddress {
    WebDriver driver;

    @BeforeMethod
    public  void deliveryAddress(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://app.briteerp.com/web/login");

    }
    @Test
    public void loginAndEditDeliveryAddress(){
        Driver.getDriver().findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("inm5@info.com");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("trt332qWW12"+ Keys.ENTER);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/form/div[3]/button")).click();

    }

    }

