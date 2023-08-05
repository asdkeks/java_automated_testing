package ru.stqa.pft.mantis.appmanager;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.axis.types.URI;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RESTHelper{

    private ApplicationManager app;
    private CloseableHttpClient httpClient;

    public RESTHelper(ApplicationManager app) {
        this.app = app;
        httpClient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }

    public Set<Issue> getIssues(Project project) throws IOException {
        HttpGet get = new HttpGet(String.format(app.getProperty("web.baseUrl") +
                "/api/rest/issues?project_id=%s", project.getId()));
        get.addHeader("Authorization", app.getProperty("rest.token"));
        CloseableHttpResponse response = httpClient.execute(get);
        String json = getTextFrom(response);
        JsonElement parsed = JsonParser.parseString(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }


    private String getTextFrom(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }

    public int createIssue(Issue issue) throws IOException {
        String requestBody = String.format("{\n  \"summary\": \"%s\",\n" +
                "  \"description\": \"%s\",\n" +
                "  \"category\": {\n" +
                "    \"name\": \"General\"\n" +
                "  },\n" +
                "  \"project\": {\n" +
                "    \"id\": 1\n" +
                "  }\n" +
                "}", issue.getSummary(), issue.getDescription());
        StringEntity entity = new StringEntity(requestBody);
        HttpPost post = new HttpPost(String.format(app.getProperty("web.baseUrl") +
                "/api/rest/issues"));
        post.addHeader("Authorization", app.getProperty("rest.token"));
        post.addHeader("content-type", "application/json");
        post.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(post);
        String json = getTextFrom(response);
        JsonElement parsed = JsonParser.parseString(json);
        return parsed.getAsJsonObject().getAsJsonObject("issue").get("id").getAsInt();
    }
}
