package org.spring.chaos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@inheritDoc}
 * <p> Interceptor to simulate latency is requests by introducing a thread sleep.
 */
class LatencyInterceptor extends AbstractHandlerInterceptor {

    private long chaosLatencyMilliseconds;

    /**
     * Creates a new LatencyInterceptor that will sleep for the configured duration before continuing the handler chain.
     *
     * @param chaosLatencyMilliseconds  time to sleep in milliseconds before continuing
     */
    LatencyInterceptor(long chaosLatencyMilliseconds) {
        this.chaosLatencyMilliseconds = chaosLatencyMilliseconds;
    }

    /**
     * {@inheritDoc}
     * <p> Simulates latency by inducing a thread sleep before returning {@code true} to continue the handler chain.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Thread.sleep(chaosLatencyMilliseconds);
        return true;
    }
}
