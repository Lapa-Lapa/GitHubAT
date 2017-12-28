package po;

import org.openqa.selenium.By;

public class HomePage extends AbstractPage {

    private static final By PROFILE = By.xpath("//*[@class='HeaderNavlink name']");

    public boolean isUsedIconVisible() {
        return isElementVisible(PROFILE);
    }


}
