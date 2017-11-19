package org.spring.chaos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
class ChaosConfig extends WebMvcConfigurerAdapter {

    @Value("${CHAOS_LATENCY_MILLISECONDS:0}")
    private long chaosLatencyMilliseconds;

    @Value("${CHAOS_MAKE_UNAVAILABLE:false}")
    private boolean chaosMakeUnavailable;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (chaosLatencyMilliseconds > 0) {
            LatencyInterceptor latencyInterception = new LatencyInterceptor(chaosLatencyMilliseconds);
            registry.addInterceptor(latencyInterception);
        }
        if (chaosMakeUnavailable) {
            UnavailableInterceptor unavailableInterceptor = new UnavailableInterceptor();
            registry.addInterceptor(unavailableInterceptor);
        }
    }

}
