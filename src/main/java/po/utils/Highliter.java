package po.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Highliter {

    public static void highlightElementON(By locator, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", driver.findElement(locator));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void highlightElementOFF(By locator, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", driver.findElement(locator));
    }
//    public static void highlightUnhighlightClickElement(By locator, WebDriver driver) {
//        waitForElementVisible(locator, driver);
//        waitForElementClicable(locator, driver);
//        highlightElement(locator, driver);
//        unHighlightElement(locator, driver);
//        driver.findElement(locator).click();
//    }
}