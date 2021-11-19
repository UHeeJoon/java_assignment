package com.sparta_3week_test.assignment.service;
import com.sparta_3week_test.assignment.models.Memo;
import com.sparta_3week_test.assignment.models.MemoRepository;
import com.sparta_3week_test.assignment.models.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Memo inquire(Long id){
        return memoRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 아이디가 없습니다")
        );
    }

}
