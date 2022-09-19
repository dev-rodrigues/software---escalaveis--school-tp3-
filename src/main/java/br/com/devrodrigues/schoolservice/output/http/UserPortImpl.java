package br.com.devrodrigues.schoolservice.output.http;

import br.com.devrodrigues.schoolservice.output.http.client.UseClient;
import br.com.devrodrigues.schoolservice.ports.UserPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

@Component
public class UserPortImpl implements UserPort {

    private final UseClient client;
    private final Logger logger = LoggerFactory.getLogger(UserPortImpl.class);

    public UserPortImpl(UseClient client) {
        this.client = client;
    }

    @Override
    public Boolean youCanRun(String token, String function) {

        try {
            var response = client.toAllowed(function, token);
            logger.info("Response from user service: {}", requireNonNull(response.getBody()).getMessage());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
