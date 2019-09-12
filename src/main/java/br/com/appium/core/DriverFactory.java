package br.com.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/usertqi/workspace/appium-java/src/main/resources/CTAppium-1-1.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/rodrigo/workspace/appium-java/src/main/resources/CTAppium-1-1.apk");

        try {
            driver = new AndroidDriver<MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void killDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
