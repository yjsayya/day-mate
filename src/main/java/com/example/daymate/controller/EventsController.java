package com.example.daymate.controller;

import com.example.daymate.domain.dto.EventGetRequestDto;
import com.example.daymate.domain.dto.EventRequestDto;
import com.example.daymate.domain.dto.EventsResponseDto;
import com.example.daymate.service.EventsService;
import com.example.daymate.utils.protocolUtils.ApiResult;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/events")
@RequiredArgsConstructor
@Validated
public class EventsController {

    private final EventsService eventsService;

    @GetMapping
    public ApiResult<List<EventsResponseDto>> getEventsList(@RequestParam @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") String eventAt) {
        return ApiResult.success(eventsService.getEventsList(eventAt));
    }


    @PostMapping
    public ApiResult<List<EventsResponseDto>> saveEvent(@RequestBody @Valid EventRequestDto eventRequestDto) {
        return ApiResult.success(eventsService.saveEvent(eventRequestDto));
    }

    @PutMapping("/{event_id}")
    public ApiResult<List<EventsResponseDto>> updateEvent(@PathVariable(name = "event_id") Integer eventId,
                                                          @RequestBody @Valid EventRequestDto eventRequestDto) {
        return ApiResult.success(eventsService.updateEvent(eventRequestDto, eventId));
    }

    @DeleteMapping("/{event_id}")
    public ApiResult<List<EventsResponseDto>> deleteEvent(@PathVariable(name = "event_id") Integer eventId) {
        return ApiResult.success(eventsService.deleteEvent(eventId));
    }

}