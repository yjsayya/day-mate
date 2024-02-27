package com.example.daymate.utils.protocolUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
@AllArgsConstructor
public class ApiResult<T> {

    private String message;
    private T result;


    public static <T> ApiResult<T> success() {
        return new ApiResult<>("SUCCESS", null);
    }

    public static <T> ApiResult<T> success(T result) {
        return new ApiResult<>("SUCCESS", result);
    }

    public static ApiResult<Void> error(String resultCode) {
        return new ApiResult<>(resultCode, null);
    }

}