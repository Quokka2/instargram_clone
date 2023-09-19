package com.example.instargram.service;

import com.example.instargram.domain.UserRepository;
import com.example.instargram.domain.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final UserRepository userRepository;

	public void write(MemberRequest memberRequest){
		//userRepository.save(memberRequest);
	}


}
