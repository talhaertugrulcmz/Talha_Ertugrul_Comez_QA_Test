package InsiderTest.pages;

import InsiderTest.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static InsiderTest.driver.BaseTest.driver;

public class HomePage {
    Methods methods;
    Logger logger = LogManager.getLogger(Methods.class);


    public HomePage(){
        methods = new Methods();
    }


    public void clickCompanyMenu(){
        methods.clickOnCookieAcceptButton();
        methods.clickOnClosePopUpButton();

        WebElement companyMenu = methods.findElement(By.xpath("//a[contains(text(), 'Company')]"));
        String companyElement = companyMenu.getText();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Company')]")));

        if (companyElement.contains("Company")){
            companyMenu.click();
        }else {
            logger.info("element not found...");
        }
    }
}