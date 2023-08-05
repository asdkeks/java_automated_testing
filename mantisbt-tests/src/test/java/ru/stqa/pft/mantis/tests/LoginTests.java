package ru.stqa.pft.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HTTPHelper;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() throws IOException {
        skipIfNotFixed(14);
    }
    @Test
    public void testLogin() throws IOException {
        HTTPHelper session = app.newSession();
        assertTrue(session.login("administrator", "administrator"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}
