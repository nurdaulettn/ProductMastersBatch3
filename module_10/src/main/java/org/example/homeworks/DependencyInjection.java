package org.example.homeworks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {

    @Bean
    public GreetingService greetingService() {
        return new RussianGreetingService();
    }
}
