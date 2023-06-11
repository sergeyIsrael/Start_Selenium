import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestRegistrations {

    WebDriver wd;

    @BeforeTest
    public void precondition(){
        wd = new ChromeDriver();
        wd.get("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void NegativeRegistrationTest() throws InterruptedException {
        //LOGIN
        wd.findElement(By.xpath("//div//a[@href='/login']")).click();

        // fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        WebElement emailInput = wd.findElement(By.xpath("//input[@name='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("abc" + i + "def.com");

        // fill password form
        WebElement passInput = wd.findElement(By.xpath("//input[@name='password']"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("$Abcdef12345");

        // click on button Registration
        wd.findElement(By.xpath("//button[@type='submit'][@name='registration']")).click();
//        wd.findElement(By.xpath("//button[2]")).click();

        // Assert
//        Assert.assertTrue();
//        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//        Thread.sleep(5);

    }

    @AfterTest
    public void postCondition(){
        wd.quit();
    }



}
