package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import br.com.appium.pages.SplashPage;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SplashTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage splashPage = new SplashPage();

    @Test
    public void deveAguardarSplashDesaparecer() {
        menu.acessarSplash();

        //verifica que splash está visível
        splashPage.isTelaSplashVisivel();

        //aguarda saída do splash
        splashPage.aguardarSplashDesaparecer();

        //verificar que o form está aparecendo
        assertTrue(splashPage.existeElementoPorTexto("Formulário"));
    }
}
