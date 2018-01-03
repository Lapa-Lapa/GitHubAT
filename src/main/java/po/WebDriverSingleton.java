package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import po.utils.Logger;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static WebDriver instance;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = init();
    }

    private static WebDriver init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Logger.info("Chromedriver.exe was found in  was src/main/resources");
        Logger.info("Starting to managing chromedriver...");
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        Logger.info("Still managing chromedriver...");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Logger.info("Still managing chromedriver...");
        driver.manage().timeouts().setScriptTimeout(35, TimeUnit.SECONDS);
        Logger.info("Make browser fullscreen:");
        driver.manage().window().maximize();
        Logger.info("Done!");
        Logger.info("WebDriver was init");
        return driver;
    }

    public static void kill() {
        if (instance != null) {
            try {
                instance.quit();
            } catch (Exception e) {
                Logger.error("Cannot kill browser");
            } finally {
                instance = null;
            }
        }
    }
}