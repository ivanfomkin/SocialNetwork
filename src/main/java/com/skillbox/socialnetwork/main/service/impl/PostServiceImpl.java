package com.skillbox.socialnetwork.main.service.impl;

import com.skillbox.socialnetwork.main.converter.DateConvert;
import com.skillbox.socialnetwork.main.dto.post.response.PostDto;
import com.skillbox.socialnetwork.main.model.Post;
import com.skillbox.socialnetwork.main.repository.PostRepository;
import com.skillbox.socialnetwork.main.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final DateConvert dateConvert;

    @Autowired
    public PostServiceImpl(PostRepository repository, DateConvert dateConvert) {
        this.repository = repository;
        this.dateConvert = dateConvert;
    }


    @Override
    public List<PostDto> getAll(String text, long dateFrom, long dateTo, int offset, int itemPerPage) {

        int limit = itemPerPage < 1 ? 10 : itemPerPage;
        PageRequest pageRequest = PageRequest.of(offset / itemPerPage, limit);

        LocalDate dateF = dateConvert.longToDate(dateFrom);
        LocalDate dateT = dateConvert.longToDate(dateTo);

        Page<Post> allPosts = repository.findAllPost(text, dateF, dateT, pageRequest);

        if (allPosts.isEmpty()) {
            throw new EntityNotFoundException("Not Found");
        }

        List<PostDto> postList = new ArrayList<>();
        for (Post post : allPosts) {
            PostDto postDto = PostDto.postToDo(post);
            postList.add(postDto);
        }
        return postList;
    }

    @Override
    public Post findById(Integer id) {
        return repository.findPostById(id);
    }

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }
}
