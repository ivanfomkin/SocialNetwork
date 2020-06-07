package com.skillbox.socialnetwork.main.dto.post.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skillbox.socialnetwork.main.dto.universal.BaseResponseDto;
import com.skillbox.socialnetwork.main.model.Person;
import com.skillbox.socialnetwork.main.model.Post;
import com.skillbox.socialnetwork.main.model.PostComment;
import com.skillbox.socialnetwork.main.model.PostLike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto extends BaseResponseDto {

    private int id;
    private long time;
    private Person author;
    private String title;
    @JsonProperty("post_text")
    private String text;
    @JsonProperty("is_blocked")
    private boolean blocked;
    private List<PostLike> likes;
    private List<PostComment> comments;

    public static PostDto postToDo(Post post){

        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setTime(post.getTime().atStartOfDay(ZoneOffset.UTC).toEpochSecond() * 1000);
        postDto.setAuthor(post.getAuthor());
        postDto.setText(post.getPostText());
        postDto.setBlocked(post.getIsBlocked());
        postDto.setLikes(post.getLikes());
        postDto.setComments(post.getComments());

        return postDto;
    }
}
