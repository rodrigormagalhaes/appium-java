package br.com.appium.pages.seuBarriga;

import br.com.appium.core.BasePage;
import org.openqa.selenium.By;

public class SBLoginPage extends BasePage {

    public void setEmail(String email) {
        sendKeys(By.className("android.widget.EditText"), email);
    }

    public void setPassword(String pwd) {
        sendKeys(By.xpath("//android.widget.EditText[2]"), pwd);

    }

    public void logIn() {
        clickByText("ENTRAR");
    }

    public void doLogin(String email, String pwd) {
        setEmail(email);
        setPassword(pwd);
        logIn();
    }
}
