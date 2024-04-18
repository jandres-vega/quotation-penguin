package com.equotationpenguin.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

    private Date time = new Date();
    private String msg;
    private String url;

    public ApiResponse(String msg, String url) {
        this.msg = msg;
        this.url = url.replace("uri=", "");
    }
}
