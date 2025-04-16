package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.model.News;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.request.NewsRequest;
import com.MTlovec.Phone_Store.response.NewResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import com.MTlovec.Phone_Store.service.NewsService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class NewsController {

    private final NewsService newsService;

    private final UserService userService;

    @GetMapping("/news")
    public ResponseEntity<PaginatedResponse<NewResponse>> getPosts(@RequestParam(defaultValue = "0") int page ,
                                                                  @RequestParam(defaultValue = "6") int size,
                                                                  @RequestParam String search){
        PaginatedResponse<NewResponse> newsResponse=newsService.getPosts(page,size,search);
        return ResponseEntity.ok(newsResponse);
    }

    @PostMapping("/admin/news")
    public ResponseEntity<NewResponse> createPost(@RequestHeader("Authorization")String jwt,
                                                  @RequestBody NewsRequest newsRequest){
        User user=userService.findByJwt(jwt);
        NewResponse newResponse=newsService.createPost(newsRequest);
        return  ResponseEntity.ok(newResponse);
    }

    @PutMapping("/admin/news/{newsId}")
    public ResponseEntity<String>updatePost(@RequestHeader("Authorization")String jwt,
                                            @RequestBody NewsRequest updateNews,
                                            @PathVariable Long newsId){
        User user=userService.findByJwt(jwt);
        newsService.updatePost(newsId,updateNews);
        log.info("Update post successfully");
        return ResponseEntity.ok("Update  successfully post id: "+newsId);
    }
    @DeleteMapping("/admin/news/{newsId}")
    public ResponseEntity<String> deletePost(@RequestHeader("Authorization")String jwt,
                                             @PathVariable Long newId) throws IOException {
        User user=userService.findByJwt(jwt);
        newsService.deletePost(newId);
        log.info("Delete Successfully");
        return ResponseEntity.ok("Delete Successfully Post with id:  "+newId);
    }
}
