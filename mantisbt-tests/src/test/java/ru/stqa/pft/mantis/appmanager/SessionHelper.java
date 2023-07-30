package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(ApplicationManager app) {
        super(app);
    }

    public void logIn(String username, String password) {
        type(By.id("username"), username);
        click(By.cssSelector("input[type=\"submit\"]"));
        type(By.id("password"), password);
        click(By.cssSelector("input[type=\"submit\"]"));

    }
}
