package po;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Tests {
    private String ITEM = "Iphone SE";

    @Test(description = "https://jira.lgi.io/browse/ONEMT-010 \"Search for ...\"", priority = 0)
    @Feature("PA-15: Search")
    @Story("https://jira.lgi.io/browse/ONEMUI-1 \"Implement search functionality\"")
    @Severity(SeverityLevel.BLOCKER)
    public void searchTest() {
        StartPage startPage = new StartPage();
        Assert.assertEquals(startPage.open().searchForText(ITEM).getFirstSearchResultPrice(ITEM), "$329.95");
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