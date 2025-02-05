package InsiderTest.pages;

import InsiderTest.methods.Methods;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotControl {

    Methods methods;

    public ScreenShotControl() {
        methods = new Methods();
    }

    public class ScreenshotUtil {
        public static void takeScreenshot(WebDriver driver, String testName) {
            try {
                // Tarih formatı oluştur
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

                // Screenshot al
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Dosya yolunu belirle
                String filePath = "screenshots/" + testName + "_" + timestamp + ".png";

                // Klasör yoksa oluştur
                Files.createDirectories(Paths.get("screenshots"));

                // Screenshot'u kaydet
                Files.move(screenshot.toPath(), Paths.get(filePath));

                System.out.println("📸 Screenshot saved: " + filePath);
            } catch (IOException e) {
                System.err.println("!️ Screenshot could not be saved: " + e.getMessage());
            }
        }
    }
}
