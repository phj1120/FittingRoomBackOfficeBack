package org.plateer.fittingroombo.product.controller;

import lombok.RequiredArgsConstructor;
import org.plateer.fittingroombo.product.dto.ProductDTO;
import org.plateer.fittingroombo.product.dto.UpdateProductStatusRequestDTO;
import org.plateer.fittingroombo.product.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProductChecker {
    private final ProductMapper productMapper;

    public Boolean hasPermission(Long seNo, Long prNo) {
        ProductDTO product = productMapper.getProduct(prNo);
        if (Objects.isNull(product)) {
            throw new RuntimeException("존재하지 않는 상품");
        }

        return Objects.equals(seNo, product.getSeNo());
    }

    public Boolean hasPermission(Long seNo, UpdateProductStatusRequestDTO updateProductStatusRequestDTO) {
        for (Long prNo : updateProductStatusRequestDTO.getPrNos()) {
            if (!hasPermission(seNo, prNo)) {
                return false;
            }
        }
        return true;
    }
}
