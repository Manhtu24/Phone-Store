//package com.MTlovec.Phone_Store.service;
//
//import com.MTlovec.Phone_Store.exception.NotFoundException;
//import com.MTlovec.Phone_Store.model.News;
//import com.MTlovec.Phone_Store.repository.NewsRepository;
//import com.MTlovec.Phone_Store.response.PaginatedResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class NewsServiceImpl implements NewsService{
//
//    private final NewsRepository newsRepository;
//
//    @Override
//    public PaginatedResponse<News> getPosts(int page, int size, String sortDirection) {
//        Pageable pageable= PageRequest.of(page, size);
//        Page<News> news=newsRepository.getPost(pageable,sortDirection);
//        PaginatedResponse<News> response= new PaginatedResponse<>(news.getContent(),
//                                                                  news.getTotalPages(),
//                                                        news.getNumber()+1);
//        return response;
//    }
//
//    @Override
//    public News getPost(Long newsId) {
//        News post = newsRepository.findById(newsId).orElseThrow(()->
//            new NotFoundException("Could not found this post"));
//        return post ;
//    }
//
//    @Transactional
//    @Override
//    public void deletePost(Long newsId) {
//        News post= newsRepository.findById(newsId).orElseThrow(()->
//                new NotFoundException("Can not found post with id: "+newsId)
//        );
//        newsRepository.delete(post);
//    }
//}
