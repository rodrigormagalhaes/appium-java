package br.com.appium.pages;

import br.com.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

import static br.com.appium.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeElementLeft(String option) {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+ option +"']/..")), 0.1, 0.9);

    }

    public void swipeElementRight(String option) {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+ option +"']/..")), 0.9, 0.1);

    }

    public void clickButtonPlus() {
        MobileElement button = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));

        new TouchAction(getDriver()).tap(button, -50, 0).perform();

    }

}
