package ro.agilehub.javacourse.car.hire.rental.client.core.configuration;

import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.agilehub.javacourse.car.hire.rental.client.core.impl.UserApiClient;

@Configuration
@EnableFeignClients(basePackageClasses = UserApiClient.class)
public class FeignConfiguration {

    @Bean
    public RequestInterceptor authRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer <some jwt token value>");
        };
    }
}
