package com.api.yj.service;

import com.api.yj.dao.MemberRepository;
import com.api.yj.dao.MemoryMemberRepository;
import com.api.yj.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void joinMember(Member member) {
        memberRepository.saveMember(member);
    }

    @Override
    public Member findMember(String userName) {
        return memberRepository.findByName(userName);
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

}
