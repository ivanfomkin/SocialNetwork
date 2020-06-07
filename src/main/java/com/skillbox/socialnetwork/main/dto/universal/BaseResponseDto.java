package com.skillbox.socialnetwork.main.dto.universal;

import lombok.*;

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
        timestamp = new Date().getTime();
        this.data = data;
    }

    public BaseResponseDto(String error) {
        this.error = error;
        this.timestamp = new Date().getTime();
    }
}
