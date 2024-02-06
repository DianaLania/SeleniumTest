package Pages;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.opentelemetry.api.internal.ApiUsageLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;

import static Tests.SeleniumTest.*;

public class Products {
    public static String formalShoes_xpath = "/html/body/div[2]/center/h2";

    public static String sportsShoes_xpath = "/html/body/div[3]/center/h2";

    public static String sneakers_xpath = "/html/body/div[4]/center/h2";

    public static String formalShoesdropdown_xpath = "/html/body/div[2]/center/div/i[1]";

    public static String sportsShoesdropdown_xpath = "/html/body/div[3]/center/div/i[1]";

    public static String sneakersdropdown_xpath = "/html/body/div[4]/center/div/i[1]";

    public static String formalShoes_firstshoename = "/html/body/div[2]/table/tbody/tr[1]/td[1]";

    public static String sportsShoes_firstshoename = "/html/body/div[3]/table/tbody/tr[1]/td[1]";

    public static String formalShoes_verifyTitle() throws IOException {
        String expectedTitleFS = "Formal Shoes";
        String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleFS, actualTitleFS);
        if (expectedTitleFS.equals(actualTitleFS)) {
            test.log(Status.PASS, "Test Passed for title verification of Formal Shoes");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver))+ "Test Passed");
        } else if (false) {
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }
        return actualTitleFS;
    }

    public static String sportsShoes_verifyTitle() {
        String expectedTitleSS = "Sport Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportsShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleSS, actualTitleSS);
        if (expectedTitleSS.equals(actualTitleSS)) {
            test.log(Status.PASS, "Test Passed for title verification of Sports Shoes");
        }
        return actualTitleSS;
    }

    public static String sneakers_verifyTitle() {
        String expectedTitleSn = "Sneakers";
        String actualTitleSn = driver.findElement(By.xpath(sneakers_xpath)).getText();
        Assert.assertEquals(expectedTitleSn, actualTitleSn);
        if (expectedTitleSn.equals(actualTitleSn)) {
            test.log(Status.PASS, "Test Passed for title verification of Sneakers");
        }
        return actualTitleSn;
    }

    public static void formalShoes_firstshoe_verify() {
        String expectedFirstFormalShoe = "Classic Cheltanham";
        driver.findElement(By.xpath(formalShoesdropdown_xpath)).click();
        String actualFirstFormalShoe = driver.findElement(By.xpath(formalShoes_firstshoename)).getText();
        Assert.assertEquals(expectedFirstFormalShoe, actualFirstFormalShoe);
        if (expectedFirstFormalShoe.equals(actualFirstFormalShoe)) {
            test.log(Status.PASS, "Test Passed for first shoe name of Formal shoe i.e. Classic Cheltanham");
        }
    }

    public static void sportsShoesdropdown_firstshoe_verify() {
        String expectedFirstSportShoe = "Ultimate";
        driver.findElement(By.xpath(sportsShoesdropdown_xpath)).click();
        String actualFirstSportsShoe = driver.findElement(By.xpath(sportsShoes_firstshoename)).getText();
        Assert.assertEquals(expectedFirstSportShoe, actualFirstSportsShoe);
        if (expectedFirstSportShoe.equals(actualFirstSportsShoe)) {
            test.log(Status.PASS, "Test Passed for first shoe name of Sports Shoe i.e. Ultimate");
        }
    }
}
