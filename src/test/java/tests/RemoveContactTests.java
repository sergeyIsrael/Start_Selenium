package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod (alwaysRun = true)
    public void precondition(){
        if(!app.getUser().isLogged()) {
            String email = "sergei1@mail.com", password = "Ss34567$";
            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(email, password);
            app.getUser().submitLogin();
        }
    }

    @Test
public void removeOneContactPositive(){
        int res = app.getHelperContact().removeOneContact();
        Assert.assertEquals(-1, res);
    }

    @Test
//              my method
    public void removeContactPositive() {
        boolean isContactExist = app.getHelperContact().findContact("0537732849");
        app.getHelperContact().clickRemoveButton();
        Assert.assertTrue(isContactExist);

    }




    }
