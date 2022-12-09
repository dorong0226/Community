package com.example.community.controller;

import com.example.community.dto.CommunityRequestDto;
import com.example.community.entity.Community;
import com.example.community.service.CommunityService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class CommunityController {

    static private CommunityService communityService;
//   MemoService와 DB 공유되야 하므로 선언해준다.

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/geuls")
    public Community createGeul(@RequestBody CommunityRequestDto requestDto) {
        return communityService.createGeul(requestDto);
    }

    @GetMapping("/api/geuls")
    public List<Community> getGeuls() {
        return communityService.getGeuls();
    }

    @PutMapping("/api/geuls/{password}")
    public Long updateGeul(@PathVariable Long password, @RequestBody CommunityRequestDto requestDto) {
        return communityService.update(password, requestDto);
    }

    @DeleteMapping("/api/geuls/{password}")
    public Long deleteGeul(@PathVariable Long password) {
        return communityService.deleteGeuls(password);
    }
}
