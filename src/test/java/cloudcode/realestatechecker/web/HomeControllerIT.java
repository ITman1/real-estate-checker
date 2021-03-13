package cloudcode.realestatechecker.web;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Integration test for local or remote service based on the env var
 * "SERVICE_URL". See java/CONTRIBUTING.MD for more information.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class HomeControllerIT {

    @Test
    void respondsToHttpRequest() throws IOException {
        String port = System.getenv("PORT");
        if (port == null || port.equals("")) {
            port = "8080";
        }

        String url = System.getenv("SERVICE_URL");
        if (url == null || url.equals("")) {
            url = "http://localhost:" + port;
        }

        OkHttpClient ok =
          new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build();

        Request request = new Request.Builder().url(url + "/").get().build();

        String expected = "Congratulations, you successfully deployed a container image to Cloud Run";
        Response response = ok.newCall(request).execute();
        assertThat(response.body().string(), containsString(expected));
        assertThat(response.code(), equalTo(200));
    }
}
