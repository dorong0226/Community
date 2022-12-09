package com.example.community.entity;

import com.example.community.dto.CommunityRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@Entity
@NoArgsConstructor
public class Community extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    public Community(String name, String contents) {
        this.name = name;
        this.contents = contents;
    }

    public Community(CommunityRequestDto requestDto) {
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
    }

    public void update(CommunityRequestDto communityRequestDto) {
        this.name = communityRequestDto.getName();
        this.contents = communityRequestDto.getContents();
    }


}