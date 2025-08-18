package com.notice.daily.briefings.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

@Service
public class HttpService {

    private final OkHttpClient client;

    public HttpService(OkHttpClient client) {
        this.client = client;
    }

    public String postJson(String url, String json) throws Exception {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                throw new RuntimeException("请求失败, 状态码: " + response.code());
            }
        }
    }
}
