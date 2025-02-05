package InsiderTest.methods;


import InsiderTest.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }


    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            System.out.println(findElement(by).getText() + " - Template is Open, Content is Displayed...");
            return true;
        } catch (Exception e) {
            System.out.println(findElement(by).getText() + " - Template is Closed, Content Cannot Be Viewed...");
            return false;
        }
    }

    public void scrollWithAction(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public void clickOnCookieAcceptButton() {
        waitBySeconds(2);
        try {
            WebElement closeCookie = driver.findElement(By.xpath("//*[text()[contains(.,'Accept All')]]"));
            closeCookie.click();
            System.out.println("Cookie Accepted on Page");
        }catch (NoSuchElementException e) {
            System.out.println("No Cookies Arrived, Testing Continues...");
        }
    }

    public void clickOnClosePopUpButton() {
        waitBySeconds(3);
        try{
            WebElement closePopUp = driver.findElement(By.cssSelector("span[class=\"ins-close-button\"]"));
            closePopUp.click();
            System.out.println("Pop-Up on Page Closed...");
        }catch (NoSuchElementException e) {
            System.out.println("Pop-up is not open yet, testing is on going...");
        }
    }

    public void hoverElement(By by){

        WebElement hover = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(hover).perform();
    }

}




