package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HTTPHelper;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase{
    @Test
    public void testLogin() throws IOException {
        HTTPHelper session = app.newSession();
        assertTrue(session.login("administrator", "administrator"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}
