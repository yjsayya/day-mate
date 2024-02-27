package com.example.daymate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventRequestDto {

    private String title;
    private String memo;
    private String eventAt;

//    private String userId;

}