package com.spring.hanghaeblog.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostingService {

//    private final PostingRepository postingRepository;
//
//    public Long detail(Long id, PostingRequestDto requestDto) {
//        Posting posting = postingRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        posting.detail(requestDto);
//        return posting.getId();
//    }
}