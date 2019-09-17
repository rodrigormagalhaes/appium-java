package br.com.appium.pages.seuBarriga;

import br.com.appium.core.BasePage;

public class SBMenuPage extends BasePage {

    public void clickAccounts() {
        clickByText("CONTAS");
    }

    public void clickMovement() {
        clickByText("MOV...");
    }
}
