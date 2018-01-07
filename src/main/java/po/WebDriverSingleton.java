package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import po.utils.Logger;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static WebDriver instance;
    private static int TIME = 15;
    private static int WIDTH = 1040;
    private static int HEIGHT = 820;

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
        driver.manage().timeouts().pageLoadTimeout(TIME, TimeUnit.SECONDS);
        Logger.info("Still managing chromedriver...");
        //  *   *   *   *   *   Implicit wait   *   *   *   *   *
        driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
        Logger.info("Still managing chromedriver...");
        //  *   *   *   *   *       End         *   *   *   *   *
        driver.manage().timeouts().setScriptTimeout(TIME, TimeUnit.SECONDS);
        Logger.info("Making browser window resolution: ");
        //driver.manage().window().maximize();Logger.info("Fullscreen");
        //driver.manage().window().setSize(new Dimension(1920, 1080));Logger.info("Full HD");
        //driver.manage().window().setSize(new Dimension(1280, 720));Logger.info("HD");
        driver.manage().window().setSize(new Dimension(WIDTH, HEIGHT));
        Logger.info("Custom: " + WIDTH + "*" + HEIGHT);
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