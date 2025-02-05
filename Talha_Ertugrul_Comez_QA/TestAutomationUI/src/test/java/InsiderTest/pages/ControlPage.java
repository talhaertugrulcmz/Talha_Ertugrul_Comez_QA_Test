package InsiderTest.pages;

import InsiderTest.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static InsiderTest.driver.BaseTest.driver;

public class ControlPage {
    Methods methods;

    public ControlPage() {
        methods = new Methods();
    }

    public void HomePageControl() {
        String correctUrl = driver.getCurrentUrl();
        if (correctUrl.equals("https://useinsider.com/")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("https://useinsider.com/"));
            System.out.println("Page Link Correct : " + correctUrl);
        } else {
            System.out.println("Page Link Incorrect : " + correctUrl);
        }
    }

    public void clickCareersControl() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/careers/"));
        System.out.println("You are on the Career Page...");
    }


    public void careersTamplateControl() {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Ready to disrupt? ')]")));

        methods.isElementVisible(By.xpath("//h3[contains(text(), 'Our Locations')]"));
        methods.isElementVisible(By.xpath("//h2[contains(text(), 'Life at Insider')]"));
        methods.isElementVisible(By.xpath("//a[contains(text(), 'See all teams')]"));
        methods.isElementVisible(By.xpath("//h3[contains(text(), 'Find your calling')]"));
        }

    public void careersControlScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        methods.waitBySeconds(1);
        js.executeScript("window.scroll(500,2000)");
        methods.waitBySeconds(1);
        js.executeScript("window.scroll(2000,4000)");
        methods.waitBySeconds(1);
        js.executeScript("window.scroll(4000,6000)");
        methods.waitBySeconds(1);
    }

    public void verifyJobListContains(String keyword1, String keyword2, String keyword3) {
        List<WebElement> positionList1 = driver.findElements(By.cssSelector("p[class='position-title font-weight-bold']"));
        List<WebElement> departmentList2 = driver.findElements(By.cssSelector("span[class='position-department text-large font-weight-600 text-primary']"));
        List<WebElement> locationList3 = driver.findElements(By.cssSelector("div[class='position-location text-large']"));

        for (int i = 0; i < positionList1.size(); i++) {
            if (positionList1.get(i).getText().contains(keyword1)) {
                System.out.println("Position Name " + i + " : " + positionList1.get(i).getText());
            } else {
                System.out.println("Requested Position Name Not Found...");
            }
        }
        for (int j = 0; j < departmentList2.size(); j++) {
            if (departmentList2.get(j).getText().contains(keyword2)) {
                System.out.println("Department Name " + j + " : " + departmentList2.get(j).getText());
            } else {
                System.out.println("Requested Department Name Not Found...");
            }
        }
        for (int k = 0; k < locationList3.size(); k++) {
            if (locationList3.get(k).getText().contains(keyword3)) {
                System.out.println("Location Name " + k + " : " + locationList3.get(k).getText());
            } else {
                System.out.println("Requested Location Name Not Found...");
            }
        }
    }

    public void switchToWindowControl() {
        methods.waitBySeconds(5);

        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(), 'Apply for this job')]"));
        if (elements.size() >= 1) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found!");
        }

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowList.get(1));

        String newWindow = driver.getCurrentUrl();
        methods.waitBySeconds(1);

        if(newWindow.contains("lever")){
            System.out.println("Link : " + newWindow +"\n"+"Jobs Lever Page Viewed Correct Page");
        }else {
            System.out.println("Wrong Page!");
        }

    }
}