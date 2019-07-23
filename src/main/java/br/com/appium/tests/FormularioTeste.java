package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.core.DriverFactory;
import br.com.appium.pages.FormularioPage;
import br.com.appium.pages.MenuPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class FormularioTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormularioPage form = new FormularioPage();

    @Before
    public void acessarFormulario() throws MalformedURLException {
        menu.acessarFormulario();
    }

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        form.escreverNome("Rodrigo Magalhães");
        assertEquals("Rodrigo Magalhães", form.obterNome());
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {
        form.selecionarCombo("Nintendo Switch");
        assertEquals("Nintendo Switch",  form.obterValorCombo());
    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {
        assertFalse(form.isChecked());
        assertTrue(form.isSwitchMarcado());

        form.clicarCheck();
        form.clicarSwitch();

        assertTrue(form.isChecked());
        assertFalse(form.isSwitchMarcado());
    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {
        form.escreverNome("Rodrigo Magalhães");
        form.clicarCheck();
        form.clicarSwitch();
        form.selecionarCombo("Nintendo Switch");

        form.salvar();

        assertEquals("Nome: Rodrigo Magalhães", form.obterNomeCadastrado());
        assertEquals("Console: switch", form.obterConsoleCadastrado());
        assertTrue(form.obterCheckCadastrado().endsWith("Marcado"));
        assertTrue(form.obterSwitchCadastrado().endsWith("Off"));
    }

    @Test
    public void deveRealizarCadastroDemorado() {
        form.escreverNome("Rodrigo");

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        form.salvarDemorado();

        //wait_(5000);

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Nome: Rodrigo']")));

        assertEquals("Nome: Rodrigo", form.obterNomeCadastrado());

    }



}
