package br.com.devrodrigues.schoolservice.config;

import org.springframework.beans.factory.annotation.Value;

public class FeignRetryerConfig extends GenericFeignClientRetryer {

    public FeignRetryerConfig(
        @Value("${feign.client.default.config.numberRetry}") int numberRetry,
        @Value("${feign.client.default.config.retryInterval}") long retryInterval) {
        super(numberRetry, retryInterval);
    }
}