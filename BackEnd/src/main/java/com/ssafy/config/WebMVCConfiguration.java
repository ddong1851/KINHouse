package com.ssafy.config;

import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.interceptor.ConfirmInterceptor;

@Configuration
@EnableAspectJAutoProxy
@MapperScan(basePackages = { "com.ssafy.**.mapper" }) // com.ssafy.밑 모든 패키지 내부.mapper를 추가
public class WebMVCConfiguration implements WebMvcConfigurer{
	@Autowired
	private ConfirmInterceptor confirm;

	// 로그인을 한 사람만 실행할 수 있는 모든 속성들을 추가해준다.
	// 아래 등록된 패턴들에 대해 인터셉터를 추가한다.
	private final List<String> patterns = Arrays.asList("/board/*");

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(confirm).addPathPatterns(patterns);
	}
}
