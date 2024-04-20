package com.api.yj.service;

import com.api.yj.dto.Member;

import java.util.List;

public interface MemberService {
    void joinMember(Member member);

    Member findMember(String userName);

    List<Member> findMembers();

}
