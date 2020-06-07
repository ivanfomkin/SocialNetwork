package com.skillbox.socialnetwork.main.converter;

import com.skillbox.socialnetwork.main.dto.comment.response.CommentDto;
import com.skillbox.socialnetwork.main.model.PostComment;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 14 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDto postCommentToDto(PostComment postComment) {
        if ( postComment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        return commentDto;
    }
}
