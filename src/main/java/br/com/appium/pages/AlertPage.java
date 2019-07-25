package br.com.appium.pages;

import br.com.appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {

    public void clickConfirmAlert() {
        clickByText("ALERTA CONFIRM");
    }

    public String getAlertTitle() {
        return getText(By.id("android:id/alertTitle"));
    }

    public String getAlertMsg() {
        return getText(By.id("android:id/message"));
    }

    public void confirmAlert() {
        clickByText("CONFIRMAR");
    }

    public void exit() {
        clickByText("SAIR");
    }

    public void clickSimpleAlert() {
        clickByText("ALERTA SIMPLES");
    }

    public void clickOutBox() {
        tap(100, 150);
    }
}
