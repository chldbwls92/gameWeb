package com.chldbwls.spring.gameWeb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.chldbwls.spring.gameWeb.common.FileManager;
import com.chldbwls.spring.gameWeb.common.VideoManager;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// 게임 파일
		registry.addResourceHandler("/game/**")
		.addResourceLocations("file://" + FileManager.FILE_UPLOAD_PATH + "/");
		
		// 영상 파일
		registry.addResourceHandler("/videos/**")
		.addResourceLocations("file://" + VideoManager.FILE_UPLOAD_PATH + "/");
	}
	
}
