package br.com.appium.pages;

import br.com.appium.core.BasePage;

public class MenuPage extends BasePage {

    public void clickForm() {
       clickByText("Formulário");
    }

    public void clickSplash() {
        clickByText("Splash");
    }

    public void clickAlerts() {
        clickByText("Alertas");
    }

    public void clickTabs() {
        clickByText("Abas");
    }

    public void clickAccordion() {
        clickByText("Accordion");
    }
}
