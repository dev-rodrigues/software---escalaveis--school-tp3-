package br.com.devrodrigues.schoolservice.output.http.client;

import br.com.devrodrigues.schoolservice.config.FeignRetryerConfig;
import br.com.devrodrigues.schoolservice.output.http.entity.PermissionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "user-client",
        url = "${host.user}",
        configuration = FeignRetryerConfig.class
)
public interface UseClient {

    @GetMapping(value = "/to-allowed")
    ResponseEntity<PermissionResponse> toAllowed(
            @RequestParam(value = "function") String function,
            @RequestHeader(value="token") String token
    );
}
