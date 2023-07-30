package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager app) {
       super(app);
    }

    public void configPage() {
        if (isElementPresent(By.cssSelector(".active a[href=\"/mantisbt-2.25.7/manage_overview_page.php\"]"))) {
            return;
        }
        click(By.cssSelector("a[href=\"/mantisbt-2.25.7/manage_overview_page.php\"]"));
    }
    public void homePage(){
        if (isElementPresent(By.cssSelector(".active .fa-dashboard"))) {
            return;
        }
        click(By.cssSelector(".smaller-75"));
    }
}
