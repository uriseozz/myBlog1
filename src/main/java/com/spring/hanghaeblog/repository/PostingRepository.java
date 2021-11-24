package com.spring.hanghaeblog.repository;


import com.spring.hanghaeblog.domain.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findAllByOrderByModifiedAtDesc();
}
