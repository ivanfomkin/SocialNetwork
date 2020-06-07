package com.skillbox.socialnetwork.main.controller;

import com.skillbox.socialnetwork.main.dto.post.response.PostListDto;
import com.skillbox.socialnetwork.main.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.skillbox.socialnetwork.main.security.jwt.JwtTokenProvider.HEADER;

@RequestMapping("/api/v1/feeds")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @GetMapping
    public PostListDto getFeeds(
            @RequestHeader(value = HEADER) String token,
            @RequestParam(value = "name", defaultValue = "", required = false) String name,
            @RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset,
            @RequestParam(value = "itemPerPage", defaultValue = "20", required = false) Integer itemPerPage){
        return feedService.getAllPosts(token, name, offset, itemPerPage);
    }

}
