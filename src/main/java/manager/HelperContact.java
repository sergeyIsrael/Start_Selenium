package manager;

import User.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperContact extends HelperBase {

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddContactForm(){
        wd.findElement(By.xpath("//*[.='ADD']")).click();
    }

    public void openContacts(){
        wd.findElement(By.xpath("//*[.='CONTACTS']")).click();
    }

    public void fillContactForm(Contact contact){
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());
    }

    public void submitContactForm(){
        click(By.xpath("//button[.='Save']"));
    }

    public boolean isContactCreated(Contact contact){
       String phone = wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3"))
                .getText();
       return  phone.equals(contact.getPhone());
    }

public void findContact(String phoneNumber) {
    WebElement contact = null;
    try {
        contact = wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM']/h3[text()='" + phoneNumber + "']"));
    } catch (NoSuchElementException e) {
        app.logger.info("Contact with phone: " + phoneNumber + " is not found.");
    }

    if (contact != null)
        contact.click();
}

public void clickDeleteContact(){
        app.getHelperContact().click(By.xpath("//button[text()='Remove']"));
//        app.getHelperContact().clickByCoordinates(By.xpath("//button/following-sibling::button"));

//    //div[@class='contact-item-detailed_card__50dTS']/button[2]
//    //button[text()='Remove']
//    //button[normalize-space()='Remove']
//    div[class*='contact-item-detailed_'] button:last-child
//    div[class*='contact-item-detailed_'] button:nth-of-type(2)
}







}
