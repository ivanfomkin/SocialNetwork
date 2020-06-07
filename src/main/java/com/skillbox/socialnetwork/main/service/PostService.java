package com.skillbox.socialnetwork.main.service;

import com.skillbox.socialnetwork.main.dto.post.response.PostDto;
import com.skillbox.socialnetwork.main.model.Post;

import java.util.List;

public interface PostService {

    List<PostDto> getAll(String text, long dateFrom, long dateTo, int offset, int itemPerPage);

    Post findById(Integer id);

    Post save(Post post);
}
