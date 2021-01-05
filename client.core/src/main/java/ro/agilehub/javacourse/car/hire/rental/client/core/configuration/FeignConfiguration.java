package ro.agilehub.javacourse.car.hire.rental.client.core.configuration;

import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import ro.agilehub.javacourse.car.hire.rental.client.core.impl.UserApiClient;

@Configuration
@EnableFeignClients(basePackageClasses = UserApiClient.class)
public class FeignConfiguration {

    @Bean
    public RequestInterceptor authRequestInterceptor() {
        return requestTemplate -> {
            var jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            requestTemplate.header("Authorization", String.format("Bearer %s", jwt.getTokenValue()));
        };
    }
}
