package br.com.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        click(By.xpath("//*[@text='" + text + "']"));
    }

    public void click(By by) {
        getDriver().findElement(by).click();
    }

    public boolean isChecked(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existElementByText(String name) {
        List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='" + name + "']"));

        return elements.size() > 0;
    }

    public void tap(int x, int y) {
        new TouchAction(getDriver()).tap(x, y).perform();

    }

    public void scrollDown() {
        scroll(0.9, 0.1);
    }

    public void scrollUp() {
        scroll(0.1, 0.9);
    }

    public void scroll(double start, double end) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

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

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }

    public void swipeRight() {
        swipe(0.9, 0.1);
    }

    public void swipe(double start, double end) {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2;

        int start_x = (int) (size.width * start);
        int end_x = (int) (size.width * end);

        new TouchAction(getDriver())
                .press(start_x, y)
                .waitAction(Duration.ofMillis(500))
                .moveTo(end_x, y)
                .release()
                .perform();
    }

    public void swipeElement(MobileElement element, double start, double end) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * start);
        int end_x = (int) (element.getSize().width * end);

        new TouchAction(getDriver())
                .press(start_x, y)
                .waitAction(Duration.ofMillis(500))
                .moveTo(end_x, y)
                .release()
                .perform();
    }

    public void longClick(By by) {
        new TouchAction(getDriver()).longPress(getDriver().findElement(by)).perform();
    }


}
