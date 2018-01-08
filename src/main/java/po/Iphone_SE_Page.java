package po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import po.utils.Highliter;
import po.utils.Logger;

public class Iphone_SE_Page extends AbstractPage {

    //private static final By PROFILE = By.xpath("//*[@class='HeaderNavlink name']");
    private static final By FIRST_SEARCH_RESULT = By.cssSelector("#result_0");
    private static final By FIRST_SEARCH_RESULT_DP = By.cssSelector("#result_0 a.s-access-detail-page");
    private static final By FIRST_SEARCH_RESULT_PRICE = By.cssSelector("#priceblock_ourprice");

//    public boolean isUsedIconVisible() {
//        return isElementVisible(PROFILE);
//    }

    public String getFirstSearchResultRangeOfPrices() {
        waitForElementClicable(FIRST_SEARCH_RESULT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(FIRST_SEARCH_RESULT));
        Highliter.highlightElementON(FIRST_SEARCH_RESULT, driver);
        String all_text = driver.findElement(FIRST_SEARCH_RESULT).getText();
        Logger.info(all_text);
        String all_text_splitted[] = all_text.split("\\$");
        Logger.info(all_text_splitted[1]);
        return all_text_splitted[1];
    }


}