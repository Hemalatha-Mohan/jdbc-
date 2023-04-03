package com.springboot.training.jdbcproject.service;

import com.springboot.training.jdbcproject.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class PostServiceImpl implements PostService{

    @Value("${external.api.url}")
    private String postApiBaseUrl;


    @Autowired
    private RestTemplate restTemplate;

    @Override

    public PostModel[] getAllPosts()
    {
        PostModel[] result = restTemplate.getForObject(postApiBaseUrl+"/posts", PostModel[].class);
        System.out.println(result);

        return result;

    }


    @Override

    public void getAllPostsByUserId(@PathVariable("userId")Long userId)
    {

    }

    @Override
    public PostModel createPost(PostModel postModel) {
        PostModel model = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PostModel> httpEntity = new HttpEntity<>(postModel,headers);
        ResponseEntity<PostModel> newPostEntity = restTemplate.postForEntity(postApiBaseUrl+"/posts",httpEntity,PostModel.class);

        if(newPostEntity.getStatusCode() == HttpStatus.CREATED) {

            model = newPostEntity.getBody();
        }
        return model;
    }

    @Override
    public PostModel updatePost(PostModel postModel, Long id) {

        PostModel model = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PostModel> httpEntity = new HttpEntity<>(postModel,headers);
        ResponseEntity<PostModel> upPostEntity = restTemplate.exchange(postApiBaseUrl+"/posts/{id}",HttpMethod.PUT,httpEntity,PostModel.class, id);

        if(upPostEntity.getStatusCode() == HttpStatus.OK) {

            model = upPostEntity.getBody();
        }
        return  model;
    }



    @Override
    public void deletePost(Long id) {
        restTemplate.delete(postApiBaseUrl+"/posts/{id}",id);
    }
}
