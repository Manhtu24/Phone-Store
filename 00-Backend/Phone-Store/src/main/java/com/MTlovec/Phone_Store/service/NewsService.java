package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.News;
import com.MTlovec.Phone_Store.response.PaginatedResponse;

public interface NewsService {

    PaginatedResponse<News> getPosts(int page, int size, String sortDirection);

    News getPost(Long newsId);

    void deletePost(Long newsId);
}
