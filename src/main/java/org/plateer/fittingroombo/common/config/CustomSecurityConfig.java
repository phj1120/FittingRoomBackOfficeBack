package org.plateer.fittingroombo.common.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.security.JWTUtil;
import org.plateer.fittingroombo.common.security.filter.JWTLoginFilter;
import org.plateer.fittingroombo.common.security.filter.TokenCheckFilter;
import org.plateer.fittingroombo.common.security.handler.JWTLoginFailHandler;
import org.plateer.fittingroombo.common.security.handler.JWTLoginSuccessHandler;
import org.plateer.fittingroombo.common.security.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Log4j2
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 어노테이션으로 시큐리티 기능 사용할 것인지
@RequiredArgsConstructor
public class CustomSecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;
    private final JWTUtil jwtUtil;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        log.info("[CustomSecurityConfig.filterChain]");
        // Spring Security 가 제공하는 기본 로그인 화면
//        http.formLogin();

        // 외부에서 http 요청 하는 것을 막기 위한 것이 csrf 설정인데, api 서버라 csrf 설정 필요 없음
        http.csrf().disable();

        // cors 설정 @CrossOrigin(origins = "*") 로 도 설정 가능
        http.cors(httpSecurityCorsConfigurer -> {
            httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource());
        });

        // jwt 를 이용할 것이므로 세션은 사용 하지 않을 예정
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // URI 별 접근 권한 설정 @PreAuthorize 로 도 설정 가능
        http.authorizeRequests()
                .antMatchers("/auth/api/sample/ex2").hasRole("USER")
                .antMatchers("/auth/api/sample/ex3").hasRole("ADMIN");

        // AuthenticationManager 설정 - 반드시 필요
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
        http.authenticationManager(authenticationManager);

        // JWT 로그인용 필터 등록
        JWTLoginFilter jwtLoginFilter = new JWTLoginFilter("/api/sign-in");
        jwtLoginFilter.setAuthenticationManager(authenticationManager); // AuthenticationManager 설정 - 반드시 필요
        jwtLoginFilter.setAuthenticationSuccessHandler(new JWTLoginSuccessHandler(jwtUtil)); // 성공 핸들러 등록
        jwtLoginFilter.setAuthenticationFailureHandler(new JWTLoginFailHandler()); // 실패 핸들러 등록
        http.addFilterBefore(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class);

        // JWT 토큰 검증 필터 등록
        TokenCheckFilter tokenCheckFilter = new TokenCheckFilter(jwtUtil, customUserDetailsService);
        http.addFilterBefore(tokenCheckFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
