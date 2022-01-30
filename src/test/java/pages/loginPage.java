package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Actions.actions;
import setUp.appiumSetUp;
import utility.LoginScreen;
import java.util.Objects;

public class loginPage extends appiumSetUp {
    private WebDriver driver;
    private actions userActions;


    public loginPage(actions userActions) {
        this.driver = getDriver();
        this.userActions = userActions;
    }

    public void verifyLoginScreen() {
        userActions.waitForVisibility(By.id(LoginScreen.loginPage), 15);
        userActions.waitForVisibility(By.id(LoginScreen.userNameTxtField), 10);
        driver.findElement(By.id(LoginScreen.passwordTxtField)).isDisplayed();
        driver.findElement(By.id(LoginScreen.loginBtn)).isDisplayed();
    }

    public void enterUserNamePassword(String userName, String password) {
        driver.findElement(By.id(LoginScreen.userNameTxtField)).sendKeys(userName);
        driver.findElement(By.id(LoginScreen.passwordTxtField)).sendKeys(password);
        ((AppiumDriver) driver).hideKeyboard();
    }

    public void toggleTheNetwork(String type) throws Exception {
        if (Objects.equals(type, "no internet")) {
            userActions.disableInternetConnection();
        }
    }

    public void loggedInSuccessfully() {
        driver.findElement(By.id(LoginScreen.userNameTxtField)).sendKeys("user1");
        driver.findElement(By.id(LoginScreen.passwordTxtField)).sendKeys("password");
        ((AppiumDriver) driver).hideKeyboard();
        driver.findElement(By.id(LoginScreen.loginBtn)).click();
    }

    public void clickLoginButton() {
        driver.findElement(By.id(LoginScreen.loginBtn)).click();
    }

    public void validateErrorForInvalidLogin() {
        userActions.waitForVisibility(By.id(LoginScreen.loginBtn), 15);
    }

}
