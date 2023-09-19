package com.example.instargram.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String loginId;
	private String title;
	private String content;
	private String writer;

	@Builder
	public Member(String loginId, String title, String content, String writer){
		this.loginId = loginId;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
}
