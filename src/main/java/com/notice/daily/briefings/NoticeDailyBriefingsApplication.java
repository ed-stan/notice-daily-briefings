package com.notice.daily.briefings;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.notice.daily.briefings.mapper")
@EnableScheduling
public class NoticeDailyBriefingsApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(NoticeDailyBriefingsApplication.class)
				.web(WebApplicationType.SERVLET) // 强制 Web 容器模式
				.run(args);
	}
}
