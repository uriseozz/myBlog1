package com.spring.hanghaeblog.controller;


import com.spring.hanghaeblog.domain.Posting;
import com.spring.hanghaeblog.dto.PostingRequestDto;
import com.spring.hanghaeblog.repository.PostingRepository;
import com.spring.hanghaeblog.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingRepository postingRepository;
    private final PostingService postingService;

    @PostMapping("/api/postings")
    public Posting creatPosting(@RequestBody PostingRequestDto requestDto) {
        Posting posting = new Posting(requestDto);
        return  postingRepository.save(posting);
    }

    @GetMapping("/api/postings")
    public List<Posting> getPosting() {
        return postingRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/postings/{id}")
    public Posting detail(@PathVariable Long id) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException()
        );
        return posting;
    }

    @DeleteMapping("/api/postings/{id}")
    public Long deletePosting(@PathVariable Long id) {
        postingRepository.deleteById(id);
        return id;
    }
}
