package setUp;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class appiumSetUp {
    private static WebDriver driver = null;

    @Before
    public void setup() {

        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "11");
        //	capabilities.setCapability("deviceName", "Android Emulator"); // if using emulator
        capabilities.setCapability("udid", "8c388a0d");  //give your device id (real device connected to the system)
        capabilities.setCapability("platformName", "Android");
        String androidAppPath = System.getProperty("user.dir") + "/src/main/java/App/app-debug.apk";
        capabilities.setCapability("app", androidAppPath);
        capabilities.setCapability("noReset", true);

        try {
            driver = (AndroidDriver<MobileElement>) new AndroidDriver<MobileElement>(
                    new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void cleanUp() {
        driver.quit();
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.stop();

    }

}
