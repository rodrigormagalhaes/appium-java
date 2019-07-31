package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import br.com.appium.pages.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwipeElementsTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SwipeListPage swipeListPage = new SwipeListPage();

    @Test
    public void shoudInteractWithSwipeList() {
        //clicar swipe list
        menuPage.clickSwipeList();

        //op1 para direita
        swipeListPage.swipeElementRight("Opção 1");

        //op1 +
        swipeListPage.clickButtonPlus();

        //verificar op1
        assertTrue(menuPage.existElementByText("Opção 1 (+)"));

        //op4 direita
        swipeListPage.swipeElementRight("Opção 4");

        //op4 -
        menuPage.clickByText("(-)");

        //verificar op4 -
        assertTrue(menuPage.existElementByText("Opção 4 (-)"));

        //op5 esquerda
        swipeListPage.swipeElementLeft("Opção 5 (-)");

        //verificar op4 -
        assertTrue(menuPage.existElementByText("Opção 5"));

    }
}
