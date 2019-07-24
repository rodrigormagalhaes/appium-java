package br.com.appium.pages;

import br.com.appium.core.BasePage;

public class TabsPage extends BasePage {

    public boolean isTab1 () {
        return existElementByText("Este é o conteúdo da Aba 1");
    }

    public boolean isTab2 () {
        return existElementByText("Este é o conteúdo da Aba 2");
    }

    public void selectTab2() {
        clickByText("ABA 2");
    }
}
