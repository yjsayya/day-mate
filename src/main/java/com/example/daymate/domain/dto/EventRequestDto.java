package com.example.daymate.domain.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventRequestDto {

    @NotNull @NotBlank @Size(min = 1, max = 200, message = "[유효성 검사] 제목")
    private String title;

    @Size(max=300, message = "[유효성 검사] 메모")
    private String memo;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "[유효성 검사] 날짜 형식이 올바르지 않습니다!")
    private String eventAt;

//    private String userId;

}