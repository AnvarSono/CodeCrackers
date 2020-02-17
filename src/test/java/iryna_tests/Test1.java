package iryna_tests;

import org.testng.annotations.Test;
import utilities.Driver;

public class Test1 {
    @Test
    public void test2(){
        Driver.getDriver().get("https://www.google.com/");
    }
}
