package br.com.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormularioTeste {

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/rodrigo/workspace/appium-java/src/main/resources/CTAppium-1-1.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));

        elementosEncontrados.get(1).click();

        MobileElement elementoNome = driver.findElement(MobileBy.AccessibilityId("nome"));

        elementoNome.sendKeys("Rodrigo Magalhães");

        Assert.assertEquals("Rodrigo Magalhães",elementoNome.getText());

        driver.quit();
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/rodrigo/workspace/appium-java/src/main/resources/CTAppium-1-1.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

        driver.findElement(MobileBy.AccessibilityId("console")).click();

        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();

        Assert.assertEquals("Nintendo Switch", text);

        driver.quit();
    }
}
