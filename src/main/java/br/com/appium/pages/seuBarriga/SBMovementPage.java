package br.com.appium.pages.seuBarriga;

import br.com.appium.core.BasePage;
import org.openqa.selenium.By;

public class SBMovementPage extends BasePage {

    public void save() {
        clickByText("SALVAR");
    }

    public void setDescription(String desc) {
        sendKeys(By.className("android.widget.EditText"), desc);
    }

    public void setInterested(String interested) {
        sendKeys(By.xpath("//android.widget.EditText[2]"), interested);
    }

    public void setValue(String value) {
        sendKeys(By.xpath("//android.widget.EditText[3]"), value);
    }

    public void setAccount(String account) {
        selectCombo(By.xpath("//android.widget.Spinner[2]"), account);
    }
}
