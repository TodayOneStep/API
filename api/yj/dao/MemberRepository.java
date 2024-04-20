package com.api.yj.dao;

import com.api.yj.dto.Member;

import java.util.List;

public interface MemberRepository {
    void saveMember(Member member);

    Member findByName(String userName);

    List<Member> findAll();

}
