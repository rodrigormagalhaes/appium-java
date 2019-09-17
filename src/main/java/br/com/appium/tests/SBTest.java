package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.MenuPage;
import br.com.appium.pages.seuBarriga.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SBTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SBLoginPage login = new SBLoginPage();
    private SBMenuPage sbMenu = new SBMenuPage();
    private SBAccountsPage account = new SBAccountsPage();
    private SBMovementPage sbMovementPage = new SBMovementPage();
    private SBHomePage sbHomePage = new SBHomePage();

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

    @Test
    public void shouldValidateInclusionMove() {
        sbMenu.clickMovement();

        sbMovementPage.save();
        assertTrue(sbMovementPage.existElementByText("Descrição é um campo obrigatório"));

        sbMovementPage.setDescription("Desc");
        sbMovementPage.save();
        assertTrue(sbMovementPage.existElementByText("Interessado é um campo obrigatório"));

        sbMovementPage.setInterested("Interessado");
        sbMovementPage.save();
        assertTrue(sbMovementPage.existElementByText("Valor é um campo obrigatório"));

        sbMovementPage.setValue("123");
        sbMovementPage.save();
        assertTrue(sbMovementPage.existElementByText("Conta é um campo obrigatório"));

        sbMovementPage.setAccount("Conta para alterar");
        sbMovementPage.save();
        assertTrue(sbMovementPage.existElementByText("Movimentação cadastrada com sucesso"));
    }

    @Test
    public void shouldUpdateBalanceWhenDeletingTransaction() {
        assertEquals("534.00", sbHomePage.getAccountBalance("Conta para saldo"));

    }

}
