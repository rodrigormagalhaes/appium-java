package br.com.appium.pages.seuBarriga;

import br.com.appium.core.BasePage;
import org.openqa.selenium.By;

public class SBAccountsPage extends BasePage {

    public void setAccount(String name) {
        sendKeys(By.className("android.widget.EditText"), name);
    }

    public void save() {
        clickByText("SALVAR");
    }

    public void selectAccount(String account) {
        longClick(By.xpath("//*[@text='"+ account +"']"));
    }

    public void deleteAccount() {
        clickByText("EXCLUIR");
    }
}
