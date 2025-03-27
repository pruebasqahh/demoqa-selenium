package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DemoqaBookStoreTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void buscarLibroYValidarFiltro() {
        // 1. Ir a https://demoqa.com/
        driver.get("https://demoqa.com/");

        // 2. Clic en Book Store Application
        WebElement bookStoreCard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h5[text()='Book Store Application']/ancestor::div[@class='card mt-4 top-card']")
        ));
        bookStoreCard.click();

        // 3. Escribir 'Git Pocket Guide' en el campo de búsqueda
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBox")));
        searchBox.sendKeys("Git Pocket Guide");

        // 4. Validar que solo haya un resultado
        // Esperar a que la tabla se actualice
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("rt-tr-group")));
        List<WebElement> filas = driver.findElements(By.className("rt-tr-group"));

        // Filtrar las filas que realmente contienen datos (descartar encabezados vacíos)
        long filasVisibles = filas.stream()
                .filter(fila -> !fila.getText().trim().isEmpty())
                .count();

        Assert.assertEquals(filasVisibles, 1, "Se esperaba solo un resultado en la tabla.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
