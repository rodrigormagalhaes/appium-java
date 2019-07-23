package br.com.appium.pages;

import br.com.appium.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarFormulario() {
       clicarPorTexto("Formulário");
    }

    public void acessarSplash() {
        clicarPorTexto("Splash");
    }
}
