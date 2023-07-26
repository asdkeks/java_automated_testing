package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationManager {
    private final Properties properties;
    private String browser;
    WebDriver driver;

    JavascriptExecutor js;
    private Map<String, Object> vars;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if (browser.equals(Browser.CHROME.browserName())) {
            driver = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX.browserName())) {
            driver = new FirefoxDriver();
        } else if (browser.equals(Browser.IE.browserName())){
            driver = new InternetExplorerDriver();
        }
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(properties.getProperty("web.baseUrl"));
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

    }

    public void stop() {
        driver.quit();
    }
}
