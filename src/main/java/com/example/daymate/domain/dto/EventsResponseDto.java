package com.example.daymate.domain.dto;

import com.example.daymate.domain.entity.Events;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventsResponseDto {

    private int postId;
    private String title;
    private String memo;
    private String eventAt;
    private String completeYn;
    private String createdAt;
    private String userId;


    public static EventsResponseDto from(Events events) {
        return builder()
        .postId(events.getId())
                .title(events.getTitle())
                .memo(events.getMemo())
                .eventAt(events.getEventAt())
                .completeYn(events.getCompleteYn())
                .createdAt(events.getCreatedAt())
                .userId(events.getUserId())
                .build();
    }



}