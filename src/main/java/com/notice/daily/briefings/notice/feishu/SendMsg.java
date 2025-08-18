package com.notice.daily.briefings.notice.feishu;

import com.alibaba.fastjson2.JSONObject;
import com.notice.daily.briefings.service.HttpService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendMsg {
    @Value("${feishu.robot.link}")
    private String feishuRobotLink;

    @Autowired
    HttpService httpService;

    public void send(String msg) {
        String url = feishuRobotLink;
//        String json = "{'msg_type':'text','content':{'text':'" + msg + "'}}";

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("msg_type", "text");
        JSONObject content = new JSONObject();
        content.put("text", msg);
        jsonObject.put("content", JSONObject.toJSONString(content));


        try {
            httpService.postJson(url, jsonObject.toJSONString());
        } catch (Exception e) {
            log.error("发送飞书消息失败: " + e.getMessage());
        }

    }

}
