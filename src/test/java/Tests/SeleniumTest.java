package Tests;
import Pages.HomePage;
import Pages.Products;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {

    public static WebDriver driver;

    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();
    public static ChromeOptions options;

    @BeforeSuite
    public static void Setup() throws InterruptedException {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter();
        HomePage.click_hamburger_menu();
        HomePage.click_onlineProducts_link();
    }

    public static String capture(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/.../ExecImages/" + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileHandler.copy(scrFile, Dest);
        return errflpath;
    }
    @Test
    void validateTitles_onlineProducts() throws InterruptedException, IOException {
        test = extent.createTest("Validate Titles on Products Page", "This test validates that the different Shoetype are correct on Online Product Page");
        Products.formalShoes_verifyTitle();
        Products.sneakers_verifyTitle();
        Products.sportsShoes_verifyTitle();
        extent.flush();
    }
    @Test
    void validateFirstFormalShoes(){
        test = extent.createTest("Validate First Formal Shoename", "This test validates first formal shoes on Product page");
        Products.formalShoes_firstshoe_verify();

    }
    @Test
    void validateFirstSportsShoes(){
        test = extent.createTest("Validate Titles on Sports Shoename", "This test validates first sports shoes on Product page");
        Products.sportsShoesdropdown_firstshoe_verify();
    }
    @AfterSuite
    public static void cleanup(){
        extent.flush();
    }
}