package br.com.appium.core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static br.com.appium.core.DriverFactory.getDriver;

public class BasePage {
    public void sendKeys(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public void selectCombo(By by, String value) {
        getDriver().findElement(by).click();
        clickByText(value);
    }

    public void clickByText(String text) {
        click(By.xpath("//*[@text='"+text+"']"));
    }

    public void click(By by) {
        getDriver().findElement(by).click();
    }

    public boolean isChecked(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean  existElementByText(String name) {
        List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='"+ name +"']"));

        return elements.size() > 0;
    }
}
