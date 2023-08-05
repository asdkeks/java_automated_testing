package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    private String browser;
    WebDriver driver;

    JavascriptExecutor js;
    private Map<String, Object> vars;
    private RegistrationHelper registrationHelper;
    private FTPHelper ftp;
    private MailHelper mail;

    private NavigationHelper goTo;
    private DBHelper db;
    private SessionHelper session;
    private UserConfigHelper userConfig;
    private SOAPHelper soapHelper;
    private RESTHelper restHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
//        js = (JavascriptExecutor) driver;
//        vars = new HashMap<String, Object>();

    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public HTTPHelper newSession() {
        return new HTTPHelper(this);
    }

    public RegistrationHelper registration() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public FTPHelper ftp() {
        if (ftp == null) {
            ftp = new FTPHelper(this);
        }
        return ftp;
    }

    public MailHelper mail() {
        if (mail == null) {
            mail = new MailHelper(this);
        }
        return mail;
    }

    public NavigationHelper goTo() {
        if (goTo == null) {
            goTo = new NavigationHelper(this);
        }
        return goTo;
    }

    public DBHelper db() {
        if (db == null) {
            db = new DBHelper();
        }
        return db;
    }

    public SessionHelper session() {
        if (session == null) {
            session = new SessionHelper(this);
        }
        return session;
    }

    public UserConfigHelper userConfig() {
        if (userConfig == null) {
            userConfig = new UserConfigHelper(this);
        }
        return userConfig;
    }

    public SOAPHelper soap() {
        if (soapHelper == null){
            soapHelper = new SOAPHelper(this);
        }
        return soapHelper;
    }

    public RESTHelper rest() {
        if (restHelper == null){
            restHelper = new RESTHelper(this);
        }
        return restHelper;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            if (browser.equals(Browser.CHROME.browserName())) {
                driver = new ChromeDriver();
            } else if (browser.equals(Browser.FIREFOX.browserName())) {
                driver = new FirefoxDriver();
            } else if (browser.equals(Browser.IE.browserName())){
                driver = new InternetExplorerDriver();
            }
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }
        return driver;
    }
}
