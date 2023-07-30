package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class UserConfigHelper extends HelperBase{
    public UserConfigHelper(ApplicationManager app) {
        super(app);
    }

    public void userConfigPage() {
        if (isElementPresent(By.cssSelector(".active a[href=\"/mantisbt-2.25.7/manage_user_page.php\"]"))) {
            return;
        }
        click(By.cssSelector("a[href=\"/mantisbt-2.25.7/manage_user_page.php\"]"));
    }

    public void init(UserData user) {
        click(By.cssSelector(String.format("a[href=\"manage_user_edit_page.php?user_id=%s\"]", user.getId())));
    }

    public void resetPassword() {
        click(By.cssSelector("#manage-user-reset-form>fieldset>span>input"));
    }

    public void finishResetPassword(String link, String name, String password){
        driver.get(link);
        type(By.id("realname"), name);
        type(By.id("password"), password);
        type(By.id("password-confirm"), password);
        click(By.cssSelector("[type='submit']"));
    }
}
