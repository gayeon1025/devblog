package com.cnu.devblog.service;

import com.cnu.devblog.model.type.Tag;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TagService {

    public List<Tag> getTags() {
        return Arrays.stream(Tag.values()).toList();
    }
}
