package org.spring.chaos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LatencyInterceptor extends ChaosInterceptor {

    private long chaosLatencyMilliseconds;

    LatencyInterceptor(long chaosLatencyMilliseconds) {
        this.chaosLatencyMilliseconds = chaosLatencyMilliseconds;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Thread.sleep(chaosLatencyMilliseconds);
        return true;
    }
}
