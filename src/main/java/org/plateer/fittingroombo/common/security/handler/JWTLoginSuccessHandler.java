package org.plateer.fittingroombo.common.security.handler;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.security.JWTUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Spring Security 로그인 성공 처리를 위한 Handler
 * 작성자: 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@Log4j2
@RequiredArgsConstructor
public class JWTLoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JWTUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("JWTLoginSuccessHandler....................................");

        // 사용자의 아이디를 담은 jwt 토큰 생성
        String memberId = authentication.getName();
        // TODO 테스트를 위해 시간 늘림
        String access = jwtUtil.generateToken(Map.of("memberId", memberId), 1);
        String refresh = jwtUtil.generateToken(Map.of("memberId", memberId), 30);

        // 응답 생성
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(Map.of("access", access, "refresh", refresh));
        out.write(jsonStr);
        out.flush();
        out.close();
    }

}
