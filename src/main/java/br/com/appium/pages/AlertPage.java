package br.com.appium.pages;

import br.com.appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {

    public void clicarAlertConfirm() {
        clicarPorTexto("ALERTA CONFIRM");
    }

    public String obterTituloAlert() {
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlert() {
        return obterTexto(By.id("android:id/message"));

    }

    public void confirmAlert() {
        clicarPorTexto("CONFIRMAR");
    }

    public void sair() {
        clicarPorTexto("SAIR");
    }
}
