package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class DemoqaTest extends BaseTest {
    @Test
    public void validarTextoEnDemoqa() {
        driver.get("https://demoqa.com/");
        HomePage homePage = new HomePage(driver);
        String textoFooter = homePage.obtenerTextoFooter();
        Assert.assertTrue(
                textoFooter.contains("2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED."),
                "El texto esperado no se encontró en el footer."
        );
    }
}
