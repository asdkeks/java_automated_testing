package ru.stqa.pft.mantis.model;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class Issue {
    @Expose
    private int id;
    @Expose
    private String summary;
    @Expose
    private String description;
    @Expose
    private Project project;

    private String status;

    public int getId() {
        return id;
    }


    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Issue withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public Issue withProject(Project project) {
        this.project = project;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (id != issue.id) return false;
        if (!Objects.equals(summary, issue.summary)) return false;
        if (!Objects.equals(description, issue.description)) return false;
        return Objects.equals(project, issue.project);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", project=" + project +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public Issue withStatus(String status) {
        this.status = status;
        return this;
    }
}
