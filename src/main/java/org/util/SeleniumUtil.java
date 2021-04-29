package org.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class SeleniumUtil {

    private static WebDriver webDriver;

    public static synchronized WebDriver getWebDriver() throws URISyntaxException {
        if (webDriver == null) {
            initialize();
        }
        return webDriver;
    }

    private static void initialize() throws URISyntaxException {
        URL chromeURL = SeleniumUtil.class.getClassLoader().getResource("chromedriver");
        System.setProperty("webdriver.chrome.driver", Paths.get(chromeURL.toURI()).toFile().getAbsolutePath());

        webDriver = new ChromeDriver();
    }
}