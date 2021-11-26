package com.sparta_3week_test.assignment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class MemoRequestDto {
    private final String title;
    private final String memos;
}
