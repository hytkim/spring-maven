package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Value("${file.upload.path}")
	private String uploadPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**") // URL, 하위경로도 다 포함하겠다
		.addResourceLocations("file:///"+uploadPath, ""); // 실제경로 : Location, 하나의 URL에 여러 경로를 매핑 가능함
		 // = > ubuntu file://, window file:///
	}

}
