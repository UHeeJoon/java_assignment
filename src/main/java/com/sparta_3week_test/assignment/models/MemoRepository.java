package com.sparta_3week_test.assignment.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByCreateAtDesc();
}
