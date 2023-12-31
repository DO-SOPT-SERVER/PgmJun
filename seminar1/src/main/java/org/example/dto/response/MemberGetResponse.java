package org.example.dto.response;

import org.example.domain.Member;
import org.example.domain.SOPT;

public record MemberGetResponse(
	String name,
	String nickname,
	int age,
	SOPT soptInfo
) {
	public static MemberGetResponse of(Member member) {
		return new MemberGetResponse(
			member.getName(),
			member.getNickname(),
			member.getAge(),
			member.getSopt()
		);
	}
}
