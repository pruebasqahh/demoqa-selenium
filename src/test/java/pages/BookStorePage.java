package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookStorePage {
    WebDriver driver;

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void buscarLibro(String nombreLibro) {
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.clear();
        searchBox.sendKeys(nombreLibro);
    }

    public int contarResultadosVisibles() {
        List<WebElement> filas = driver.findElements(By.className("rt-tr-group"));
        return (int) filas.stream()
                .filter(f -> !f.getText().trim().isEmpty())
                .count();
    }
}
