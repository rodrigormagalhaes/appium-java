package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ScrollTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();

    @Test
    public void shouldFindHideOption() {
        menuPage.scrollDown();

        menuPage.clickByText("Opção bem escondida");

        Assert.assertEquals("Você achou essa opção", menuPage.getAlertMsg());

        menuPage.clickByText("OK");

    }
}
