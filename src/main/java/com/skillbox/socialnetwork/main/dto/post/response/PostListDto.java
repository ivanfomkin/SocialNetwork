package com.skillbox.socialnetwork.main.dto.post.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skillbox.socialnetwork.main.dto.universal.BaseResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostListDto extends BaseResponseDto {

    @JsonProperty("data")
    private List<PostDto> postList;
    private long total;
    private int offset;
    private int perPage;

    public PostListDto(String error, List<PostDto> postList, int total, int offset, int perPage) {
        super(error);
        this.postList = postList;
        this.total = total;
        this.offset = offset;
        this.perPage = perPage;
    }
}
