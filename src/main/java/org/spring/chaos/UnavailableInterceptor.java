package org.spring.chaos;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnavailableInterceptor extends ChaosInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        return false;
    }
}
