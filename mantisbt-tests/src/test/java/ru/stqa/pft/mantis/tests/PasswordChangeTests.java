package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class PasswordChangeTests extends TestBase{

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testPasswordChange() throws IOException {
        long now = System.currentTimeMillis();
        UserData user = app.db().users().iterator().next();
        String name = user.getUsername();
        String password = "password" + now;
        app.session().logIn(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        app.goTo().configPage();
        app.userConfig().userConfigPage();
        app.userConfig().init(user);
        app.userConfig().resetPassword();
        List<MailMessage> mails = app.mail().waitForMail(1, 10000);
        String resetLink = findResetLink(mails);
        app.userConfig().finishResetPassword(resetLink, name, password);
        assertTrue(app.newSession().login(name, password));
    }

    private String findResetLink(List<MailMessage> mailMessages) {
        MailMessage mailMessage = mailMessages.stream().findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
