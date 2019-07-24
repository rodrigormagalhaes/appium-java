package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.AbasPage;
import br.com.appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AbasPage abasPage = new AbasPage();

     @Test
     public void deveInteragirComAbas() {
         //acessar menu abas
         menuPage.acessarAbas();

         //verificar que está na aba 1
         Assert.assertTrue(abasPage.isAba1());

         //clicar na aba 2
         abasPage.selecionarAba2();

         //verificar que está na aba 2
         Assert.assertTrue(abasPage.isAba2());
     }
}