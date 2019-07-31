package br.com.appium.pages;

import br.com.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

import java.util.List;

import static br.com.appium.core.DriverFactory.getDriver;

public class DragAndDropPage extends BasePage {

    public void drag(String begin, String end) {
        MobileElement begin_ = getDriver().findElement(By.xpath("//*[@text='"+ begin +"']"));
        MobileElement end_ = getDriver().findElement(By.xpath("//*[@text='"+ end +"']"));

        new TouchAction(getDriver())
                .longPress(begin_)
                .moveTo(end_)
                .release()
                .perform();

    }

    public String[] getList() {
        List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));

        String[] result = new String[elements.size()];

        for(int i =0; i < elements.size(); i++){
            result[i] = elements.get(i).getText();
            System.out.print("\"" + result[i] + "\", ");
        }

        return result;
    }
}
