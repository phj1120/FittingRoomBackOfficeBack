package org.plateer.fittingroombo.common.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {
//    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("UserDetails.......................");
//        Member member = memberRepository.findByMemberId(username)
//                .orElseThrow(() -> new RuntimeException("존재 하지 않는 사용자"));
//
//        UserDetails userDetails = User.builder()
//                .username(username)
//                .password(member.getPassword())
//                .authorities(member.getMemberRole().name())
//                .build();

        UserDetails userDetails = User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode("password"))
                .authorities("ADMIN")
                .build();

        return userDetails;
    }
}
