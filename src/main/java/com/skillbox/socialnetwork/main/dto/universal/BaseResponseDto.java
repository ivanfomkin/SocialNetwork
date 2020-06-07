package com.skillbox.socialnetwork.main.dto.universal;

import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDto extends ErrorResponseDto {

    private String error;
    private Long timestamp;
    private ResponseDto data;

    public BaseResponseDto(ResponseDto data) {
        super("string");
        timestamp = LocalDateTime.now().toEpochSecond(OffsetDateTime.now().getOffset()) * 1000;
        this.data = data;
    }

    public BaseResponseDto(String error) {
        this.error = error;
        this.timestamp = LocalDateTime.now().toEpochSecond(OffsetDateTime.now().getOffset()) * 1000;
    }


}
