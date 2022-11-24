package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.TrialExamService;

import vo.QuizBoardVo;
import vo.TrialExamVo;
import vo.TrialIncorrectCountVo;

@Controller
public class KoreanTrialExamController {
@Autowired
private TrialExamService service;


 //종합문제
 @RequestMapping(value = "/KoreanTrialExam", method = RequestMethod.GET)
 public ModelAndView trialExam(@RequestParam(defaultValue = "1") int page, HttpSession session) {
	String loginId = (String) session.getAttribute("loginId");
	if(loginId != null && loginId.length() > 0) {
			}
	// 퀴즈 게시판 카테고리 초기화.
	session.removeAttribute("category");
	ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
	mv.addObject("trialPage", service.makeTrialPage(page));
	mv.setViewName("board/TrialExamBoard");
	
	return mv;
}
 
	//상세보기
		@RequestMapping("/trialRead")
		public ModelAndView trialRead(int trialNum, HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			
			TrialExamVo tr = service.selectTrial(trialNum, loginId);
			 ModelAndView mv = new ModelAndView();
				
			// 로그인 확인 후, 모든 정보를 출력하기 위해 vo에서 꺼내며 해당 퀴즈를 맞춘 이력이 있는지 확인한다. 
			// 로그인 실패시 로그인 페이지로 전달한다.
			if (loginId != null && loginId.length() > 0) {
				mv.addObject("IChistory", service.selectTrialIncorrectHistory(loginId, trialNum));
				mv.addObject("tr", tr);
				mv.setViewName("Trial/TrialRead");
				mv.addObject("maxNumber", service.maxPage(tr));
			} else {
				mv.setViewName("redirect:main");
			}
			return mv;
		}
		
		//상세보기 헤드
				@RequestMapping(value="/trialHDRead", method=RequestMethod.GET)
				public ModelAndView trialHDRead(int trialNum, HttpSession session) {
					// 로그인 확인용.
					String loginId = (String)session.getAttribute("loginId");
					TrialExamVo tr = service.selectTrial(trialNum, loginId);
					 ModelAndView mv = new ModelAndView();
					// 로그인 확인 후, 모든 정보를 출력하기 위해 vo에서 꺼내며 해당 퀴즈를 맞춘 이력이 있는지 확인한다. 
					// 로그인 실패시 로그인 페이지로 전달한다.
					if (loginId != null && loginId.length() > 0) {
						mv.addObject("history", service.selectTrialIncorrectHistory(loginId, trialNum));
						mv.addObject("tr", tr);
						mv.setViewName("Trial/TrialHDRead");
					} else {
					
					}
					return mv;
				}
		
		
		//정답확인 & 오답노트
		@RequestMapping(value = "/TrialResult", method = RequestMethod.POST)
		public ModelAndView trialResult(int trialNum, @RequestParam("selectedTrialAnswer") String selectedTrialAnswer, HttpSession session,
				String trialTitle , String trialType, String trialChallenger) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			ModelAndView mv = new ModelAndView();
			//sqa = selectedQuizAnswer
			int sta = Integer.parseInt(selectedTrialAnswer);
			// 로그인 확인 후, 성공 시에는 해당 퀴즈 정답 DB에 입력, 실패 시 QuizBoard 로 이동.
			if (loginId != null && loginId.length() > 0) {
				TrialIncorrectCountVo vo = new TrialIncorrectCountVo(loginId, trialNum,trialTitle,trialType,trialChallenger);
				TrialExamVo tr = service.selectTrial(trialNum, loginId);
				mv.addObject("trialResult", service.insertTrialAnswer(vo,sta));
				mv.addObject("trialNum", trialNum);
				System.out.println("trialNum"+ trialNum);
				mv.addObject("tr", tr);
				mv.addObject("maxNumber", service.maxPage(tr));
				mv.setViewName("Trial/TrialResult");
				System.out.println("trialChallenger"+trialChallenger);
		
			} else {
				mv.setViewName("redirect:loginForm");
			}
			return mv;
		}
	
 
//종합문제 헤드 등록 폼
	@RequestMapping("/trialHDWriteForm")
	public ModelAndView trialHDWriteForm(HttpSession session) {
		// 로그인 확인용.
		String loginId = (String)session.getAttribute("loginId");
		ModelAndView mv = new ModelAndView();
		if (loginId != null && loginId.length() > 0) {
			mv.setViewName("Trial/trialHDWriteForm");
		} else {
			mv.setViewName("index");
		}
		return mv;
	}
	
	//종합문제 일반 등록 폼
		@RequestMapping("/trialWriteForm")
		public ModelAndView trialWriteForm(HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			ModelAndView mv = new ModelAndView();
			if (loginId != null && loginId.length() > 0) {
				mv.setViewName("Trial/trialWriteForm");
			}
			
			return mv;
		}
	
		//종합문제 마지막문제 등록 폼
		@RequestMapping("/trialWriteForm2")
		public ModelAndView trialWriteForm2(HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			ModelAndView mv = new ModelAndView();
			if (loginId != null && loginId.length() > 0) {
				mv.setViewName("Trial/trialWriteForm2");
			}
			
			return mv;
		}
	
		//종합문제 게시 리스트에 나올 문제
		@RequestMapping(value = "/TrialHDWrite", method = RequestMethod.POST)
		public String TrialHDWrite(TrialExamVo vo, @RequestParam("selectedTrialAnswer") String selectedTrialAnswer, HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			int sqa = Integer.parseInt(selectedTrialAnswer);
			System.out.println(selectedTrialAnswer);
			// 로그인 확인 후, 성공 시에는 해당 게시물 DB에 입력, 실패 시 QuizBoard 로 이동.
			if (loginId != null && loginId.length() > 0) {
				// 카테고리 값에 맞게 치환
				
				vo.setTrialTrueAnswer(sqa);
				vo.setTrialWriter(loginId);
				service.insertTrialHD(vo, loginId);
			} 
			return "Trial/trialWriteForm";
		}
		
	//종합문제 추가등록
	@RequestMapping(value = "/TrialWrite", method = RequestMethod.POST)
	public String TrialWrite(TrialExamVo vo, @RequestParam("selectedTrialAnswer") String selectedTrialAnswer, HttpSession session) {
		// 로그인 확인용.
		String loginId = (String)session.getAttribute("loginId");
		int sqa = Integer.parseInt(selectedTrialAnswer);
		System.out.println(selectedTrialAnswer);
		// 로그인 확인 후, 성공 시에는 해당 게시물 DB에 입력, 실패 시 QuizBoard 로 이동.
	
			vo.setTrialTrueAnswer(sqa);
			vo.setTrialWriter(loginId);
			service.insertTrial(vo, loginId);
		 
		return "Trial/trialWriteForm";	
	}
	//종합문제 추가등록완료페이지
	@RequestMapping(value = "/trialWrite2", method = RequestMethod.POST)
	public String TrialWrite2(TrialExamVo vo, @RequestParam("selectedTrialAnswer") String selectedTrialAnswer, HttpSession session) {
		// 로그인 확인용.
		String loginId = (String)session.getAttribute("loginId");
		int sqa = Integer.parseInt(selectedTrialAnswer);
		System.out.println(selectedTrialAnswer);
		// 로그인 확인 후, 성공 시에는 해당 게시물 DB에 입력, 실패 시 QuizBoard 로 이동.
		    vo.setTrialTrueAnswer(sqa);
			vo.setTrialWriter(loginId);
			service.insertTrial(vo, loginId);
		 
	 	return "Trial/writeResult2";
	}
	
	//수정
	@RequestMapping(value = "/KoreanTrialUpdate", method=RequestMethod.POST)
	public ModelAndView KoreanTrialUpdate(int trialNum, TrialExamVo tr, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		TrialExamVo vo = service.selectTrial(trialNum, loginId);
		tr.setTrialTrueAnswer(vo.getTrialTrueAnswer());
		tr.setTrialWriter(vo.getTrialWriter());
		tr.setTrialWriteDate(vo.getTrialWriteDate());
		ModelAndView mv = new ModelAndView();
		if (loginId != null && loginId.length() > 0) {
				mv.addObject("result", service.updateTrial(tr, loginId));
				mv.addObject("trialNum", trialNum);
				mv.setViewName("Trial/TrialUpdate");
			} 
		
		return mv;
	}
	// 수정 폼
	@RequestMapping(value = "/trialUpdateForm", method=RequestMethod.POST)
	public ModelAndView TrialUpdateForm(int trialNum, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		ModelAndView mv = new ModelAndView();
		// 퀴즈 번호를 바탕으로 퀴즈 정보를 가져옴.
		TrialExamVo tr = service.selectTrial(trialNum, loginId);
		// 로그인 확인 후, 성공 시에는 정보를 가지고 Form 으로 이동, 실패 시 QuizBoard 로 이동.
		if (loginId != null && loginId.length() > 0) {
			mv.addObject("tr", tr);
			mv.setViewName("Trial/TrialUpdateForm");
		}
		return mv;
	}
	
	
	//삭제
	@RequestMapping(value = "/deleteKoreanTrial", method = RequestMethod.POST)
	public ModelAndView DeleteKoreanTrial(int trialNum, HttpSession session) {
		// 로그인 확인용.
		String loginId = (String)session.getAttribute("loginId");
		ModelAndView mv = new ModelAndView();
		// 퀴즈 번호를 바탕으로 퀴즈 작성자를 가져옴.
		String trialWriter = service.selectTrial(trialNum, loginId).getTrialWriter();
		// 로그인 확인 후, 성공 시에는 해당 퀴즈 정답 DB에 입력, 실패 시 QuizBoard 로 이동.
		if (loginId != null &&  loginId.length() > 0) {
			// 글 작성자와 로그인 아이디가 일치하는 지 확인 후 Javascript alert() 으로 결과를 알린 뒤 QuizBoard 로 이동.
			// 일치할 경우 동작, 아닐 경우 -1 반환으로 실패.
			if( loginId.equals(trialWriter)) {
				// 퀴즈를 맞춘 기록과 해당 퀴즈를 삭제함.
				service.deleteTrialIncorrectCount(trialNum);
				System.out.println("trialNum"+trialNum);
				int result =  service.deleteTrial(trialNum);
				System.out.println("trialNum"+trialNum);
				mv.addObject("result", result);
				mv.setViewName("Trial/delete_result");
			}
		}
		return mv;
	}

	
	
	//해설보기
	@RequestMapping("/trialSolution")
	public ModelAndView trialSolution(int trialNum, HttpSession session) {
		// 로그인 확인용.
		String loginId = (String)session.getAttribute("loginId");
		TrialExamVo tr = service.selectTrial(trialNum, loginId);
		 ModelAndView mv = new ModelAndView();
		// 로그인 확인 후, 모든 정보를 출력하기 위해 vo에서 꺼내며 해당 퀴즈를 맞춘 이력이 있는지 확인한다. 
		// 로그인 실패시 로그인 페이지로 전달한다.
		if (loginId != null && loginId.length() > 0) {
			mv.addObject("tr", tr);
			mv.setViewName("Trial/TrialSolution");
		} else {
			mv.setViewName("redirect:main");
		}
		return mv;
	}
	

}