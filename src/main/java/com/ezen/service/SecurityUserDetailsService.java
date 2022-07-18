package com.ezen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ezen.domain.Member;
import com.ezen.domain.SecurityUser;
import com.ezen.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> member = memberRepo.findById(username);
		
		if(member.isPresent()) {
			Member member1 = member.get();
			return new SecurityUser(member1);
		}else {
			throw new UsernameNotFoundException(username+"사용자가없음");
		}
	
	}

}
