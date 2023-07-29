package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class HelperBase {
    protected WebDriver driver;
    protected ApplicationManager app;
    protected Select select;

    public HelperBase(ApplicationManager app) {
        this.app = app;
        this.driver = app.getDriver();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            if (! text.equals(driver.findElement(locator).getAttribute("value"))) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void attach(By locator, File photo) {
        if (photo != null) {
                driver.findElement(locator).sendKeys(photo.getAbsolutePath());
        }
    }

    protected void selectByText(By locator, String text) {
        select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    protected void selectByValue(By locator, String value) {
        select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public void confirmAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void wait(int sec){
        new WebDriverWait(driver, Duration.ofSeconds(sec));
    }

    public void refresh(){
        driver.navigate().refresh();
    }
}
