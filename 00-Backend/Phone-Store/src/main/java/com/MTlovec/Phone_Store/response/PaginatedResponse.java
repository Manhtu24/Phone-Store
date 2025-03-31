package com.MTlovec.Phone_Store.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class PaginatedResponse <T>{
    private List<T> data;
    private int totalPage;
    private int currentPage;
}
