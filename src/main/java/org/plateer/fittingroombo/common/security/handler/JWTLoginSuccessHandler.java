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

@Log4j2
@RequiredArgsConstructor
public class JWTLoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JWTUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("JWTLoginSuccessHandler....................................");

        // 사용자의 아이디를 담은 jwt 토큰 생성
        String memberId = authentication.getName();
        String access = jwtUtil.generateToken(Map.of("memberId", memberId), 2);
        String refresh = jwtUtil.generateToken(Map.of("memberId", memberId), 10);

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
