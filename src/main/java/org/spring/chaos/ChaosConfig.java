package org.spring.chaos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * {@inheritDoc}
 * <p> Configuration for introducing chaos experiments in web applications.
 */
@Configuration
@EnableWebMvc
class ChaosConfig extends WebMvcConfigurerAdapter {

    /**
     * Desired duration of simulated latency in milliseconds
     *
     * environment variable: CHAOS_LATENCY_MILLISECONDS
     * default value:        {@code 0}
     */
    @Value("${CHAOS_LATENCY_MILLISECONDS:0}")
    private long chaosLatencyMilliseconds;

    /**
     * Whether or not web requests should be made unavailable.
     *
     * environment variable: CHAOS_MAKE_UNAVAILABLE
     * default value:        {@code false}
     */
    @Value("${CHAOS_MAKE_UNAVAILABLE:false}")
    private boolean chaosMakeUnavailable;

    /**
     * {@inheritDoc}
     * <p> Adds chaos experiment interceptors for all web requests if and only if they are configured by environment
     * variable.
     *
     * @see ChaosConfig#chaosLatencyMilliseconds
     * @see ChaosConfig#chaosMakeUnavailable
     *
     * @param registry registry of current interceptors for web requests
     */
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
