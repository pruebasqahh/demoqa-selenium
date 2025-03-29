package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import factory.PageFactoryManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ExtentLogger;
import utils.ExtentReportManager;

public class DemoqaTest extends BaseTest {

    ExtentReports report = ExtentReportManager.getInstance();

    @Test
    public void validarTextoEnDemoqa() {
        ExtentTest test = report.createTest("Validar texto en la página principal de DemoQA");

        try {
            driver.get("https://demoqa.com/");
            ExtentLogger.info(test, driver, "Página inicial cargada", "paginaInicial");

            PageFactoryManager factory = new PageFactoryManager(driver);
            HomePage homePage = factory.getHomePage();

            String textoFooter = homePage.obtenerTextoFooter();
            ExtentLogger.info(test, driver, "Texto del footer obtenido: " + textoFooter, "footer");

            Assert.assertTrue(
                    textoFooter.contains("2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.")
            );

            ExtentLogger.pass(test, driver, "Validación exitosa del texto del footer", "validacionFooter");

        } catch (AssertionError | Exception e) {
            ExtentLogger.fail(test, driver, "Fallo en la validación del texto", "falloFooter");
            throw e;
        }
    }
}
