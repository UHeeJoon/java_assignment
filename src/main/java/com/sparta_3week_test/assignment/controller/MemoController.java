package com.sparta_3week_test.assignment.controller;

import com.sparta_3week_test.assignment.models.Memo;
import com.sparta_3week_test.assignment.repository.MemoRepository;
import com.sparta_3week_test.assignment.dto.MemoRequestDto;
import com.sparta_3week_test.assignment.repository.UserRepository;
import com.sparta_3week_test.assignment.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;
    private final UserRepository userRepository;

    @PostMapping("api/memos/post")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {

        return memoRepository.findAllByOrderByCreateAtDesc();
    }

    @GetMapping("/api/memos/{id}")
    public Memo getMemos(@PathVariable Long id) {
        return memoService.inquire(id);
    }

}
