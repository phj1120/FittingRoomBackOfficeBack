package org.plateer.fittingroombo.common.dto;

import java.util.List;

public class PageSearchRequestDTO<T> extends PageRequestDTO {
    private List<T> types;
    private String keyword;
}
