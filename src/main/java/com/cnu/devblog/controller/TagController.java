package com.cnu.devblog.controller;

import com.cnu.devblog.model.type.Tag;
import com.cnu.devblog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public List<Tag> getTags() {
        return tagService.getTags();
    }
}
