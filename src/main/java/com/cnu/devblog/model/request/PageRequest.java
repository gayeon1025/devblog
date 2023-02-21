package com.cnu.devblog.model.request;

import lombok.Getter;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@Getter
public class PageRequest {
    private int page;
    private int size;

    public PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public void setPage(int page) {
        this.page = Math.max(page, 0);
    }

    public void setSize(int size) {
        int DEFAULT_SIZE = 10;
        int MAX_SIZE = 50;
        this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
    }

    public org.springframework.data.domain.PageRequest of() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return org.springframework.data.domain.PageRequest.of(page, size, sort);
    }
}
