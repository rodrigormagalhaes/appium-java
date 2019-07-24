package br.com.appium.pages;

import br.com.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;


public class FormPage extends BasePage {

    public void writeName(String name) {
        sendKeys(MobileBy.AccessibilityId("nome"), name);
    }

    public String getName() {
        return getText(MobileBy.AccessibilityId("nome"));
    }

    public void selectCombo(String value) {
        selectCombo(MobileBy.AccessibilityId("console"), value);
    }

    public String getComboValue(){
        return getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clickCheck() {
        click(By.className("android.widget.CheckBox"));
    }

    public void clickSwitch() {
        click(MobileBy.AccessibilityId("switch"));
    }

    public boolean isChecked() {
        return isChecked(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchChecked() {
        return isChecked(MobileBy.AccessibilityId("switch"));
    }

    public void save() {
        clickByText("SALVAR");
    }

    public void saveSlow() {
        clickByText("SALVAR DEMORADO");
    }

    public String getRegisteredName() {
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String getConsoleRegistered() {
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String getCheckRegistered() {
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }

    public String getSwitchRegistered() {
        return getText(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));

    }
}