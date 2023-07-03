package otherTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrintTextFromLeumi {

    WebDriver wd;

    @BeforeTest
    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://www.leumi.co.il/");
        //        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void printTextFromLeumi(){

        System.out.println(wd.findElement(
                By.xpath("//span[contains(text(),'פרטי')]")).getText());
    }


}
