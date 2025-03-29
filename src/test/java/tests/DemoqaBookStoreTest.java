package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import factory.PageFactoryManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookStorePage;
import pages.HomePage;
import utils.ExtentLogger;
import utils.ExtentReportManager;

public class DemoqaBookStoreTest extends BaseTest {

    ExtentReports report = ExtentReportManager.getInstance();

    @Test
    public void buscarLibroYValidarFiltro() {
        ExtentTest test = report.createTest("Buscar 'Git Pocket Guide' en Book Store y validar que solo aparezca un resultado");

        try {
            driver.get("https://demoqa.com/");
            ExtentLogger.info(test, driver, "Página inicial cargada", "paginaInicial");

            PageFactoryManager factory = new PageFactoryManager(driver);
            HomePage homePage = factory.getHomePage();
            BookStorePage bookStorePage = factory.getBookStorePage();

            homePage.irABookStoreApplication();
            ExtentLogger.info(test, driver, "Ingresar a Book Store Application", "bookStore");

            bookStorePage.buscarLibro("Git Pocket Guide");
            ExtentLogger.info(test, driver, "Buscar 'Git Pocket Guide'", "busqueda");

            int resultados = bookStorePage.contarResultadosVisibles();
            ExtentLogger.info(test, driver, "Resultados visibles: " + resultados, "resultados");

            Assert.assertEquals(resultados, 1);

            ExtentLogger.pass(test, driver, "Validación exitosa: se encontró un resultado", "validacion");

        } catch (AssertionError | Exception e) {
            ExtentLogger.fail(test, driver, "Fallo en la validación del número de resultados", "fallo");
            throw e;
        }
    }
}
