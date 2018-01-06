package po;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import po.utils.Logger;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static WebDriver instance;
    private static int TIME = 15;

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
        driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
        Logger.info("Still managing chromedriver...");
        driver.manage().timeouts().setScriptTimeout(TIME, TimeUnit.SECONDS);
        Logger.info("Make browser fullscreen:");
        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1920, 1080));//(Full High Definition)
        //driver.manage().window().setSize(new Dimension(1280, 720));//(HD Ready)
        driver.manage().window().setSize(new Dimension(1040, 820));//(Custom resolution)
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