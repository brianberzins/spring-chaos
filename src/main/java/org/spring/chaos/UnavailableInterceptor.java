package org.spring.chaos;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@inheritDoc}
 * <p> Interceptor to simulate the service being unavailable.
 */
class UnavailableInterceptor extends AbstractHandlerInterceptor {

    /**
     * {@inheritDoc}
     * <p> Simulates the service being unavailable by setting the response status to {@code 503} Service Unavailable and
     * returning {@code false} to stop further execution of the handler chain.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        return false;
    }
}
