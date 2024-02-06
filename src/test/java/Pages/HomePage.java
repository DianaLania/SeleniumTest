package Pages;
import org.openqa.selenium.By;

import java.io.IOException;

import static Tests.SeleniumTest.driver;

public class HomePage {

    public static String hamburger_menu_xpath = "//*[@id=\"menuToggle\"]/input";
    public static String onlineProducts_link_xpath = "//*[@id=\"menu\"]/a[3]/li";
    public static void click_hamburger_menu() {
        driver.findElement(By.xpath(hamburger_menu_xpath)).click();
    }

    public static void click_onlineProducts_link() {
        driver.findElement(By.xpath(onlineProducts_link_xpath)).click();
    }
}
