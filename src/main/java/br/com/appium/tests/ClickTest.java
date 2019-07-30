package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.ClicksPage;
import br.com.appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClickTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private ClicksPage page = new ClicksPage();

    @Before
    public void setUp() {
        menu.accessClicks();
    }

    @Test
    public void shouldRealizeLongClick() {
        page.longClick();

        Assert.assertEquals("Clique Longo", page.getText());
    }

    @Test
    public void shouldRealizeDoubleClick() {
        page.clickByText("Clique duplo");
        page.clickByText("Clique duplo");

        Assert.assertEquals("Duplo Clique", page.getText());
    }

}
