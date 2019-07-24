package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.AlertPage;
import br.com.appium.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AlertTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertPage alertPage = new AlertPage();

    @Test
    public void shouldConfirmAlert() {
        //acessa menu alerta
        menu.clickAlerts();

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
}