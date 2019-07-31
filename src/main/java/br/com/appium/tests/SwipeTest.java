package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SwipeTest extends BaseTest {

    MenuPage menuPage = new MenuPage();

    @Test
    public void shouldRealizeSwipe() {
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
