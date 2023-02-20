package org.plateer.fittingroombo.common.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JWT 관련 공통 기능
 * 작성자: 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@Component
@Log4j2
public class JWTUtil {

    @Value("${org.plateer.jwt.secret}")
    private String key;

    @Value("${org.platter.filter.uri.exclude.tokenCheckFilter}")
    private List<String> tokenCheckFilterExcludeUris;

    public boolean isTokenCheckFilterExcludeUris(String uri) {
        return isExcludeUris(uri, tokenCheckFilterExcludeUris);
    }

    private boolean isExcludeUris(String uri, List<String> excludeUris) {
        for (String excludeUri : excludeUris) {
            if (uri.startsWith(excludeUri)) {
                return true;
            }
        }
        return false;
    }

    public String generateToken(Map<String, Object> valueMap, int days) {
        //헤더 부분
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        //payload 부분 설정
        Map<String, Object> payloads = new HashMap<>();
        payloads.putAll(valueMap);

        int time = days; //테스트는 분단위로 나중에 60*24 (일)단위변경

        String jwtStr = Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(time).toInstant()))
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .compact();

        return jwtStr;
    }

    public Map<String, Object> validateToken(String token) throws io.jsonwebtoken.SignatureException, io.jsonwebtoken.ExpiredJwtException {
        Map<String, Object> claim = Jwts.parser()
                .setSigningKey(key.getBytes()) // Set Key
                .parseClaimsJws(token) // 파싱 및 검증, 실패 시 에러
                .getBody();

        return claim;
    }
}
