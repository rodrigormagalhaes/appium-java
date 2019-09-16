package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import br.com.appium.pages.WebViewPage;
import org.junit.Test;

public class WebViewTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void shouldDoLogin() {
        menu.clickHibrido();

        wait_(3000);

        page.enterWebContext();

        //preencher email
        page.setEmail("teste@teste");




    }
}
