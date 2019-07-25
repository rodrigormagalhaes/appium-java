package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.core.DriverFactory;
import br.com.appium.pages.FormPage;
import br.com.appium.pages.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class FormTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormPage form = new FormPage();

    @Before
    public void clickForm() throws MalformedURLException {
        menu.clickForm();
    }

    @Test
    public void shouldFillFieldText() throws MalformedURLException {
        form.writeName("Rodrigo Magalhães");
        assertEquals("Rodrigo Magalhães", form.getName());
    }

    @Test
    public void shouldInteractWithCombo() throws MalformedURLException {
        form.selectCombo("Nintendo Switch");
        assertEquals("Nintendo Switch",  form.getComboValue());
    }

    @Test
    public void shouldInteractWithSwitchCheckBox() throws MalformedURLException {
        assertFalse(form.isChecked());
        assertTrue(form.isSwitchChecked());

        form.clickCheck();
        form.clickSwitch();

        assertTrue(form.isChecked());
        assertFalse(form.isSwitchChecked());
    }

    @Test
    public void shouldRegister() throws MalformedURLException {
        form.writeName("Rodrigo Magalhães");
        form.clickCheck();
        form.clickSwitch();
        form.selectCombo("Nintendo Switch");

        form.save();

        assertEquals("Nome: Rodrigo Magalhães", form.getRegisteredName());
        assertEquals("Console: switch", form.getConsoleRegistered());
        assertTrue(form.getCheckRegistered().endsWith("Marcado"));
        assertTrue(form.getSwitchRegistered().endsWith("Off"));
    }

    @Test
    public void shouldRegisterSlow() {
        form.writeName("Rodrigo");

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        form.saveSlow();

        //wait_(5000);

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Nome: Rodrigo']")));

        assertEquals("Nome: Rodrigo", form.getRegisteredName());

    }

    @Test
    public void shouldChangeDate() {
        form.clickByText("01/01/2000");
        form.clickByText("20");
        form.clickByText("OK");
        assertTrue(form.existElementByText("20/2/2000"));
    }

    @Test
    public void shouldChangeHour() {
        form.clickByText("06:00");
        form.click(MobileBy.AccessibilityId("10"));
        form.click(MobileBy.AccessibilityId("40"));
        form.clickByText("OK");
        assertTrue(form.existElementByText("10:40"));
    }

    @Test
    public void shouldInteractWithSeekBar() {
        form.clickSeekBar(0.23);

        form.save();
    }
}
