package com.api.yj.controller;

import com.api.yj.dto.Member;
import com.api.yj.service.MemberService;
import com.api.yj.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {

    private Long userId = 1L;
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String memberForm() {
        return "memberForm";
    }

    @GetMapping("/members/one")
    public String findMemberForm() {
        return "findMemberForm";
    }

    // 회원 가입
    @PostMapping("/members")
    public String joinMember(Member member) {
        member.setUserId(userId++);
        memberService.joinMember(member);
        return "joinMemberView";
    }

    // 회원 이름으로 조회 (회원 한 명)
    @PostMapping("/members/one")
    public ModelAndView findMember(String userName) {
        return setMV("member", memberService.findMember(userName), "findMemberView");
    }

    // 모든 회원 조회
    @PostMapping("/members/all")
    public ModelAndView findMembers() {
        return setMV("memberList", memberService.findMembers(), "findMembersView");
    }

    // ModelAndView 값 세팅 및 반환 메서드
    private ModelAndView setMV(String objName, Object object, String viewName) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(objName, object);
        mv.setViewName(viewName);
        return mv;
    }
}
