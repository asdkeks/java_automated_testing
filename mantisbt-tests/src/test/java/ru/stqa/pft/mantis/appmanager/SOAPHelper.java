package ru.stqa.pft.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SOAPHelper{
    private static ApplicationManager app;

    public SOAPHelper(ApplicationManager app) {
        this.app = app;
    }

    public Set<Project> getProjects() throws RemoteException, MalformedURLException, ServiceException {
        MantisConnectPortType mc = newMantisConnection();
        ProjectData[] projects = mc.mc_projects_get_user_accessible(app.getProperty("web.adminLogin"),
                app.getProperty("web.adminPassword"));
        return Arrays.asList(projects).stream()
                .map((p) -> new Project().withId(p.getId().intValue()).withName(p.getName()))
                .collect(Collectors.toSet());
    }

    private static MantisConnectPortType newMantisConnection() throws ServiceException, MalformedURLException {
        MantisConnectPortType mc = new MantisConnectLocator().getMantisConnectPort(
                new URL(app.getProperty("soap.baseUrl")));
        return mc;
    }

    public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = newMantisConnection();
        String[] categories = mc.mc_project_get_categories(app.getProperty("web.adminLogin"),
                app.getProperty("web.adminPassword"), BigInteger.valueOf(issue.getProject().getId()));
        IssueData issueData = new IssueData();
        issueData.setSummary(issue.getSummary());
        issueData.setDescription(issue.getDescription());
        issueData.setProject(new ObjectRef(
                BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
        issueData.setCategory(categories[0]);
        BigInteger issueId = mc.mc_issue_add(
                app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"), issueData);
        IssueData createdIssueData = mc.mc_issue_get(
                app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"), issueId);
        return new Issue().withId(createdIssueData.getId().intValue())
                .withDescription(createdIssueData.getDescription()).withSummary(createdIssueData.getSummary())
                .withProject(new Project().withId(createdIssueData.getProject().getId().intValue())
                        .withName(createdIssueData.getProject().getName()));
    }
}
