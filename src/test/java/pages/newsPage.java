package pages;

import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.*;
import Actions.actions;
import setUp.appiumSetUp;
import utility.NewsScreen;
import java.util.List;

public class newsPage extends appiumSetUp {
    private WebDriver driver;
    private actions userActions;

    public newsPage(actions userActions) {
        this.driver = getDriver();
        this.userActions = userActions;
    }


    public void validateNewsScreen() {
        userActions.waitForVisibility(By.xpath(NewsScreen.newsScreen), 10);
    }


    public void validateErrorMessageOnNewsScreen() {
        userActions.waitForVisibility(By.xpath(NewsScreen.newsScreen), 10);
        String errorMessage = driver.findElement(By.id(NewsScreen.errorMessage)).getText();
        Assert.assertEquals(errorMessage, "Failed to load news");
        driver.findElement(By.id(NewsScreen.retryBtn)).isDisplayed();
        userActions.enableInternetConnection();
    }


    public void navigateBack() {
        driver.navigate().back();
    }

    public void validateAndScrollImagesHorizontally() throws InterruptedException {
        userActions.waitForVisibility(By.xpath(NewsScreen.image), 15);
        List<MobileElement> listOfImages = driver.findElements(By.xpath(NewsScreen.image));
        // verifying if the imaged are displayed in the list
        if (listOfImages.size() > 0) {
            for (int i = 1; i <= listOfImages.size(); i++) {
                String ele = NewsScreen.image + "[" + i + "]";
                driver.findElement(By.xpath(ele)).isDisplayed();
            }
        } else {
            Assert.fail("list of images are not displayed");
        }

        userActions.swipeLeft();

    }

    public void tapOnNewsImage() {
        driver.findElement(By.xpath(NewsScreen.image)).click();
    }

    public void validateURLOpened() {
        userActions.waitForVisibility(By.xpath(NewsScreen.webUrl), 15);
    }

}
