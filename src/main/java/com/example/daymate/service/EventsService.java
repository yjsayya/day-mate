package com.example.daymate.service;

import com.example.daymate.domain.dto.EventRequestDto;
import com.example.daymate.domain.dto.EventsResponseDto;
import com.example.daymate.domain.entity.Events;
import com.example.daymate.repository.EventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventsService {

    private final EventsRepository eventsRepository;

    /**
     * events 리스트 가져오기
     */
    public List<EventsResponseDto> getEventsList(String eventAt) {
        System.out.println("service");
        List<Events> eventsList = eventsRepository.selectListsOrderByCreatedAt(eventAt);

        System.out.println(eventsList.toString());

        return eventsList.stream()
                .map(EventsResponseDto::from)
                .toList();
    }

    @Transactional
    public List<EventsResponseDto> saveEvent(EventRequestDto dto) {
        String title = dto.getTitle();
        String memo = dto.getMemo();
        String eventAt = dto.getEventAt();
        // event 저장
        eventsRepository.save(Events.of(title,memo,eventAt));
        System.out.println(eventAt);
        // event list 다시 뿌리기
        List<Events> eventsList = eventsRepository.selectListsOrderByCreatedAt(eventAt);
        return eventsList.stream()
                .map(EventsResponseDto::from)
                .toList();
    }

    @Transactional
    public List<EventsResponseDto> updateEvent(EventRequestDto dto, Integer eventId) {
        String title = dto.getTitle();
        String memo = dto.getMemo();
        String eventAt = dto.getEventAt();
        // event 찾기
        Events entity = eventsRepository.findById(eventId).orElseThrow(() ->
            new IllegalArgumentException("There Is No Such Events")
        );
        // event 수정하기
        if (!entity.getTitle().equals(title))
            entity.setTitle(title);
        if (!entity.getMemo().equals(memo))
            entity.setMemo(memo);
        if (!entity.getEventAt().equals(eventAt))
            entity.setEventAt(eventAt);
        // event list 다시 뿌리기
        List<Events> eventsList = eventsRepository.selectListsOrderByCreatedAt(eventAt);
        return eventsList.stream()
                .map(EventsResponseDto::from)
                .toList();
    }

    @Transactional
    public List<EventsResponseDto> deleteEvent(Integer eventId) {
        // event 찾기
        Events entity = eventsRepository.findById(eventId).orElseThrow(() ->
                new IllegalArgumentException("There Is No Such Events")
        );
        // event 삭제
        eventsRepository.updateEventDeletedAt(eventId);
        // event list 다시 뿌리기
        List<Events> eventsList = eventsRepository.selectListsOrderByCreatedAt(entity.getEventAt());
        return eventsList.stream()
                .map(EventsResponseDto::from)
                .toList();
    }



}