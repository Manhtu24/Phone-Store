package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.PageSection;
import com.MTlovec.Phone_Store.response.PageSectionResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;

public interface PageSectionService {
    PaginatedResponse<PageSectionResponse> getAllSections(int page, int size, String search,String searchGroup);

    PageSection createPageSection(PageSection pageSection);

    void deleteSection(Long sectionId);

    void updatePageSection(Long sectionId, PageSection updateSection);
}
