package com.skillbox.socialnetwork.main.service;

import com.skillbox.socialnetwork.main.dto.post.response.PostListDto;

public interface FeedService {

    PostListDto getAllPosts(String token, String name, Integer offset, Integer itemPerPage);
}
