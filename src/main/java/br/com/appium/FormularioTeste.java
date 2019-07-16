package br.com.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class FormularioTeste {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void inicializarAppium() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/rodrigo/workspace/appium-java/src/main/resources/CTAppium-1-1.apk");

        driver = new AndroidDriver<MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selecionar formulário
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();

    }

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));

        elementosEncontrados.get(1).click();

        MobileElement elementoNome = driver.findElement(MobileBy.AccessibilityId("nome"));

        elementoNome.sendKeys("Rodrigo Magalhães");

        Assert.assertEquals("Rodrigo Magalhães",elementoNome.getText());
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();

        Assert.assertEquals("Nintendo Switch", text);
    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {
        MobileElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
        MobileElement switchEl = driver.findElement(MobileBy.AccessibilityId("switch"));

        Assert.assertTrue(checkBox.getAttribute("checked").equals("false"));
        Assert.assertTrue(switchEl.getAttribute("checked").equals("true"));

        checkBox.click();
        switchEl.click();

        Assert.assertFalse(checkBox.getAttribute("checked").equals("false"));
        Assert.assertFalse(switchEl.getAttribute("checked").equals("true"));
    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {
        //Preencher campos
        driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Rodrigo Magalhães");
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(MobileBy.AccessibilityId("switch")).click();
        driver.findElement(By.className("android.widget.Spinner")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //Salvar
        driver.findElement(MobileBy.AccessibilityId("save")).click();

        //Verificações
        Assert.assertEquals("Nome: Rodrigo Magalhães",
                driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]")).getText());

        Assert.assertEquals("Console: switch",
                driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")).getText());

        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).getText()
                .endsWith("Off"));

        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).getText()
                .endsWith("Marcado"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
