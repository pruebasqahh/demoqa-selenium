package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilidad para tomar capturas de pantalla en Selenium y guardarlas en una carpeta específica.
 */
public class ScreenshotUtil {

    /**
     * Toma una captura de pantalla del navegador actual.
     *
     * @param driver        instancia de WebDriver
     * @param nombreBase    nombre base para el archivo de la captura
     * @return Ruta absoluta del archivo de la imagen guardada
     */
    public static String capturar(WebDriver driver, String nombreBase) {
        String rutaCaptura = "target/screenshots/";
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String nombreArchivo = nombreBase + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destino = new File(rutaCaptura + nombreArchivo);

        try {
            FileUtils.copyFile(src, destino);
        } catch (IOException e) {
            e.printStackTrace(); // Se puede mejorar con logs personalizados
        }

        return destino.getAbsolutePath();
    }
}
