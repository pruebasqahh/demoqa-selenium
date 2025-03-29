package factory;

import org.openqa.selenium.WebDriver;
import pages.BookStorePage;
import pages.HomePage;

public class PageFactoryManager {
    private WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public BookStorePage getBookStorePage() {
        return new BookStorePage(driver);
    }

}
