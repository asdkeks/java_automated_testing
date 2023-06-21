package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.*;


public class AddressBookWebTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        logIn("admin", "secret");
    }

    private void logIn(String username, String password) {
        driver.get("http://localhost/addressbook/");
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGroupCreation() {
        goToGroupPage();
        initGroupCreation();
        fillInGroupForm(new GroupDelta("test1", "test2", "test3"));
        submitGroupCreation();
        goToGroupPage();
    }

    private void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    private void fillInGroupForm(GroupDelta groupDelta) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(groupDelta.getName());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(groupDelta.getHeader());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(groupDelta.getFooter());
    }

    private void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    private void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }
}

