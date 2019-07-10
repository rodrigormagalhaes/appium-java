package br.com.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraTeste {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("plus");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
        el6.click();

        driver.quit();
    }
}
