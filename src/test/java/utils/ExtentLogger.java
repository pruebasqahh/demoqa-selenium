package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;

/**
 * Simplifica y centraliza el uso de logs con capturas para ExtentReports.
 */
public class ExtentLogger {

    /**
     * Registra un paso tipo INFO con captura de pantalla.
     */
    public static void info(ExtentTest test, WebDriver driver, String mensaje, String nombreCaptura) {
        String ruta = ScreenshotUtil.capturar(driver, nombreCaptura);
        try {
            test.info(mensaje, MediaEntityBuilder.createScreenCaptureFromPath(ruta).build());
        } catch (Exception e) {
            test.info(mensaje + " (sin imagen por error)");
        }
    }

    /**
     * Registra un paso tipo PASS con captura de pantalla.
     */
    public static void pass(ExtentTest test, WebDriver driver, String mensaje, String nombreCaptura) {
        String ruta = ScreenshotUtil.capturar(driver, nombreCaptura);
        try {
            test.pass(mensaje, MediaEntityBuilder.createScreenCaptureFromPath(ruta).build());
        } catch (Exception e) {
            test.pass(mensaje + " (sin imagen por error)");
        }
    }

    /**
     * Registra un paso tipo FAIL con captura de pantalla.
     */
    public static void fail(ExtentTest test, WebDriver driver, String mensaje, String nombreCaptura) {
        String ruta = ScreenshotUtil.capturar(driver, nombreCaptura);
        try {
            test.fail(mensaje, MediaEntityBuilder.createScreenCaptureFromPath(ruta).build());
        } catch (Exception e) {
            test.fail(mensaje + " (sin imagen por error)");
        }
    }
}
