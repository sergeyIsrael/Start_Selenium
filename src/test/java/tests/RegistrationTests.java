package tests;

import User.User;
import manager.TestNgListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)


public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void registrationPositive(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        String email = "abc" + i + "@def.com", password = "$Abcdef12345";
        User user = new User()
        .withEmail("abc" + i + "@def.com")
        .withPassword("$Abcdef12345");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitRegistration();
        // Assert
//        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc" + i + "def.com", password = "$Abcdef12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
    }

    @Test
    public void registrationNegativeWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc" + i + "@def.com", password = "Abcdef12345";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitRegistration();
    }

    @AfterMethod
    public void tearDown(){
    }

}
