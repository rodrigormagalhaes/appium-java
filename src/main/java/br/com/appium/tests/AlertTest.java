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
    public void deveConfirmarAlerta() {
        //acessa menu alerta
        menu.acessarAlertas();

        //clicar em alert confirm
        alertPage.clicarAlertConfirm();

        //verificar os textos
        Assert.assertEquals("Info", alertPage.obterTituloAlert());
        Assert.assertEquals("Confirma a operação?", alertPage.obterMensagemAlert());

        //confirmar alerta
        alertPage.confirmAlert();

        //verificar nova mensagem
        Assert.assertEquals("Confirmado", alertPage.obterMensagemAlert());

        //sair
        alertPage.sair();
    }
}