package po;

import org.openqa.selenium.By;
import po.utils.Logger;

public class StartPage extends AbstractPage {

    private static final String URL = "https://www.amazon.com/";
    private static final By SEARCH_FIELD = By.cssSelector("#twotabsearchtextbox");
    private static final By SEARCH_GO_BUTTON = By.xpath("//input[@value='Go']");
    private static final By FIRST_SEARCH_RESULT = By.cssSelector("#result_0 a.s-access-detail-page");
    private static final By FIRST_SEARCH_RESULT_PRICE = By.cssSelector("#priceblock_ourprice");
    //By.id("login_field");
    //private static final By LOGOIN = By.xpath("//a[contains(text(),'Текст')]");
    //*[@id="login_field"]
    //private static final By PASSWORDINPUT = By.id("password");
    //private static final By CORRECT_PASSWORD = By.xpath("//ul[@class='HeaderNavlink name']/li[2]");
    ////*[@id="password"]
    //private static final By Z = By.xpath("//iframe[contains(@sandbox,'allow-top-navigation')]");
    //private static final By LOGINBUTTON = By.xpath("//*[@type='submit']");
    //private static final By LOGINBUTTON = By.xpath("//*[@class='btn btn-primary btn-block']");

    public StartPage open() {
        driver.get(URL);
        Logger.info("URL: " + URL + " is open");
        return this;
    }

    public StartPage searchForText(String TEXT) {
        driver.findElement(SEARCH_FIELD).sendKeys(TEXT);
        driver.findElement(SEARCH_GO_BUTTON).click();
        Logger.info("Search for: " + TEXT + "initiated");
        return new StartPage();
    }

    public String getFirstSearchResultPrice(String TEXT) {
        driver.findElement(FIRST_SEARCH_RESULT).click();
        String price = driver.findElement(FIRST_SEARCH_RESULT_PRICE).getText();
        Logger.info(TEXT + " price is: " + price);
        return price;
    }


//    public StartPage login(String USERNAME, String PASSWORD) {
//        Logger.info("Entering login...");
//        driver.findElement(LOGIN).sendKeys(USERNAME);
//        Logger.info("Entering password...");
//        driver.findElement(PASSWORDINPUT).sendKeys(PASSWORD);
    //driver.findElement(PASSWORDINPUT).click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Logger.info("Pressing button \"Sing in\"...");
//        driver.findElement(LOGINBUTTON).click();
//        return new StartPage();
//    }
//
//    public StartPage isLoginWasSucsessfull() {
//        return new StartPage();
//    }


    //*[@id="js-flash-container"]/div/div/text()
}