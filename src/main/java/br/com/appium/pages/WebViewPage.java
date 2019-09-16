package br.com.appium.pages;

import org.openqa.selenium.By;

import java.util.Set;

import static br.com.appium.core.DriverFactory.getDriver;

public class WebViewPage {

    public void enterWebContext() {
        Set<String> contextHandles = getDriver().getContextHandles();

        for(String valor: contextHandles) {
            System.out.println(valor);
        }

        getDriver().context((String) contextHandles.toArray()[1]);

    }

    public void setEmail(String valor) {
        getDriver().findElement(By.id("email"));
    }
}
