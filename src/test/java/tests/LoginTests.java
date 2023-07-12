package tests;

import User.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test(groups = {"smoke","positive"})
    public void loginPositiveTestBase(){
//        String email = "abc@def.com", password = "$Abcdef12345";
        User user = new User()
                .withEmail("sergei1@mail.com")
                .withPassword("Ss34567$");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test(groups = {"regress", "negative"})
    public void loginNegativeWrongEmail(){
        String email = "sergei1@mailcom", password = "Ss34567$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
//        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isWrongFormatMessage());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }


//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }



//    @Test
//    public void loginPositiveTest(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill login form
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc@def.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
//
//        // click on button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        // Assert
//        pause(3000);
////        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//
//    }


//    @Test
//    public void loginNegativeTestWrongEmail(){
//
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        // fill login form
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abcdef.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
//
//        // click on button Login
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        // Assert
//    }

//    @Test
//    public void loginNegativeTestWrongPassword() {
//        String email = "abc@def.com", password = "Abcdef12345";
//        openLoginForm();
//        fillLoginForm(email, password);
//        submitLogin();
//    }
//    @AfterMethod
//    public void tearDown(){
//
//    }



}
