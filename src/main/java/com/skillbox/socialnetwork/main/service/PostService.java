package com.skillbox.socialnetwork.main.service;

import com.skillbox.socialnetwork.main.dto.post.response.PostDto;
import com.skillbox.socialnetwork.main.model.Post;

import java.util.List;

public interface PostService {

    List<PostDto> findPosts(String text, long dateFrom, long dateTo, int offset, int itemPerPage);

    PostDto findById(Integer id);

    PostDto editPost(int id, long publishDate, Post post);

    Post save(Post post);
}
