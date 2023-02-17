package org.plateer.fittingroombo.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.plateer.fittingroombo.product.dto.enums.ProductStatus;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductStatusRequestDTO {
    List<Long> prNos;
    ProductStatus prStatus;
}
