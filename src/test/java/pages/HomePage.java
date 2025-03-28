// src/test/java/pages/HomePage.java

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void irABookStoreApplication() {
        WebElement bookStoreCard = driver.findElement(
                By.xpath("//h5[text()='Book Store Application']/ancestor::div[@class='card mt-4 top-card']")
        );
        bookStoreCard.click();
    }

    public String obtenerTextoFooter() {
        WebElement footer = driver.findElement(
                By.xpath("//*[contains(text(),'2013-2020 TOOLSQA.COM')]")
        );
        return footer.getText();
    }
}
