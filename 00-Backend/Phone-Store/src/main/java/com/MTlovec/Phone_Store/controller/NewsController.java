//package com.MTlovec.Phone_Store.controller;
//
//import com.MTlovec.Phone_Store.model.News;
//import com.MTlovec.Phone_Store.response.PaginatedResponse;
//import com.MTlovec.Phone_Store.service.NewsService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//public class NewsController {
//
//    private final NewsService newsService;
//
//    //get all post (has paginat ion)
//    @GetMapping("/news")
//    public ResponseEntity<PaginatedResponse<News>> getPosts(@RequestParam(defaultValue = "0")int page,
//                                                            @RequestParam(defaultValue = "10") int size,
//                                                            @RequestParam(defaultValue ="ASC" ) String sortDirection){
//        PaginatedResponse<News> newsResponse= newsService.getPosts(page,size,sortDirection);
//        return  ResponseEntity.ok(newsResponse);
//    }
//
//    //get a post
//    @GetMapping("/news/{newsId}")
//    public ResponseEntity<News> getPost(@PathVariable Long newsId){
//        News post= newsService.getPost(newsId);
//        return ResponseEntity.ok(post);
//    }
//
//    //create a new post
//
//    //update a post
//
//    @DeleteMapping("/admin/{newsId}")
//    public ResponseEntity<String> deletePost(@PathVariable Long newsId,
//                                             @RequestHeader("Authorization")String jwt){
//        newsService.deletePost(newsId);
//        return ResponseEntity.ok("Delete post successfully with id: "+newsId);
//    }
//}
