package br.com.appium.pages;

import br.com.appium.core.DSL;

public class MenuPage {

    private DSL dsl = new DSL();

    public void acessarFormulario() {
        dsl.clicarPorTexto("Formulário");

    }
}
