package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.AlertPage;
import br.com.appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertPage alertPage = new AlertPage();

    @Before
    public void setUp() {
        //acessa menu alerta
        menu.clickAlerts();
    }

    @Test
    public void shouldConfirmAlert() {

        //clicar em alert confirm
        alertPage.clickConfirmAlert();

        //verificar os textos
        Assert.assertEquals("Info", alertPage.getAlertTitle());
        Assert.assertEquals("Confirma a operação?", alertPage.getAlertMsg());

        //confirmar alerta
        alertPage.confirmAlert();

        //verificar nova mensagem
        Assert.assertEquals("Confirmado", alertPage.getAlertMsg());

        //sair
        alertPage.exit();
    }

    @Test
    public void shouldClickOutAlert() {
        alertPage.clickSimpleAlert();

        wait_(1000);
        alertPage.clickOutBox();

        Assert.assertFalse(alertPage.existElementByText("Pode clicar no OK ou fora da caixa para sair"));
    }
}