package com.notice.daily.briefings;

import com.notice.daily.briefings.job.FeishuNoticeJob;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeDailyBriefingsApplicationTests {

	@Autowired
	FeishuNoticeJob feishuNoticeJob;

	@Test
	void contextLoads() {
		feishuNoticeJob.sendNotice();
	}

}
