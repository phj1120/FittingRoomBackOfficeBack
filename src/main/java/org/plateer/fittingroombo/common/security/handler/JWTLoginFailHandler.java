package org.plateer.fittingroombo.common.security.handler;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Spring Security 로그인 실패 처리를 위한 Handler
 * 작성자: 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@Log4j2
public class JWTLoginFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("JWTLoginFailHandler....................................");

        // 응답 생성
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(Map.of("status", exception.getMessage()));
        out.write(jsonStr);
        out.flush();
        out.close();
    }
}
