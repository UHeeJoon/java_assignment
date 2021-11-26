package com.sparta_3week_test.assignment.models;

import com.sparta_3week_test.assignment.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Memo extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String memos;

    public Memo(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.memos = requestDto.getMemos();
    }


}
