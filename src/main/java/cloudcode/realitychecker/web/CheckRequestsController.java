package cloudcode.realitychecker.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("check-requests")
@RestController
public final class CheckRequestsController {

    private static final Logger logger = LoggerFactory.getLogger(CheckRequestsController.class);

    @PostMapping("/create")
    public void create(@RequestBody(required = false) Map<String, Object> request) {
        logger.info("Received request {}", request);
    }

}
