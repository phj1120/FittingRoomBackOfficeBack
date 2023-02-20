package org.plateer.fittingroombo.common.security;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroombo.common.security.controller.SecurityController;
import org.plateer.fittingroombo.common.security.dto.TokensDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JWTUtilTest {

    @Autowired
    SecurityController securityController;

    @Test
    void refresh() {
        TokensDTO tokensDTO = new TokensDTO("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzY3OTE0MjQsImlhdCI6MTY3Njc5MTM2NCwibWVtYmVySWQiOiJ0ZXN0MiJ9.J2MztqvxeADBvw5JuzgV0EwhVaVDzUFlJCQP6I6-7ew",
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzY5MTA1NDUsImlhdCI6MTY3Njc5MDU0NSwibWVtYmVySWQiOiJ0ZXN0MiJ9.mBV_9MjGPPertLhs-eptHcjL062Qe_rutnEurj88cQk");
        TokensDTO refresh = securityController.refresh(tokensDTO);

        System.out.println(refresh);
    }
}