package com.example.community.service;

import com.example.community.dto.CommunityRequestDto;
import com.example.community.entity.Community;
import com.example.community.repository.CommunityRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CommunityService {
    static private CommunityRepository communityRepository;

    @Transactional
    public Community createGeul(CommunityRequestDto requestDto) {
        Community community = new Community(requestDto);
        communityRepository.save(community);
        return community;
    }

    @Transactional(readOnly = true)
    public List<Community> getGeuls() {
        return communityRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, CommunityRequestDto requestDto) {
        Community community = communityRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("비밀번호가 틀립니다..")
        );
        community.update(requestDto);
        return community.getId();
    }

    @Transactional
    public Long deleteGeuls(Long password) {
        communityRepository.deleteById(password);
        return password;
    }
}
