package com.skillbox.socialnetwork.main.service.impl;

import com.skillbox.socialnetwork.main.dto.post.response.PostDto;
import com.skillbox.socialnetwork.main.dto.post.response.PostListDto;
import com.skillbox.socialnetwork.main.model.Person;
import com.skillbox.socialnetwork.main.repository.FeedRepository;
import com.skillbox.socialnetwork.main.repository.PersonRepository;
import com.skillbox.socialnetwork.main.security.jwt.JwtTokenProvider;
import com.skillbox.socialnetwork.main.service.FeedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FeedServiceImpl implements FeedService {

    private final JwtTokenProvider jwtTokenProvider;
    private final FeedRepository feedRepository;
    private final PersonRepository personRepository;

    public FeedServiceImpl(JwtTokenProvider jwtTokenProvider, FeedRepository feedRepository, PersonRepository personRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.feedRepository = feedRepository;
        this.personRepository = personRepository;
    }

    @Override
    public PostListDto getAllPosts(String token, String name, Integer offset, Integer itemPerPage) {

        Integer userId = Integer.parseInt(jwtTokenProvider.getUsername(token));
        Person person = personRepository.findPersonById(userId);

        Integer id = person.getId();
        Page<PostDto> page = feedRepository.getAllPosts(id, name, PageRequest.of(offset,itemPerPage))
                .map(PostDto::postToDo);
        return new PostListDto(page.toList(), page.getTotalElements(), offset, itemPerPage);
    }
}
