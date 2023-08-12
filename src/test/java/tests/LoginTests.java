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
//        проверка что Alert с текстом WrongFormatMessage
        Assert.assertTrue(app.getUser().isWrongFormatMessage());
//        жмем Ок у алерта:
//        true - был алерт и мы закрыли его,
//        false - не было алерта
        Assert.assertTrue(app.getUser().isAlertPresent());
    }







}
