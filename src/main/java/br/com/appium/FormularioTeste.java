package br.com.appium;

import br.com.appium.core.DSL;
import br.com.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.junit.Assert.*;


public class FormularioTeste {

    private DSL dsl = new DSL();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        dsl.clicarPorTexto("Formulário");
    }

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        dsl.escrever(MobileBy.AccessibilityId("nome"), "Rodrigo Magalhães");
        assertEquals("Rodrigo Magalhães", dsl.obterText(MobileBy.AccessibilityId("nome")));
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
        assertEquals("Nintendo Switch",  dsl.obterText(By.xpath("//android.widget.Spinner/android.widget.TextView")));
    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {
        assertFalse(dsl.isChecked(By.className("android.widget.CheckBox")));
        assertTrue(dsl.isChecked(MobileBy.AccessibilityId("switch")));

        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(MobileBy.AccessibilityId("switch"));

        assertTrue(dsl.isChecked(By.className("android.widget.CheckBox")));
        assertFalse(dsl.isChecked(MobileBy.AccessibilityId("switch")));
    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {
        //Preencher campos
        dsl.escrever(MobileBy.AccessibilityId("nome"), "Rodrigo Magalhães");
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(MobileBy.AccessibilityId("switch"));
        dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");

        //Salvar
        dsl.clicarPorTexto("SALVAR");

        //Verificações
        assertEquals("Nome: Rodrigo Magalhães", dsl.obterText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]")));

        assertEquals("Console: switch", dsl.obterText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));

        assertTrue(dsl.obterText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));

        assertTrue(dsl.obterText(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).endsWith("Marcado"));
    }

    @After
    public void tearDown() {
        DriverFactory.killDriver();
    }

}
