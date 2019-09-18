package br.com.appium.pages.seuBarriga;

import br.com.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static br.com.appium.core.DriverFactory.getDriver;

public class SBSummaryPage extends BasePage {

    public void deleteMovement(String desc) {
        MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+ desc +"']/.."));

        swipeElement(el, 0.9, 0.1);

        clickByText("Del");
    }

    public void clickUpdate() {
        clickByText("ATUALIZAR");
    }

}
