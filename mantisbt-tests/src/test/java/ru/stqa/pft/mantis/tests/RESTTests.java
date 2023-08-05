package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RESTTests extends TestBase{

    @Test
    public void testCreateIssue() throws IOException, ServiceException {
        long now = System.currentTimeMillis();
        Project project = app.soap().getProjects().iterator().next();
        Set<Issue> oldIssues = app.rest().getIssues(project);
        Issue newIssue = new Issue().withDescription(String.format("Test Description %s", now))
                .withSummary(String.format("Test Summary %s", now)).withProject(project);
        int issueId = app.rest().createIssue(newIssue);
        Set<Issue> newIssues = app.rest().getIssues(project);
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues,oldIssues);
    }
}
