package br.com.appium.pages;

import br.com.appium.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void selecionarOp1() {
        clicarPorTexto("Opção 1");
    }

    public String getValueOp1() {
        return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }

}
