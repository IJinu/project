package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.MemberService;

import vo.MemberVo;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	@Autowired
	private MemberService service2;
	
	//회원가입
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "join/join_form";
	}
//회원가입 여부
	@RequestMapping("/join")
	public String join(MemberVo member) {
		if (service.join(member)) {

			return "join/join_success";
		} else {
			return "join/join_fail";
		}
	}


   //로그인 여부
	@RequestMapping("/login")
	public String login(String id, @RequestParam("password") String password, HttpSession session) {
		if (service.login(id, password)) {
			session.setAttribute("loginId", id);

			return "join/login_success";
		} else {
			return "join/login_fail";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 세션 무효화.
		session.invalidate();
		return "index";
	}
	 
	 
	  //멤버리스트
		@RequestMapping(value = "/memberlist", method = RequestMethod.GET)
		public ModelAndView memberlist(@RequestParam(defaultValue = "1") int page, HttpSession session) {
			String loginId = (String) session.getAttribute("loginId");
			if(loginId != null && loginId.length() > 0) {
					}
			// 퀴즈 게시판 카테고리 초기화.
			session.removeAttribute("category");
			ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
			mv.addObject("memberPage", service2.makeMemberPage(page));
			mv.setViewName("board/memberlist");
			return mv;
		}
	
	  
	  //회원정보 수정 폼
	  @RequestMapping("/userupdateForm")
	  public ModelAndView updateForm(int memberNum) { 
		  ModelAndView mv = new ModelAndView("userupdate_form");
	  mv.addObject("original1", service.readinfo(memberNum)); return mv; }
	  
	  
	  //회원정보 수정
	  @RequestMapping(value="/userupdate",method = RequestMethod.POST) 
	  public ModelAndView update(MemberVo member) {
      ModelAndView mv = new ModelAndView();
	  int result = service.update(member); 
	  if(result>0) { mv.addObject("memberNum", member.getMemberNum()); 
	  mv.setViewName("userupdate"); 
	  }else {
	  mv.setViewName("userupdate_fail");
	  }
	  return mv; 
	  }
	  
	  
	  //회원탈퇴
	  @RequestMapping("/userdelete")
	     public ModelAndView delete(@RequestParam("memberNum") int memberNum) {
		  ModelAndView mv = new ModelAndView(); 
		  int result = service.delete(memberNum);
	      mv.addObject("deleteResult", result); mv.setViewName("userdelete"); 
	      return mv; 
	    } 
}