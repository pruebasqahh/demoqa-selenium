package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.BookStorePage;

public class DemoqaBookStoreTest extends BaseTest {
    @Test
    public void buscarLibroYValidarFiltro() {
        driver.get("https://demoqa.com/");
        HomePage homePage = new HomePage(driver);
        BookStorePage bookStorePage = new BookStorePage(driver);

        homePage.irABookStoreApplication();
        bookStorePage.buscarLibro("Git Pocket Guide");

        int resultados = bookStorePage.contarResultadosVisibles();
        Assert.assertEquals(resultados, 1, "Se esperaba solo un resultado en la tabla.");
    }
}
