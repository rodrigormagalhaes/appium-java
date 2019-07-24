package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import br.com.appium.pages.SplashPage;
import org.junit.Test;

import static org.junit.Assert.*;

public class SplashTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage splashPage = new SplashPage();

    @Test
    public void shouldWaitSplashBecomeInvisible() {
        menu.clickSplash();

        //verifica que splash está visível
        splashPage.isScreenSplashVisibel();

        //aguarda saída do splash
        splashPage.waitSplashBecomeInvisible();

        //verificar que o form está aparecendo
        assertTrue(splashPage.existElementByText("Formulário"));
    }
}
