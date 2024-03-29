package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.ITestContext;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Listeners(TestListener.class)
public class TestBase {
    Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);

    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeSuite
    public void setUp(ITestContext context) throws IOException {
        app.init();
        context.setAttribute("app", app);

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logStartTest (Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod (alwaysRun = true)
    public void logFinishTest (Method m, Object[] p) {
        logger.info("Finish test " + m.getName());
    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream()
                    .map((g)-> new GroupData().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }

    }
}
