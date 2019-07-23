package br.com.appium.core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static br.com.appium.core.DriverFactory.getDriver;

public class BasePage {
    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public void selecionarCombo(By by, String valor) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public void clicarPorTexto(String texto) {
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public boolean isChecked(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String name) {
        List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='"+ name +"']"));

        return elements.size() > 0;
    }
}
