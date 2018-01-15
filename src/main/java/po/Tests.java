package po;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Tests {
    //  *   *   *   *   *   PA-1: Search    *   *   *   *   *   START   *   *   *

    /**
     *
     */
    @Test(description = "https://jira.lgi.io/browse/ONEMT-10 \"Search for 2 words\"", priority = 888)
    @Feature("PA-1: Search")
    @Story("https://jira.lgi.io/browse/ONEMUI-1 \"Implement search functionality\"")
    @Severity(SeverityLevel.BLOCKER)
    public void searchTest2Words() {
        StartPage startPage = new StartPage();
        String ITEM = "Iphone SE";
        Assert.assertEquals(startPage.open().searchForText_1(ITEM).getFirstSearchResultRangeOfPrices(), "$329.95");
    }
    //  *   *   *   *   *   PA-1: Search    *   *   *   *   *   END     *   *   *
    //  *   *   *   *   *   PA-1: TrendingDealsArea *   *   *   START   *   *   *

    /**
     * TrendingDealsArea consist of:
     * 15 items on StartPage
     */
    @Test(description = "https://jira.lgi.io/browse/ONEMT-310 \"Trending deals on page ...\"", priority = 5)
    @Feature("PA-1: Search")
    @Story("https://jira.lgi.io/browse/ONEMUI-3 \"Implement Trending Deals Area with 15 items\"")
    @Severity(SeverityLevel.MINOR)
    public void trendingDealsTest() {
        StartPage startPage = new StartPage();
        Assert.assertEquals(startPage.open().getNumberOfTrengingDeals(), 15);
    }

    //  *   *   *   *   *   PA-1: TrendingDealsArea *   *   *   END     *   *   *
    //  *   *   *   *   *   PA-2: Sorting   *   *   *   *   *   START   *   *   *
    String ITEM = "dr martens 1460 women";
    String SHEET_NAME = "SortBy";

    /**
     * Types of Sorting (KIND_OF_SORT): (0)
     * Default:Relevance (1)
     * Price: Low to High (2)
     * Price: High to Low (3)
     * Avg. Customer Review (4)
     * Newest Arrivals (5)
     */
    @Test(description = "https://jira.lgi.io/browse/ONEMT-210 \"Sort for Default:Relevance (1)\"", priority = 0)
    @Feature("PA-2: Sorting")
    @Story("https://jira.lgi.io/browse/ONEMUI-2 \"Implement sorting functionality\"")
    @Severity(SeverityLevel.CRITICAL)
    public void searchTestDefaultRelevance() {
        int INDEX = 1;
        StartPage startPage = new StartPage();
        String ITEM = "dr martens 1460 women";
        Assert.assertEquals(startPage.open().searchForText(ITEM)
                        .getFirstSearchResultRangeOfPricesDefault(),
                startPage.openSearchForTextAndSort(ITEM, SHEET_NAME, INDEX)
                        .getFirstSearchResultRangeOfPrices(SHEET_NAME, INDEX));
    }

    @Test(description = "https://jira.lgi.io/browse/ONEMT-211 \"Sort for Price: Low to High (2)\"", priority = 1)
    @Feature("PA-2: Sorting")
    @Story("https://jira.lgi.io/browse/ONEMUI-2 \"Implement sorting functionality\"")
    @Severity(SeverityLevel.CRITICAL)
    public void sortTestPriceLowToHigh() {
        int INDEX = 2;
        StartPage startPage = new StartPage();
        Assert.assertEquals(startPage
                .openSearchForTextAndSort(ITEM, SHEET_NAME, INDEX)
                .getFirstSearchResultRangeOfPrices(SHEET_NAME, INDEX), "$92.00 - $252.75");
    }

    @Test(description = "https://jira.lgi.io/browse/ONEMT-212 \"Sort for Price: High to Low (3)\"", priority = 2)
    @Feature("PA-2: Sorting")
    @Story("https://jira.lgi.io/browse/ONEMUI-2 \"Implement sorting functionality\"")
    @Severity(SeverityLevel.CRITICAL)
    public void sortTestPriceHighToLow() {
        int INDEX = 3;
        StartPage startPage = new StartPage();
        Assert.assertEquals(startPage
                .openSearchForTextAndSort(ITEM, SHEET_NAME, INDEX)
                .getFirstSearchResultPrice(SHEET_NAME, INDEX), "658.63");
    }

    @Test(description = "https://jira.lgi.io/browse/ONEMT-213 \"Sort for Avg. Customer Review (4)\"", priority = 3)
    @Feature("PA-2: Sorting")
    @Story("https://jira.lgi.io/browse/ONEMUI-2 \"Implement sorting functionality\"")
    @Severity(SeverityLevel.CRITICAL)
    public void sortTestAvgCustomerReview() {
        int INDEX = 4;
        StartPage startPage = new StartPage();
        Assert.assertEquals(startPage
                .openSearchForTextAndSort(ITEM, SHEET_NAME, INDEX)
                .getFirstSearchResultRangeOfPrices(SHEET_NAME, INDEX), "$85.99 - $155.00");
    }

    @Test(description = "https://jira.lgi.io/browse/ONEMT-212 \"Sort for Newest Arrivals (5)\"", priority = 4)
    @Feature("PA-2: Sorting")
    @Story("https://jira.lgi.io/browse/ONEMUI-2 \"Implement sorting functionality\"")
    @Severity(SeverityLevel.CRITICAL)
    public void sortTestNewestArrivals() {
        int INDEX = 5;
        StartPage startPage = new StartPage();
        Assert.assertEquals(startPage
                .openSearchForTextAndSort(ITEM, SHEET_NAME, INDEX)
                .getFirstSearchResultPrice(SHEET_NAME, INDEX), " 164 99");
    }
    //  *   *   *   *   *   PA-2: Sorting   *   *   *   *   *   END   *   *   *

    /**
     *
     */
    @Test(description = "https://jira.lgi.io/browse/ONEMT-020 \"Trending deals on page ...\"", priority = 999)
    public void departmentsDropDownListTest() {
        StartPage startPage = new StartPage();
        startPage.open().clickDepartmentsDropDownList();
        //Assert.assertEquals();
    }

    @Test(description = "https://jira.lgi.io/browse/ONEMT-020 \"Trending deals on page ...\"", priority = 999)
    public void allDropDownListTest() {
        StartPage startPage = new StartPage();
        startPage.open().clickAllDropDownList();
        //Assert.assertEquals();
    }

    //    @Test(description = "null", priority = 0)
//    public void testNotValidPassword() {
//        StartPage startPage = new StartPage()
//                .open()
//                .login(USERNAME, "123");
//        Iphone_SE_Page homepage = new Iphone_SE_Page();
//        Assert.assertFalse(homepage.isUsedIconVisible());
//    }
//
//    @Test(description = "null", priority = 0)
//    public void testNotValidUername() {
//        StartPage startPage = new StartPage()
//                .open()
//                .login("123", CORRECT_PASSWORD);
//        Iphone_SE_Page homepage = new Iphone_SE_Page();
//        Assert.assertTrue(homepage.isUsedIconVisible());
//    }
//                .login(USERNAME, CORRECT_PASSWORD);
//        Iphone_SE_Page homepage = new Iphone_SE_Page();
//        Assert.assertTrue(homepage.isUsedIconVisible());
//    public final String USERNAME = "shorc@tut.by";//TODO: Level 2: Вынести переменные в xlsx документ отдельный
//    public final String CORRECT_PASSWORD = "q1234567";
//    public final String NOT_CORRECT_PASSWORD = "123";//TODO: Lavel 1: Вынести переменную в txt документ отдельный
    @AfterClass
    public void kill() {
        WebDriverSingleton.kill();
    }
}