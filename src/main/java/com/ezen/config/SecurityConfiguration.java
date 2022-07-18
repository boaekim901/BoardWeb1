package com.ezen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.ezen.service.SecurityUserDetailsService;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private SecurityUserDetailsService securityUserDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
		security.authorizeRequests().antMatchers("/","/system/**").permitAll();
		security.authorizeRequests().antMatchers("/board/**").authenticated();
		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		security.csrf().disable(); 
		
		security.formLogin().loginPage("/system/login").defaultSuccessUrl("/board/getBoardList",true);
		
		security.exceptionHandling().accessDeniedPage("/system/accessDenied");
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		//테이블의 사용자 정보를 Details 타입으로 변환
		security.userDetailsService(securityUserDetailsService);
		
		return security.build();
		
	}
}
