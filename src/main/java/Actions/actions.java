package Actions;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setUp.appiumSetUp;

public class actions extends appiumSetUp {

    @SuppressWarnings("rawtypes")
    PointOption pointOption = new PointOption();
    private WebDriver driver;

    public actions() {

        this.driver = getDriver();
    }

    public void swipeLeft() {
        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = driver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
        // execute swipe using TouchAction
        try {
            new TouchAction((PerformsTouchActions) driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public WebDriverWait waitUntilVisible(WebDriver driver, long timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    public void disableInternetConnection() {
        ((AndroidDriver<WebElement>) driver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
    }

    public void enableInternetConnection() {
        ((AndroidDriver<WebElement>) driver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
    }


    public void swipe(int startX, int startY, int endX, int endY) throws InterruptedException {

        TouchAction t = new TouchAction((AndroidDriver<WebElement>) driver);
        t.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
    }

    public void waitForVisibility(By e, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }
}
