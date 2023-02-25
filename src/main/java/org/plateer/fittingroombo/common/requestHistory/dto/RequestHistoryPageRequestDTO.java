package org.plateer.fittingroombo.common.requestHistory.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.fittingroombo.common.dto.PageRequestDTO;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class RequestHistoryPageRequestDTO extends PageRequestDTO {
    Long id;
    String type;
    String status;
    String toDate;
    String fromDate;

    public RequestHistoryPageRequestDTO(int page, int size ) { super( page, size ); }

    public RequestHistoryPageRequestDTO(int page, int size, Long id) {
        super( page, size );
        this.id = id;
    }

    public RequestHistoryPageRequestDTO(Long id) {
        this.id = id;
    }
}
