package utilities;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class DriverManager {

    private static IOSDriver driver;

    public static IOSDriver getDriver() {

        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();

                // Capabilities
                caps.setCapability("platformName", "iOS");
                caps.setCapability("platformVersion", "18.2"); // Версия iOS
                caps.setCapability("deviceName", "iPhone 16 Pro"); // Название симулятора
                caps.setCapability("automationName", "XCUITest");

                // Path to the app for simulator
                caps.setCapability("app", "/Users/apple/AquaProjects/Test_Project1/src/test/resources/app.app");

                // For real device:
                // caps.setCapability("udid", "DEVICE_UDID");
                // caps.setCapability("xcodeOrgId", "TEAM_ID");
                // caps.setCapability("xcodeSigningId", "iPhone Developer");

                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

}