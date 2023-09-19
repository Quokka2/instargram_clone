package com.example.instargram.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequest {

	private String loginId;
	private String title;
	private String content;
	private String nickname;

	private MemberRequest(String loginId, String title, String content, String nickname){

		this.loginId = loginId;
		this.title = title;
		this.content = content;
		this.nickname = nickname;
	}

}
