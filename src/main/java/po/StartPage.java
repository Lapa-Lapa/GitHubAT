package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import po.utils.Logger;

import java.util.List;

public class StartPage extends AbstractPage {

    private static final String URL = "https://www.amazon.com/";
    private static final By SEARCH_FIELD = By.cssSelector("#twotabsearchtextbox");//1
    private static final By SEARCH_GO_BUTTON = By.xpath("//input[@value='Go']");//2
    private static final By FIRST_SEARCH_RESULT = By.cssSelector("#result_0 a.s-access-detail-page");
    private static final By FIRST_SEARCH_RESULT_PRICE = By.cssSelector("#priceblock_ourprice");
    private static final By DEPARTMENTS_DROP_DOWN_LIST = By.id("nav-link-shopall");//Identifier (ID) locators
    private static final By ALL_DROP_DOWN_LIST = By.linkText("url");//Name locators
    private static final By TRENDING_DEALS_AREA = By.xpath("//ul[@class='a-unordered-list a-nostyle a-horizontal feed-carousel-shelf']");
    //private static final By TRENDING_DEALS_EACH_ITEM = By.xpath("//div[@class='dealPrice']/span"); return price for first
    private static final By TRENDING_DEALS_EACH_ITEM = By.xpath("//div[@class='dealPrice']");
    //WebElement TRENDING_DEALS_INFO_INSIDE_FIRST_ITEM = driver.findElement(By.className("feed-carousel-card")).findElement(By.tagName("span"));
    List<WebElement> ALL_TREANDING_DEALS=driver.findElements(By.xpath("//div[@class='dealPrice']"));//5 в теории, пока не работает

    //private static final By LOGOIN = By.xpath("//a[contains(text(),'Текст')]");
    //*[@id="login_field"]
    //
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
        Logger.info("Search for: " + TEXT + " initiated");
        return new StartPage();
    }

    public String getFirstSearchResultPrice(String TEXT) {
        driver.findElement(FIRST_SEARCH_RESULT).click();
        String price = driver.findElement(FIRST_SEARCH_RESULT_PRICE).getText();
        Logger.info(TEXT + " price is: " + price);
        return price;
    }
    public StartPage clickDepartmentsDropDownList() {
        driver.findElement(DEPARTMENTS_DROP_DOWN_LIST).click();
        return new StartPage();
    }
    public StartPage clickAllDropDownList() {
        driver.findElement(ALL_DROP_DOWN_LIST).click();
        return new StartPage();
    }

    public int getNumberOfTrengingDeals() {
        Logger.info("Number of trenging deals is: " + driver.findElement(TRENDING_DEALS_EACH_ITEM).getText());
        Logger.info("Number of trenging deals is: " + driver.findElement(TRENDING_DEALS_AREA).findElement(TRENDING_DEALS_EACH_ITEM).getText());
        Logger.info("Number of trenging deals is: " + ALL_TREANDING_DEALS.size());
        int NUMBER_OF_TRENDING_DEALS = ALL_TREANDING_DEALS.size();
        Logger.info("Number of trenging deals is: " + ALL_TREANDING_DEALS.size());
        return NUMBER_OF_TRENDING_DEALS;
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