package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import po.utils.Logger;

import java.util.List;

public class StartPage extends AbstractPage {

//    Types of Locators in Selenium:
//                          http://oss.infoscience.co.jp/seleniumhq/docs/book/Selenium_Documentation.pdf
//    1.ID                  WebElement locator_id = driver.findElement(By.id("email"));
//    2.Name                WebElement locator_name = driver.findElement(By.name("email_id"));
//      Name using filters  name=name_of_the_element filter=value_of_filter
//                          name=tripType value=roundtrip
//    3.Link Text           WebElement locator_linkText = driver.findElement(By.linkText("Create a Page"));
//    4.Partial Link Text   WebElement locator_PartialLinkText= driver.findElement(By.PartialLinkText("Create a "));
//    5.Tag Name            Select select = new Select(driver.findElement(By.tagName("DropDown"));
//                          select.selectByVisibleText("AUG");
//    6.Class Name          WebElement locator_class =driver.findElement(By.className(“input-xlarge”));
//    7.CSS Selector        Much faster than XPath
//                          WebElement firstNavItem = driver.findElement(By.cssSelector("#navigation li:first-child"));
//                          <li class="nav__item">
//                          <a href="https://www.gotspoilers.com/home" class="nav__link">Home</a>
//                          </li>
//                          <li class="nav__item">
//                          <a href="https://www.gotspoilers.com/blog" class="nav__link">Blog</a>
//                          </li>
//                          WebElement locator_class =driver.findElement(By.cssSelector(“input[type=text]”));
//                          <div id=“header”>
//                          <ul class=“header__nav nav”>
//                          <li class="nav__item"><a href=“#”>Home</a></li>
//                          <li class="nav__item"><a href=“#”>Blog</a></li>
//                          </ul>
//                          </div>
//                          WebElement navItemHome = driver.findElement(By.cssSelector("#header .navigation li:first-child"));
//                          https://saucelabs.com/resources/articles/selenium-tips-css-selectors
//                          https://videoportal.epam.com/video/BR0r33al
//      Tag and ID          findElement(By.cssSelector(tag#id))
//      Tag and class       findElement(By.cssSelector(tag.class))
//      Tag and attribute   findElement(By.cssSelector(tag[attribute=value]))
//                          findElement(By.cssSelector(input[name=lastName]))
//      Tag, class, and attribute   findElement(By.cssSelector(tag.class[attribute=value]))
//      Inner text          findElement(By.cssSelector(font:contains("Password:"))
//                          css=div:contains("Click here")
//                          driver.findElement(By.cssSelector("button:contains('Run Query')"));
//                          driver.findElement(By.cssSelector("css=.gwt-Button:contains('Run Query')"))
//    8.XPath               WebElement locator_xpath = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[4]/td/div/div[3]/table/tbody/tr[1]/td/a"));
//      Native Xpath
//      Relative Xpath      String firstNavItem = “//ul[@id=”navigation”]/*[1]”;
//                          browser.findElement(By.xpath(firstNavItem));
//                          <ul id=“navigation-4815162342” class=“nav”>
//                          <!-- list items -->
//                          </ul>
//                          WebElement navigation = browser.findElement(By.xpath(“//ul[contains(@id, ‘navigation’)]”));
//    9.DOM                 var navItems = document.getElementsByClassName(“nav__item”)[0];
//      Preferred selector order : id > name > css > xpath

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