package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import br.com.appium.pages.seuBarriga.SBAccountsPage;
import br.com.appium.pages.seuBarriga.SBLoginPage;
import br.com.appium.pages.seuBarriga.SBMenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SBTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBLoginPage login = new SBLoginPage();
    private SBMenuPage sbMenu = new SBMenuPage();
    private SBAccountsPage account = new SBAccountsPage();

    @Before
    public void setUp() {
        menu.clickSBNativo();
        login.doLogin("teste@teste.de", "123456");
    }

    @Test
    public void shouldCreateAccount() {
        sbMenu.clickAccounts();

        account.setAccount("Conta Teste");

        account.save();

        assertTrue(account.existElementByText("Conta adicionada com sucesso"));

    }

    @Test
    public void shouldDeleteAccount() {
        sbMenu.clickAccounts();

        account.selectAccount("Conta Teste");

        account.deleteAccount();

        assertTrue(account.existElementByText("Conta excluída com sucesso"));

    }



}
