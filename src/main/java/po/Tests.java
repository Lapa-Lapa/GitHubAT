package po;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Tests {

    public final String USERNAME = "shorc@tut.by";//TODO: Level 2: Вынести переменные в xlsx документ отдельный
    public final String CORRECT_PASSWORD = "q1234567";
    public final String NOT_CORRECT_PASSWORD = "123";//TODO: Lavel 1: Вынести переменную в txt документ отдельный

    @Test(description = "null", priority = 0)
    public void testPositive() {
        StartPage startPage = new StartPage();
        startPage.open()
                .login(USERNAME, CORRECT_PASSWORD);
        HomePage homepage = new HomePage();
        Assert.assertTrue(homepage.isUsedIconVisible());
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

    @AfterClass
    public void kill() {
        WebDriverSingleton.kill();
    }
}