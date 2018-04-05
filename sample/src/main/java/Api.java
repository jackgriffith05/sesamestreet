import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class Api
{
    private static final Logger LOG = LoggerFactory.getLogger(Api.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String SESSION_URI = "https://api.matchbook.com/bpapi/rest/security/session";
    private static final String LIST_EVENTS_URI = "https://api.matchbook.com/edge/rest/events";

    private final String sessionToken;
    private final HttpClient httpClient = HttpClientBuilder.create().build();
    private final URIBuilder listEventsRequestBuilder;

    public Api()
    {
        this.sessionToken = this.login().getSessionToken();
        try
        {
            this.listEventsRequestBuilder = new URIBuilder(LIST_EVENTS_URI).setParameter("per-page", "300");
        }
        catch (URISyntaxException e)
        {
            LOG.error("{}", e);
            throw new RuntimeException(e);
        }
    }

    public EventContainer getEvents(String sportIds)
    {
        return this.makeGetRequest(
                this.listEventsRequestBuilder
                        .setParameter("sport-ids", sportIds),
                EventContainer.class);
    }

    private Session login()
    {
        return this.makePostRequest(new Login(System.getProperty("mb.user"), System.getProperty("mb.password")), SESSION_URI, Session.class);
    }

    private <T> T makeGetRequest(URIBuilder uriBuilder, Class<T> resultClazz)
    {
        try
        {
            String jsonResponse = toString(this.makeRequest(new HttpGet(uriBuilder.build())));
            return OBJECT_MAPPER.readValue(jsonResponse, resultClazz);
        }
        catch (IOException | URISyntaxException e)
        {
            LOG.error("{}", e);
            throw new RuntimeException(e);
        }
    }

    private <T> T makePostRequest(Object paramObject, String uri, Class<T> resultClazz)
    {
        try
        {
            String paramsString = OBJECT_MAPPER.writeValueAsString(paramObject);
            String jsonResponse = toString(this.makePostRequest(uri, paramsString));
            return OBJECT_MAPPER.readValue(jsonResponse, resultClazz);
        }
        catch (IOException e)
        {
            LOG.error("{}", e);
            throw new RuntimeException(e);
        }
    }

    private HttpResponse makePostRequest(String uri, String params) throws IOException
    {
        HttpPost request = new HttpPost(uri);
        request.setEntity(new StringEntity(params));
        return this.makeRequest(request);
    }

    private HttpResponse makeRequest(HttpUriRequest request) throws IOException
    {
        request.addHeader("accept", "application/json;");
        request.addHeader("content-type", "application/json;");
        request.addHeader("Accept-Encoding", "gzip");
        request.addHeader("session-token", this.sessionToken);
        return this.httpClient.execute(request);
    }

    private static String toString(HttpResponse response) throws IOException
    {
        String jsonResponse = EntityUtils.toString(response.getEntity());
        LOG.debug(new DateTime() + "###" + jsonResponse);
        return jsonResponse;
    }
}
