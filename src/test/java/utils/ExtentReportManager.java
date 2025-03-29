package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Crea y gestiona una instancia única (singleton) de ExtentReports para generar reportes HTML.
 */
public class ExtentReportManager {

    private static ExtentReports extent;

    /**
     * Devuelve una instancia única de ExtentReports configurada para el proyecto.
     *
     * @return instancia de ExtentReports lista para usar
     */
    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
            reporter.config().setReportName("DemoQA Test Report");
            reporter.config().setDocumentTitle("Extent Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Framework", "HHEA - Selenium + TestNG");
            extent.setSystemInfo("Autor", "Hector Hugo Elizalde Alcala");
        }
        return extent;
    }
}
