package com.spring.hanghaeblog.domain;

import com.spring.hanghaeblog.dto.PostingRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor  //기본생성자 만들 수 있음
@Getter
@Entity  //테이블과 연계됨을 스프링에게 알려줌
public class reply {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    //글 번호
    @Column(nullable = false)
    private long bon;

    //작성자 이름
    @Column(unique = true)
    private String writer;

    @Column(nullable = false)
    private String comment;


    public Posting(long bon, String writer, String comment) {
        this.bon = bon;
        this.writer = writer;
        this.comment = comment;
    }

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
