package br.com.appium.pages;

import br.com.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static br.com.appium.core.DriverFactory.getDriver;

public class SplashPage extends BasePage {

    public boolean isScreenSplashVisibel() {
        return existElementByText("Splash!");
    }

    public void waitSplashBecomeInvisible() {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
    }
}
