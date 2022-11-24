package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.MemberService;
import com.example.demo.service.QuizBoardService;
import com.example.demo.service.TrialExam2Service;
import com.example.demo.service.TrialExam3Service;
import com.example.demo.service.TrialExam4Service;
import com.example.demo.service.TrialExam5Service;
import com.example.demo.service.TrialExamService;

import vo.MemberVo;

@Controller
public class IncorrectNoteController {
	@Autowired //멤버
	private MemberService service;
	@Autowired //개별문제
	private QuizBoardService service1;
	@Autowired //국어
	private TrialExamService service2;
	@Autowired //영어
	private TrialExam2Service service3;
	@Autowired //수학
	private TrialExam3Service service4;
	@Autowired //사탐
	private TrialExam4Service service5;
	@Autowired //과탐
	private TrialExam5Service service6;


	
	//개별문제 오답
	@RequestMapping(value = "/NormalQuizIncorrect", method = RequestMethod.GET)
	public ModelAndView NormalQuizIncorrect(@RequestParam(defaultValue = "1") int page, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		if(loginId != null && loginId.length() > 0) {
	      	}
		ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
		mv.addObject("incorrectPage", service1.makeQuizIncorrectPage(page));
		mv.setViewName("MyPage/NormalQuizIncorrect"); 
		return mv;
	}
	
	//국어 모고 오답
		@RequestMapping(value = "/KoreanIncorrectIncorrect", method = RequestMethod.GET)
		public ModelAndView KoreanIncorrectIncorrect(@RequestParam(defaultValue = "1") int page, HttpSession session) {
			String loginId = (String) session.getAttribute("loginId");
			if(loginId != null && loginId.length() > 0) {
		      	}
			ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
			mv.addObject("trialPage", service2. makeTrialIncorrectPage(page));
			mv.setViewName("MyPage/KoreanIncorrectIncorrect"); 
			return mv;
		}
		
		//영어 모고 오답
		@RequestMapping(value = "/EnglishIncorrectIncorrect", method = RequestMethod.GET)
		public ModelAndView EnglishIncorrectIncorrect(@RequestParam(defaultValue = "1") int page, HttpSession session) {
			String loginId = (String) session.getAttribute("loginId");
			if(loginId != null && loginId.length() > 0) {
		      	}
			ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
			mv.addObject("trialPage", service3. makeTrialIncorrectPage(page));
			mv.setViewName("MyPage/EnglishIncorrectIncorrect"); 
			return mv;
		}
		
		//수학 모고 오답
		@RequestMapping(value = "/MathIncorrectIncorrect", method = RequestMethod.GET)
		public ModelAndView MathIncorrectIncorrect(@RequestParam(defaultValue = "1") int page, HttpSession session) {
			String loginId = (String) session.getAttribute("loginId");
			if(loginId != null && loginId.length() > 0) {
		      	}
			ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
			mv.addObject("trialPage", service4. makeTrialIncorrectPage(page));
			mv.setViewName("MyPage/MathIncorrectIncorrect"); 
			return mv;
		}
	
		//사탐 모고 오답
		@RequestMapping(value = "/SocialIncorrectIncorrect", method = RequestMethod.GET)
		public ModelAndView SocialIncorrectIncorrect(@RequestParam(defaultValue = "1") int page, HttpSession session) {
			String loginId = (String) session.getAttribute("loginId");
			if(loginId != null && loginId.length() > 0) {
		      	}
			ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
			mv.addObject("trialPage", service5. makeTrialIncorrectPage(page));
			mv.setViewName("MyPage/SocialIncorrectIncorrect"); 
			return mv;
		}
	
		//과탐 모고 오답
		@RequestMapping(value = "/SienceIncorrectIncorrect", method = RequestMethod.GET)
		public ModelAndView SienceIncorrectIncorrect(@RequestParam(defaultValue = "1") int page, HttpSession session) {
			String loginId = (String) session.getAttribute("loginId");
			if(loginId != null && loginId.length() > 0) {
		      	}
			ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
			mv.addObject("trialPage", service6. makeTrialIncorrectPage(page));
			mv.setViewName("MyPage/SienceIncorrectIncorrect"); 
			return mv;
		}
	
	
}
