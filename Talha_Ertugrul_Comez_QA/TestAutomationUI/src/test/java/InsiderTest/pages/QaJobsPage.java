package InsiderTest.pages;

import InsiderTest.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static InsiderTest.driver.BaseTest.driver;

public class QaJobsPage {
    Methods methods;
    Logger logger = LogManager.getLogger(Methods.class);


    public QaJobsPage() {
        methods = new Methods();
    }

    public void scrollSeeAllTeams() {

        methods.waitBySeconds(1);
        methods.scrollWithAction(By.xpath("//a[contains(text(), 'See all teams')]"));
        methods.waitBySeconds(1);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("a[class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore']")));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(), 'Quality Assurance')]")));

        methods.waitBySeconds(1);
        methods.scrollWithAction(By.xpath("//h3[contains(text(), 'Quality Assurance')]"));
        WebElement qualityAssuranceTeams = methods.findElement(By.xpath("//h3[contains(text(), 'Quality Assurance')]"));
        qualityAssuranceTeams.click();
    }

    public void clickSeeAllQAJobs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'See all QA jobs')]")));

        WebElement qaJobsButton = methods.findElement(By.xpath("//a[contains(text(), 'See all QA jobs')]"));
        qaJobsButton.click();
        logger.info("QA Jobs Button Clicked...");
    }

    public void clicFilterByDepartment() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='position-list-item-wrapper bg-light']")));
        Thread.sleep(3000);
        WebElement filterByDepartment = methods.findElement(By.cssSelector("span[id='select2-filter-by-department-container']"));
        filterByDepartment.click();
        Thread.sleep(1000);

        methods.isElementVisible(By.cssSelector("option[class='job-team qualityassurance']"));
        WebElement departmentElement = driver.findElement(By.cssSelector("option[class='job-team qualityassurance']"));

        //methods.hoverElement(By.cssSelector("option[class='job-team qualityassurance']"));
        Thread.sleep(2000);
        departmentElement.click();
    }

    public void clicFilterByLocation() throws InterruptedException {
        Thread.sleep(1000);
        WebElement filterByLocation = methods.findElement(By.cssSelector("span[id='select2-filter-by-location-container']"));
        filterByLocation.click();
        Thread.sleep(1000);

        methods.isElementVisible(By.cssSelector("option[class='job-location istanbul-turkey']"));
        WebElement locationSelectElement = driver.findElement(By.cssSelector("option[class='job-location istanbul-turkey']"));
        WebElement locationElementArea = driver.findElement(By.cssSelector("b[role=\"presentation\"]"));

        //methods.hoverElement(By.cssSelector("option[class='job-location istanbul-turkey']"));
        locationSelectElement.click();
        Thread.sleep(1000);
        locationElementArea.click();
        Thread.sleep(1000);

    }

}
