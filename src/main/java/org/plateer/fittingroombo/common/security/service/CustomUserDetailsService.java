package org.plateer.fittingroombo.common.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.security.dto.CustomUserDetail;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.mapper.PlaceMapper;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.mapper.SellerMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

/**
 * Spring Security 사용자 인가를 위해 필요한 UserDetailsService 구현체
 * 작성자: 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@RequiredArgsConstructor
@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {
    private final SellerMapper sellerMapper;
    private final PlaceMapper placeMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SellerDTO sellerDTO = sellerMapper.getSellerById(username);
        PlaceDTO placeDTO = placeMapper.getPlaceById(username);

        if (Objects.isNull(sellerDTO) && Objects.isNull(placeDTO)) {
            throw new UsernameNotFoundException("일치하는 사용자 없음");
        }
        if (!Objects.isNull(sellerDTO) && !Objects.isNull(placeDTO)) {
            throw new UsernameNotFoundException("중복되는 사용자 아이디");
        }

        if (!Objects.isNull(sellerDTO)) {
            log.info("[Login]: Seller - {}", username);

            UserDetails userDetails = CustomUserDetail.builder()
                    .username(username)
                    .password(sellerDTO.getSePassword())
                    .userNo(sellerDTO.getSeNo())
                    .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_SELLER")))
                    .isEnabled(true)
                    .isCredentialsNonExpired(true)
                    .isAccountNonLocked(true)
                    .isAccountNonExpired(true)
                    .build();

            return userDetails;
        }


        log.info("[Login]: PlaceMember - {}", username);
        UserDetails userDetails = User.builder()
                .username(username)
                .password(placeDTO.getPmPassword())
                .authorities("ROLE_PLACE")
                .build();

        return userDetails;
    }
}
