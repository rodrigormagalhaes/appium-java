package br.com.appium.tests;

import br.com.appium.core.BaseTest;
import br.com.appium.pages.DragAndDropPage;
import br.com.appium.pages.MenuPage;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DragAndDropTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private DragAndDropPage page = new DragAndDropPage();

    private String[] initialStatus = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private String[] intermediateStatus = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
    private String[] finalStatus = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    @Test
    public void shoudDoDragAndDrop() {
        //acessar menu
        menu.clickDragAndDrop();

        //verificar estado inicial
        wait_(1000);
        assertArrayEquals(initialStatus, page.getList());

        //arrastar "Esta" para "e arraste para"
        page.drag("Esta",  "e arraste para");

        //verificar estado intermediário
        assertArrayEquals(intermediateStatus, page.getList());

        page.drag("Faça um clique longo,",  "é uma lista");

        assertArrayEquals(finalStatus, page.getList());

    }
}
