package po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import po.utils.Highliter;
import po.utils.Logger;

import java.util.ArrayList;
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
    private static final By SEARCH_FIELD = By.cssSelector("#twotabsearchtextbox");
    private static final By SEARCH_GO_BUTTON = By.xpath("//input[@value='Go']");
    private static final By FIRST_SEARCH_RESULT_NOT_SPONSORED = By.cssSelector("#result_3");
    private static final By FIRST_SEARCH_RESULT_NOT_SPONSORED_LINK_TO_DP = By.cssSelector("#result_3 a.s-access-detail-page");
    private static final By SORT_OPTIONS_ALL = By.xpath("//select[@id='sort']");
    private static final By FIRST_SEARCH_RESULT_PRICE = By.cssSelector("#priceblock_ourprice");
    private static final By DEPARTMENTS_DROP_DOWN_LIST = By.id("nav-link-shopall");
    private static final By ALL_DROP_DOWN_LIST = By.linkText("url");//Name locators
    private static final By TRENDING_DEALS_AREA = By.xpath("//div[@class='a-section a-spacing-none shogun-widget deals-shoveler aui-desktop fresh-shoveler']");

    //private static final By TRENDING_DEALS_EACH_ITEM = By.xpath("//div[@class='dealPrice']/*");
    //WebElement TRENDING_DEALS_INFO_INSIDE_FIRST_ITEM = driver.findElement(By.className("feed-carousel-card")).findElement(By.tagName("span"));
    //private static final By CORRECT_PASSWORD = By.xpath("//ul[@class='HeaderNavlink name']/li[2]");
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
    public Iphone_SE_Page searchForText_1(String TEXT) {
        driver.findElement(SEARCH_FIELD).sendKeys(TEXT);
        driver.findElement(SEARCH_GO_BUTTON).click();
        Logger.info("Search for: " + TEXT + " initiated");
        return new Iphone_SE_Page();
    }

    public StartPage sortFor(String KIND_OF_SORT) {
        WebElement dropdown = driver.findElement(SORT_OPTIONS_ALL);
        Select bank = new Select(dropdown);
        bank.selectByVisibleText(KIND_OF_SORT);
        Logger.info("Sorting by: " + KIND_OF_SORT);
        return new StartPage();
    }

    public String getFirstSearchResultPrice() {
        waitForElementClicable(FIRST_SEARCH_RESULT_NOT_SPONSORED);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FIRST_SEARCH_RESULT_NOT_SPONSORED));
        Highliter.highlightElementON(FIRST_SEARCH_RESULT_NOT_SPONSORED,driver);
        String all_text = driver.findElement(FIRST_SEARCH_RESULT_NOT_SPONSORED).getText();
        Logger.info(all_text);
        String all_text_splitted[] = all_text.split("\\$");
        Logger.info(all_text_splitted[1]);
        return all_text_splitted[1];
    }
    public String getFirstSearchResultRangeOfPrices() {
        waitForElementClicable(FIRST_SEARCH_RESULT_NOT_SPONSORED);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FIRST_SEARCH_RESULT_NOT_SPONSORED));
        Highliter.highlightElementON(FIRST_SEARCH_RESULT_NOT_SPONSORED,driver);
        driver.findElement(FIRST_SEARCH_RESULT_NOT_SPONSORED_LINK_TO_DP).click();
        String price =driver.findElement(FIRST_SEARCH_RESULT_PRICE).getText();
        Logger.info(price);
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
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
        Highliter.highlightElementON(TRENDING_DEALS_AREA, driver);
        Highliter.highlightElementOFF(TRENDING_DEALS_AREA, driver);
        List<WebElement> ALL_TREANDING_DEALS = new ArrayList<WebElement>();
        for (int i = 1; i < 100; i++) {
            By TRENDING_DEALS_EACH_ITEM = By.xpath("//div[@class='a-section a-spacing-none shogun-widget deals-shoveler aui-desktop fresh-shoveler']/div[2]/div/ul/li[" + i + "]");
            Logger.info("Trying to locate " + i + " element.");
            try {
                Highliter.highlightElementON(TRENDING_DEALS_EACH_ITEM, driver);
                Highliter.highlightElementOFF(TRENDING_DEALS_EACH_ITEM, driver);
            } catch (Exception e) {
                e.printStackTrace();
                Logger.info(i + " Element do not exist.");
                break;
            }
            ALL_TREANDING_DEALS.add(driver.findElement(TRENDING_DEALS_EACH_ITEM));
        }
        int NUMBER_OF_TRENDING_DEALS = ALL_TREANDING_DEALS.size();
        Logger.info("Number of all trenging deals is: " + ALL_TREANDING_DEALS.size());
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