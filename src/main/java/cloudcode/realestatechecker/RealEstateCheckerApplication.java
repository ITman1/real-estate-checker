package cloudcode.realestatechecker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class RealEstateCheckerApplication {

    private static final Logger logger = LoggerFactory.getLogger(RealEstateCheckerApplication.class);

    public static void main(final String[] args) {
        String port = System.getenv("PORT");
        if (port == null) {
            port = "8080";
            logger.warn("$PORT environment variable not set, defaulting to 8080");
        }
        SpringApplication app = new SpringApplication(RealEstateCheckerApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", port));

        // Start the Spring Boot application.
        app.run(args);
        logger.info("Hello from Cloud Run! The container started successfully and is listening for HTTP requests on {}", port);
    }
}
