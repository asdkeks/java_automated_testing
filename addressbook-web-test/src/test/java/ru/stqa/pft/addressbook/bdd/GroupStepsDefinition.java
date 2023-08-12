package ru.stqa.pft.addressbook.bdd;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.Browser;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupStepsDefinition {
    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";
    private ApplicationManager app;
    private Groups groups;
    private GroupData group;

    @Before
    public void initApp() throws IOException {
        app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));
        app.init();
    }

    @After
    public void stopApp(){
        app.stop();
        app = null;
    }

    @Given("^a set of groups$")
    public void getGroups() {
        groups = app.db().groups();
    }

    @When("^I create a new group with (.+) and (.+) and (.+)$")
    public void createGroup(String name, String header, String footer){
        group = new GroupData().withName(name).withHeader(header).withFooter(footer);
        app.goTo().groupPage();
        app.group().create(group);
    }

    @Then("^the new set of groups is equal to the old set with added group$")
    public void verifyGroupCreation(){
        Groups newGroups = app.db().groups();
        assertThat(newGroups, equalTo(
                groups.withAdded(
                        group.withId(newGroups.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
