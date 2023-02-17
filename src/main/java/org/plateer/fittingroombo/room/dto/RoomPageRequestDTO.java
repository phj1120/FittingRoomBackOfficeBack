package org.plateer.fittingroombo.room.dto;

import org.plateer.fittingroombo.common.dto.PageRequestDTO;

public class RoomPageRequestDTO extends PageRequestDTO {
    RoomSearchType[] type;
    String keyword;

    public RoomPageRequestDTO( int page, int size ) { super( page, size ); }

    public RoomPageRequestDTO( int page, int size, RoomSearchType[] type, String keyword ) {
        super( page, size );
        this.type = type;
        this.keyword = keyword;
    }

    public RoomPageRequestDTO( RoomSearchType[] type, String keyword ) {
        this.type = type;
        this.keyword = keyword;
    }
}
