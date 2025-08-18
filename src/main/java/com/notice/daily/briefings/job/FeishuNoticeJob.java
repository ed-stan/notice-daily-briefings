package com.notice.daily.briefings.job;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.notice.daily.briefings.entity.OilPrice;
import com.notice.daily.briefings.notice.feishu.SendMsg;
import com.notice.daily.briefings.service.OilPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public class FeishuNoticeJob {


    @Autowired
    OilPriceService oilPriceService;

    @Autowired
    SendMsg sendMsg;

    @Scheduled(cron = "0 0 9 * * ?")
    public void sendNotice() {
        log.info("Sending daily notice at 9 AM");
        // Add your task logic here
        LambdaQueryWrapper<OilPrice> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(OilPrice::getProvince, OilPrice::getOilType, OilPrice::getPrice)
                .eq(OilPrice::getDate, LocalDate.now()).eq(OilPrice::getProvince, "四川")
                .orderByDesc(OilPrice::getPrice);
        List<OilPrice> list = oilPriceService.list(queryWrapper);
        log.info("list: {}", list);
        StringBuilder sb = new StringBuilder();
        sb.append("今日油价信息：\n");
        for (OilPrice oilPrice : list) {
            sb.append("- ").append(oilPrice.getProvince()).append(" ").append(oilPrice.getOilType())
                    .append(" ").append(oilPrice.getPrice()).append("\n");
        }
        sendMsg.send(sb.toString());

    }



}
