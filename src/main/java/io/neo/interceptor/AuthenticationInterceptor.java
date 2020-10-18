package io.neo.interceptor;

import io.neo.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Neo
 * @since 10/13/2020-9:54 PM
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("uri is :" + uri);
        if (uri.endsWith("/login")) {
            return true;
        }

        String token = request.getHeader("Authorization");
        if (jwtUtil.validateToken(token)) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
