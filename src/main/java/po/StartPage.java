package po;

import org.openqa.selenium.By;
import po.utils.Logger;

public class StartPage extends AbstractPage {

    private static final String URL = "https://github.com/login";
    private static final By LOGIN = By.id("login_field");
    //private static final By LOGOIN = By.xpath("//a[contains(text(),'Текст')]");
    //*[@id="login_field"]
    private static final By PASSWORDINPUT = By.id("password");
    //private static final By CORRECT_PASSWORD = By.xpath("//ul[@class='HeaderNavlink name']/li[2]");
    ////*[@id="password"]
    //private static final By Z = By.xpath("//iframe[contains(@sandbox,'allow-top-navigation')]");
    //private static final By LOGINBUTTON = By.xpath("//*[@type='submit']");
    private static final By LOGINBUTTON = By.xpath("//*[@class='btn btn-primary btn-block']");

    public StartPage open() {
        driver.get(URL);
        Logger.info("Opening URL");
        return this;
    }

    public StartPage login(String USERNAME, String PASSWORD) {
        Logger.info("Entering login...");
        driver.findElement(LOGIN).sendKeys(USERNAME);
        Logger.info("Entering password...");
        driver.findElement(PASSWORDINPUT).sendKeys(PASSWORD);
        //driver.findElement(PASSWORDINPUT).click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Logger.info("Pressing button \"Sing in\"...");
        driver.findElement(LOGINBUTTON).click();
        return new StartPage();
    }

    public StartPage isLoginWasSucsessfull() {
        return new StartPage();
    }


    //*[@id="js-flash-container"]/div/div/text()
}