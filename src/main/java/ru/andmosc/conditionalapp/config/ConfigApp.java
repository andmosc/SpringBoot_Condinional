package ru.andmosc.conditionalapp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.andmosc.conditionalapp.profiles.DevProfile;
import ru.andmosc.conditionalapp.profiles.ProductionProfile;
import ru.andmosc.conditionalapp.profiles.SystemProfile;

@Configuration
public class ConfigApp {
    @Bean
    @ConditionalOnProperty(name="netology.profile.dev",havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name="netology.profile.dev",havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
