package org.plateer.fittingroombo.common.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroombo.common.security.dto.CustomUserDetail;
import org.plateer.fittingroombo.place.dto.PlaceDTO;
import org.plateer.fittingroombo.place.mapper.PlaceMapper;
import org.plateer.fittingroombo.seller.dto.SellerDTO;
import org.plateer.fittingroombo.seller.mapper.SellerMapper;
import org.plateer.fittingroombo.seller.service.SellerService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        String[] splitName = username.split("_");
        if (splitName.length < 2) {
            throw new IllegalArgumentException("잘 못 된 타입의 아이디");
        }

        String type = splitName[0];
        String id = splitName[1];

        if ("p".equals(type)) {
            PlaceDTO placeDTO = placeMapper.getPlaceById(id);
            if (!Objects.isNull(placeDTO)) {
                log.info("[Login]: PlaceMember - {}", id);
                UserDetails userDetails = CustomUserDetail.builder()
                        .username("p_" + id)
                        .password(placeDTO.getPmPassword())
                        .userNo(placeDTO.getPmNo())
                        .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_PLACE")))
                        .isEnabled(true)
                        .isCredentialsNonExpired(true)
                        .isAccountNonLocked(true)
                        .isAccountNonExpired(true)
                        .build();

                return userDetails;
            }
        }

        if ("s".equals(type)) {
            SellerDTO sellerDTO = sellerMapper.getSellerById(id);
            if (!Objects.isNull(sellerDTO)) {
                log.info("[Login]: Seller - {}", id);
                UserDetails userDetails = CustomUserDetail.builder()
                        .username("s_" + id)
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
        }

        throw new IllegalAccessError("존재하지 않는 사용자");
    }
}
