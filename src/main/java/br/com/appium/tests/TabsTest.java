package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.TabsPage;
import br.com.appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class TabsTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private TabsPage tabsPage = new TabsPage();

     @Test
     public void shouldInteractWithTabs() {
         //acessar menu abas
         menuPage.clickTabs();

         //verificar que está na aba 1
         Assert.assertTrue(tabsPage.isTab1());

         //clicar na aba 2
         tabsPage.selectTab2();

         //verificar que está na aba 2
         Assert.assertTrue(tabsPage.isTab2());
     }
}