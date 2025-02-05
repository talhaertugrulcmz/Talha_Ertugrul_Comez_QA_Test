package InsiderTest.pages;

import InsiderTest.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class CareersPage {
    Methods methods;
    Logger logger = LogManager.getLogger(Methods.class);

    public CareersPage() {
        methods = new Methods();
    }

    public void clickCareers() {
        methods.waitBySeconds(2);
        WebElement careersLink = methods.findElement(By.xpath("//a[contains(text(), 'Careers')]"));
        String careersElement = careersLink.getText();

        if (careersElement.contains("Careers")) {
            careersLink.click();
            logger.info("element found...");
        } else {
            logger.info("element not found...");
        }
    }
}


