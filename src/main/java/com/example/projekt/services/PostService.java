package com.example.projekt.services;

import com.example.projekt.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PostService {
    @Autowired
    @Qualifier("jp")
    private WebClient webClient;

    public List<Post> findAll(){
        return webClient
                .get()
                .uri("/posts")
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Post.class))
                .buffer()
                .blockLast();
    }

    public List<Post> findPostsByAppUserId(int userId){
        List<Post> allPosts = this.findAll();

        return allPosts
                .stream()
                .filter(post -> post.getUserId() == userId)
                .toList();

    }
}
