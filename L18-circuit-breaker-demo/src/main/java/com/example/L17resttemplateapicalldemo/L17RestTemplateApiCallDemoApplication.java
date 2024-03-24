package com.example.L17resttemplateapicalldemo;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@EnableFeignClients
@SpringBootApplication
public class L17RestTemplateApiCallDemoApplication {


	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {

		// the circuitBreakerConfig and timeLimiterConfig objects
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
				.failureRateThreshold(50)
				.waitDurationInOpenState(Duration.ofMillis(1000))
				.slidingWindowSize(2)
				.build();
		TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
				.timeoutDuration(Duration.ofSeconds(2))
				.build();

		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.timeLimiterConfig(timeLimiterConfig)
				.circuitBreakerConfig(circuitBreakerConfig)
				.build());
	}

		public static void main(String[] args) {
		SpringApplication.run(L17RestTemplateApiCallDemoApplication.class, args);
	}

}
