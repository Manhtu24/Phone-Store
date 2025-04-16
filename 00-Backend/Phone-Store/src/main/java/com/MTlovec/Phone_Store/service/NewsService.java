package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.News;
import com.MTlovec.Phone_Store.request.NewsRequest;
import com.MTlovec.Phone_Store.response.NewResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;

import java.io.IOException;

public interface NewsService {
    NewResponse createPost(NewsRequest request);
    void updatePost(Long id, NewsRequest request);
    void deletePost(Long id) throws IOException;
    PaginatedResponse<NewResponse> getPosts(int page, int size, String search);
}
