package po;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Tests {
    //  *   *   *   *   *   PA-1: Search    *   *   *   *   *
    @Test(description = "https://jira.lgi.io/browse/ONEMT-10 \"Search for 2 words\"", priority = 0)
    @Feature("PA-1: Search")
    @Story("https://jira.lgi.io/browse/ONEMUI-1 \"Implement search functionality\"")
    @Severity(SeverityLevel.BLOCKER)
    public void searchTest2Words() {
        StartPage startPage = new StartPage();
        String ITEM = "Iphone SE";
        Assert.assertEquals(startPage.open().searchForText(ITEM).getFirstSearchResultPrice(ITEM), "$329.95");
    }

    @Test(description = "https://jira.lgi.io/browse/ONEMT-11 \"Search for 3 words and number\"", priority = 0)
    @Feature("PA-1: Search")
    @Story("https://jira.lgi.io/browse/ONEMUI-1 \"Implement search functionality\"")
    @Severity(SeverityLevel.CRITICAL)
    public void searchTest3WordsAndNumber() {
        StartPage startPage = new StartPage();
        String ITEM = "dr martens 1460 women";
        Assert.assertEquals(startPage.open().searchForText(ITEM).getFirstSearchResultPrice(ITEM), "$140.00");
    }
    //  *   *   *   *   *   PA-2: Sorting   *   *   *   *   *

    /**
     * Types of Sorting:
     * Default:Relevance(0)
     * Price: Low to High (1)
     * Price: High to Low (2)
     * Avg. Customer Review (3)
     * Newest Arrivals (4)
     */

    //@Test(description = "https://jira.lgi.io/browse/ONEMT-200 \"Sort for Price: Low to High\"", priority = 0)
    //TODO:На основании ONEMT-10

    @Test(description = "https://jira.lgi.io/browse/ONEMT-211 \"Sort for Price: Low to High\"", priority = 0)
    @Feature("PA-2: Sorting")
    @Story("https://jira.lgi.io/browse/ONEMUI-2 \"Implement sorting functionality\"")
    @Severity(SeverityLevel.CRITICAL)
    public void sortTestPriceLowToHigh() {
        StartPage startPage = new StartPage();
        String ITEM = "dr martens 1460 women";
        Assert.assertEquals(startPage.open().searchForText(ITEM).sortFor("Price: Low to High").getFirstSearchResultPrice(ITEM), "$140.00");
    }

    @Test(description = "https://jira.lgi.io/browse/ONEMT-211 \"Sort for Price: Low to High\"", priority = 0)
    @Feature("PA-2: Sorting")
    @Story("https://jira.lgi.io/browse/ONEMUI-2 \"Implement sorting functionality\"")
    @Severity(SeverityLevel.CRITICAL)
    public void sortTestPriceHighToLow() {
        StartPage startPage = new StartPage();
        String ITEM = "dr martens 1460 women";
        Assert.assertEquals(startPage.open().searchForText(ITEM).sortFor("Price: High to Low").getFirstSearchResultPrice(ITEM), "$140.00");
    }


    @Test(description = "https://jira.lgi.io/browse/ONEMT-020 \"Trending deals on page ...\"", priority = 0)
    public void departmentsDropDownListTest() {
        StartPage startPage = new StartPage();
        startPage.open().clickDepartmentsDropDownList();
        //Assert.assertEquals();
    }

    @Test(description = "https://jira.lgi.io/browse/ONEMT-020 \"Trending deals on page ...\"", priority = 0)
    public void allDropDownListTest() {
        StartPage startPage = new StartPage();
        startPage.open().clickAllDropDownList();
        //Assert.assertEquals();
    }

    @Test(description = "https://jira.lgi.io/browse/ONEMT-020 \"Trending deals on page ...\"", priority = 0)
    public void trendingDealsTest() {
        StartPage startPage = new StartPage();
        Assert.assertEquals(startPage.open().getNumberOfTrengingDeals(), 15);
    }

//    @Test(description = "null", priority = 0)
//    public void testNotValidPassword() {
//        StartPage startPage = new StartPage()
//                .open()
//                .login(USERNAME, "123");
//        HomePage homepage = new HomePage();
//        Assert.assertFalse(homepage.isUsedIconVisible());
//    }
//
//    @Test(description = "null", priority = 0)
//    public void testNotValidUername() {
//        StartPage startPage = new StartPage()
//                .open()
//                .login("123", CORRECT_PASSWORD);
//        HomePage homepage = new HomePage();
//        Assert.assertTrue(homepage.isUsedIconVisible());
//    }
//                .login(USERNAME, CORRECT_PASSWORD);
//        HomePage homepage = new HomePage();
//        Assert.assertTrue(homepage.isUsedIconVisible());

//    public final String USERNAME = "shorc@tut.by";//TODO: Level 2: Вынести переменные в xlsx документ отдельный
//    public final String CORRECT_PASSWORD = "q1234567";
//    public final String NOT_CORRECT_PASSWORD = "123";//TODO: Lavel 1: Вынести переменную в txt документ отдельный

    @AfterClass
    public void kill() {
        WebDriverSingleton.kill();
    }
}