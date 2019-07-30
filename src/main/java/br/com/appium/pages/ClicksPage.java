package br.com.appium.pages;

import br.com.appium.core.BasePage;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

import static br.com.appium.core.DriverFactory.getDriver;

public class ClicksPage extends BasePage {

    public void longClick() {
        new TouchAction(getDriver()).longPress(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
    }

    public String getText() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
