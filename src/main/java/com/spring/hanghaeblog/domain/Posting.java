package com.spring.hanghaeblog.domain;

import com.spring.hanghaeblog.dto.PostingRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@NoArgsConstructor  //기본생성자 만들 수 있음
@Getter
@Entity  //테이블과 연계됨을 스프링에게 알려줌
public class Posting extends com.spring.hanghaeblog.domain.Timestamped { // 생성,수정 시간을 자동으로 만들어줌(Timestamped 상속)

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Posting(PostingRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void detail(PostingRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
