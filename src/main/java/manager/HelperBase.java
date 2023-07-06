package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver wd;

    ApplicationManager app = new ApplicationManager();

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

        public void clickByCoordinates(By locator){
        Rectangle rect = wd.findElement(locator).getRect();
        int x = rect.getX() + rect.getWidth() / 2;
        int y = rect.getY() + rect.getHeight() / 2;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x, y)
                .click()
                .perform();
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
//        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;
    }


    //    // get random number xxxx
//    public int getRandomNumber() {
//        int i = (int) (Math.random() * 10000);
//        return i;
//    }

    public void takeScreenShot(String link){
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot =  new File(link);
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e){
            e.printStackTrace();
        }
}


}