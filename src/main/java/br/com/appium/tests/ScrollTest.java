package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.com.appium.core.DriverFactory.getDriver;

public class ScrollTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();

    @Test
    public void shouldFindHideOption() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        menuPage.scroll(0.9, 0.1);

        menuPage.clickByText("Opção bem escondida");

        Assert.assertEquals("Você achou essa opção", menuPage.getAlertMsg());

        menuPage.clickByText("OK");

    }
}
