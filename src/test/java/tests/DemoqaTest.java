package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DemoqaTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validarTextoEnDemoqa() {
        driver.get("https://demoqa.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement textoFooter = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(),'2013-2020 TOOLSQA.COM')]")
            ));

            String textoObtenido = textoFooter.getText();
            Assert.assertTrue(textoObtenido.contains("2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED."),
                    "El texto esperado no se encontró en la página.");
        } catch (Exception e) {
            Assert.fail("El texto del footer no se encontró o no estaba disponible a tiempo.", e);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
