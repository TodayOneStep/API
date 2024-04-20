package com.api.yj.dao;

import com.api.yj.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private Long seq = 1L;
    private static final Map<Long, Member> store = new HashMap<>();

    @Override
    public void saveMember(Member member) {
        store.put(seq++, member);
    }

    @Override
    public Member findByName(String userName) {
        for (Long seq : store.keySet()) {
            if(store.get(seq).getUserName().equals(userName)){
                return store.get(seq);
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        int count = 0;
        for (Long seq : store.keySet()) {
            memberList.set(count++, store.get(seq));
        }
        return null;
    }

}
