package InsiderTest.pages;

import InsiderTest.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewRolePage {
    Methods methods;

    public ViewRolePage() {
        methods = new Methods();
    }

    public void clickViewRoleButton() throws InterruptedException {
        methods.hoverElement(By.cssSelector("p[class='position-title font-weight-bold']"));
        methods.waitBySeconds(1);
        methods.isElementVisible(By.xpath("//a[contains(text(), 'View Role')]"));
        WebElement viewRoleButton = methods.findElement(By.xpath("//a[contains(text(), 'View Role')]"));
        viewRoleButton.click();
        Thread.sleep(1000);

    }

}
