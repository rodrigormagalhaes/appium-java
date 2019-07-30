package br.com.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
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

    public void tap(int x, int y) {
        new TouchAction(getDriver()).tap(x,y).perform();

    }

    public void scroll(double start, double end) {
       Dimension size = getDriver().manage().window().getSize();

       int x = size.width / 2;

       int start_y = (int) (size.height * start);
       int end_y = (int) (size.height * end);

       new TouchAction(getDriver())
               .press(x, start_y)
               .waitAction(Duration.ofMillis(500))
               .moveTo(x, end_y)
               .release()
               .perform();
    }

    public String getAlertTitle() {
        return getText(By.id("android:id/alertTitle"));
    }

    public String getAlertMsg() {
        return getText(By.id("android:id/message"));
    }

}
