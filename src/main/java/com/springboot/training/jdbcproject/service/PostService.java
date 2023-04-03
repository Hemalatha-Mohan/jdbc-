package com.springboot.training.jdbcproject.service;

import com.springboot.training.jdbcproject.model.PostModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostService {

    public PostModel[] getAllPosts();

    public void getAllPostsByUserId(Long userId);

    public PostModel createPost(PostModel postModel);
    public PostModel updatePost( PostModel postModel, Long postId);
    public void deletePost( Long postId);
}


