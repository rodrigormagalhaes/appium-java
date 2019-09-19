package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static br.com.appium.core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

public class SwipeTest extends BaseTest {

    MenuPage menuPage = new MenuPage();

    @Test
    public void shouldRealizeSwipe() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        //acessar menu
        menuPage.clickSwipe();

        //verificar texto 'a esquerda'
        assertTrue(menuPage.existElementByText("a esquerda"));

        //swipe direita
        menuPage.swipeRight();

        //verificar texto 'E veja se'
        assertTrue(menuPage.existElementByText("E veja se"));

        //clicar botão direito
        menuPage.clickByText("›");

        //verificar texto 'Chegar até o fim'
        assertTrue(menuPage.existElementByText("Chegar até o fim!"));

        //swipe esquerda
        menuPage.swipeLeft();

        //clicar botão esquerdo
        menuPage.clickByText("‹");

        //verificar texto 'a esquerda'
        assertTrue(menuPage.existElementByText("a esquerda"));


    }
}
