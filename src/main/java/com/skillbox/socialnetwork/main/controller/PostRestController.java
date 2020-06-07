package com.skillbox.socialnetwork.main.controller;

import com.skillbox.socialnetwork.main.dto.post.response.PostDto;
import com.skillbox.socialnetwork.main.dto.post.response.PostListDto;
import com.skillbox.socialnetwork.main.dto.universal.BaseResponseDto;
import com.skillbox.socialnetwork.main.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostRestController {

    private final PostService postService;

    private BaseResponseDto baseResponseDto;

    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public PostListDto getPosts(
            @RequestParam String text,
            @RequestParam(name = "date_from", required = false) Long dateFrom,
            @RequestParam(name = "date_to", required = false) Long dateTo,
            @RequestParam(required = false) Integer offset,
            @RequestParam(required = false, defaultValue = "20") Integer itemPerPage
    ) {

        List<PostDto> postResponse =  postService.findPosts(text, dateFrom, dateTo, offset, itemPerPage);
        int total = postResponse.size();

        return new PostListDto("Search completed!", postResponse, total, offset, itemPerPage);
    }

    @GetMapping("/{id]")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto findPostById(
            @PathVariable int id
    ){
        return new BaseResponseDto("Post founded", baseResponseDto.getTimestamp(), postService.findById(id));
    }


}

