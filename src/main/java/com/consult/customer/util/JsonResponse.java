package com.consult.customer.util;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class JsonResponse<T> {

    private HttpStatus status;

    private String message;

    private List<T> data;

    public JsonResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = Arrays.asList(data);
    }


}
