package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.model.PageSection;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.response.PageSectionResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import com.MTlovec.Phone_Store.service.PageSectionService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PageSectionController {

    private final PageSectionService pageSectionService;

    private  final UserService userService;

    @GetMapping("/admin/sections")
    public ResponseEntity<PaginatedResponse<PageSectionResponse>> getAllSections(@RequestHeader("Authorization")String jwt,
                                                            @RequestParam int page,
                                                            @RequestParam int size,
                                                            @RequestParam String searchGroup,
                                                            @RequestParam String searchTitle){
        User user=userService.findByJwt(jwt);
        PaginatedResponse<PageSectionResponse> section=pageSectionService.getAllSections(page,size,searchTitle,searchGroup);
        return  ResponseEntity.ok(section);
    }
    @PostMapping("/admin/sections")
    public ResponseEntity<PageSection> createPageSectios(@RequestHeader("Authorization")String jwt,
                                                        @RequestBody PageSection reqeust){
        User user=userService.findByJwt(jwt);
        PageSection pageSection=pageSectionService.createPageSection(reqeust);
        return ResponseEntity.ok(pageSection);
    }

    @PutMapping("/admin/sections/{sectionId)")
    public ResponseEntity<String> updatePageSection(@RequestHeader("Authorization")String jwt,
                                                    @RequestBody PageSection updateSection,
                                                    @PathVariable Long sectionId){
        User user=userService.findByJwt(jwt);
        pageSectionService.updatePageSection(sectionId,updateSection);
        return ResponseEntity.ok("Update section successfully");
    }

    @DeleteMapping("admin/sections/{sectionId}")
    public  ResponseEntity<String> deletePageSection(@RequestHeader("Authorization")String jwt,
                                                     @PathVariable Long sectionId){
        pageSectionService.deleteSection(sectionId);
        return ResponseEntity.ok("Delete successfully page section");
    }
}
