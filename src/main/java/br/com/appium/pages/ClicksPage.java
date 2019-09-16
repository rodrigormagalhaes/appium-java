package br.com.appium.pages;

import br.com.appium.core.BasePage;
import org.openqa.selenium.By;

import static br.com.appium.core.DriverFactory.getDriver;

public class ClicksPage extends BasePage {

    public void longClick() {

        longClick(By.xpath("//*[@text='Clique Longo']"));

    }

    public String getText() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
