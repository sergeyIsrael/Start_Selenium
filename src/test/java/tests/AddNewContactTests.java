package tests;

import User.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    Logger logger = LoggerFactory.getLogger(AddNewContactTests.class);

@BeforeMethod(alwaysRun = true)
    public void precondition(){
    if(!app.getUser().isLogged()) {
        String email = "sergei1@mail.com", password = "Ss34567$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
    }
}

@Test (invocationCount = 5, groups = {"positive"}) // will be created 5 contacts
    public void addNewContactPositive(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;
    Contact contact = Contact.builder()
            .name("Bin" + i )
            .lastName("Mister")
            .phone("0537731" + i)
            .email("mia" + i +"@gmail.com")
            .address("Tel Aviv")
            .description("goood person")
            .build();

    logger.info("Phone number is " + contact.getPhone());
    app.getHelperContact().openAddContactForm();
    app.getHelperContact().fillContactForm(contact);
    app.getHelperContact().submitContactForm();
    app.getHelperContact().pause(3000);
    Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
}





}
