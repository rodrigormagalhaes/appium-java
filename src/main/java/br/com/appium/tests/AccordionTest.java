package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.AccordionPage;
import br.com.appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AccordionPage accordionPage = new AccordionPage();

    @Test
    public void shouldInteractWithAccordion() {
        //acessar menu Accordion
        menuPage.clickAccordion();

        //clicar opção 1
        accordionPage.selectOp1();

        wait_(1000);
        //verificar texto opção 1
        Assert.assertEquals("Esta é a descrição da opção 1", accordionPage.getValueOp1());
    }
}
