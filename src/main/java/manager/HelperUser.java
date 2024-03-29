package manager;

import User.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void fillLoginForm(User user){
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
//        type(By.xpath("input[2]"), user.getPassword()); // wrong xpath
    }

    public void submitRegistration(){
        click(By.xpath("//button[2]"));
    }

    public void submitLogin(){
        click(By.xpath("//button[1]"));
    }

    public void logout(){
        click(By.xpath("//*[.='Sign Out']"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

//   alert - всплывающее предупреждающее окно
    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) return false;
//        сдлеать в фокусе alert окно
        wd.switchTo().alert();
        alert.accept();
        return true;
    }

    public boolean isWrongFormatMessage(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        return alert.getText().contains("Wrong email or password");
    }


}
