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

    public void accessClicks() {
        clickByText("Cliques");
    }

    public void clickSwipe() {
        scrollDown();

        clickByText("Swipe");
    }

    public void clickSwipeList() {
        scrollDown();

        clickByText("Swipe List");
    }

    public void clickDragAndDrop() {
        scrollDown();

        clickByText("Drag and drop");
    }

    public void clickHibrido() {
        clickByText("SeuBarriga Híbrido");
    }

    public void clickSBNativo() {
        clickByText("SeuBarriga Nativo");
    }
}
