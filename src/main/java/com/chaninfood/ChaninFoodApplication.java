package com.chaninfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class ChaninFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChaninFoodApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:4201"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT"));
		configuration.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", configuration);
		CorsFilter corsFilter = new CorsFilter(source);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(corsFilter);
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
