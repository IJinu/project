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
import com.example.demo.service.TrialExamService;

import vo.MemberVo;
import vo.QuizBoardVo;
import vo.QuizIncorrectCountVo;

@Controller
public class QuizBoardController {
	@Autowired
	private MemberService service1;
	@Autowired
	private QuizBoardService service2;
	@Autowired
	private TrialExamService service3;
	
	
	
	
	//메인화면
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(@RequestParam(defaultValue = "1") int page, HttpSession session) {
		   ModelAndView mv = new ModelAndView();
		String loginId = (String)session.getAttribute("loginId");
		if(loginId != null && loginId.length()>0) {
			MemberVo vo = service1.getMemberInfo(loginId);
			mv.addObject("memberInfo",vo);

			mv.setViewName("board/main");
		}else {
			mv.setViewName("board/main2");
		}
		return mv;
	}
	

	
	//상세보기
	@RequestMapping("/quizRead")
	public ModelAndView quizRead(int quizNum, HttpSession session) {
		// 로그인 확인용.
		String loginId = (String)session.getAttribute("loginId");
		QuizBoardVo vo = service2.selectQuiz(quizNum, loginId);
		 ModelAndView mv = new ModelAndView();
		// 로그인 확인 후, 모든 정보를 출력하기 위해 vo에서 꺼내며 해당 퀴즈를 맞춘 이력이 있는지 확인한다. 
		// 로그인 실패시 로그인 페이지로 전달한다.
		if (loginId != null && loginId.length() > 0) {
			mv.addObject("history", service2.selectQuizIncorrectHistory(loginId, quizNum));
			mv.addObject("vo", vo);
			mv.setViewName("Quiz/QuizRead");
		} else {
			mv.setViewName("redirect:main");
		}
		return mv;
	}
	
	//퀴즈 수정 폼 
	@RequestMapping("/quizUpdateForm")
	public ModelAndView updateForm(int quizNum) {
		QuizBoardVo vo = service2.readNoCount(quizNum);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("Quiz/QuizUpdateForm");
		return mv;
	}
	
	
	//퀴즈 수정
	@RequestMapping(value = "/quizUpdate", method = RequestMethod.POST)
	public ModelAndView update(QuizBoardVo vo, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		boolean result = service2.updateQuiz(vo, loginId);
		ModelAndView mv = new ModelAndView();

		if (result) {
			mv.addObject("quizNum", vo.getQuizNum());
			mv.setViewName("Quiz/update_success");

		} else {
			mv.setViewName("update_fail");
		}

		return mv;
	}
	//퀴즈 삭제
	@RequestMapping("/deleteQuiz")
	public ModelAndView delete(int quizNum, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		boolean result = service2.deleteQuiz(quizNum, loginId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", result);
		mv.setViewName("Quiz/delete_result");
		return mv;
		
	}
//정답확인 & 오답노트
	@RequestMapping(value = "/QuizResult", method = RequestMethod.POST)
	public ModelAndView quizResult(int quizNum, @RequestParam("selectedQuizAnswer") String selectedQuizAnswer, HttpSession session,
			String quizTitle , String quizType,String quizChallenger) {
		// 로그인 확인용.
		String loginId = (String)session.getAttribute("loginId");
		ModelAndView mv = new ModelAndView();
		//sqa = selectedQuizAnswer
		int sqa = Integer.parseInt(selectedQuizAnswer);
		// 로그인 확인 후, 성공 시에는 해당 퀴즈 정답 DB에 입력, 실패 시 QuizBoard 로 이동.
		if (loginId != null && loginId.length() > 0) {
			QuizIncorrectCountVo vo = new QuizIncorrectCountVo(loginId, quizNum,quizTitle,quizType, quizChallenger);
			mv.addObject("quizResult", service2.insertQuizAnswer(vo, sqa, loginId));
			mv.addObject("quizNum", quizNum);
			mv.setViewName("Quiz/QuizResult");
			System.out.println("Quiz_Challenger"+quizChallenger);
		} else {
			mv.setViewName("redirect:loginForm");
		}
		return mv;
	}
	
	//오답노트 겸 마이페이지
			@RequestMapping(value = "/myPage", method = RequestMethod.GET)
			public ModelAndView MyPage(@RequestParam(defaultValue = "1") int page, HttpSession session) {
				String loginId = (String) session.getAttribute("loginId");
				if(loginId != null && loginId.length() > 0) {
			      	}
				ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
				MemberVo member = service1.getMemberInfo(loginId);
				mv.addObject("memberInfo", member);
			    mv.setViewName("MyPage/MyPage"); 
				
				return mv;
			}
	
			//해설보기
			@RequestMapping("/quizSolution")
			public ModelAndView quizSolution(int quizNum, HttpSession session) {
				// 로그인 확인용.
				String loginId = (String)session.getAttribute("loginId");
				QuizBoardVo vo = service2.selectQuiz(quizNum, loginId);
				 ModelAndView mv = new ModelAndView();
				// 로그인 확인 후, 모든 정보를 출력하기 위해 vo에서 꺼내며 해당 퀴즈를 맞춘 이력이 있는지 확인한다. 
				// 로그인 실패시 로그인 페이지로 전달한다.
				if (loginId != null && loginId.length() > 0) {
					mv.addObject("vo", vo);
					mv.setViewName("Quiz/QuizSolution");
				} else {
					mv.setViewName("redirect:main");
				}
				return mv;
			}
	
	
	
	////게시판/////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	//국어 게시판
	@RequestMapping(value = "/Korean", method = RequestMethod.GET)
	public ModelAndView java(@RequestParam(defaultValue = "1") int page, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		if(loginId != null && loginId.length() > 0) {
				}
		// 퀴즈 게시판 카테고리 초기화.
		session.removeAttribute("category");
		ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
		mv.addObject("quizPage", service2.makeJavaPage(page));
		mv.setViewName("board/korean");
		return mv;
	}
	  // 영어 게시판
	@RequestMapping(value = "/English", method = RequestMethod.GET)
	public ModelAndView sql(@RequestParam(defaultValue = "1") int page, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		if(loginId != null && loginId.length() > 0) {
				}
		// 퀴즈 게시판 카테고리 초기화.
		session.removeAttribute("category");
		ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
		mv.addObject("quizPage", service2.makeSqlPage(page));
		mv.setViewName("board/English");
		return mv;
	}
	//수학
	@RequestMapping(value = "/Math", method = RequestMethod.GET)
	public ModelAndView Css(@RequestParam(defaultValue = "1") int page, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		if(loginId != null && loginId.length() > 0) {
				}
		// 퀴즈 게시판 카테고리 초기화.
		session.removeAttribute("category");
		ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
		mv.addObject("quizPage", service2.makeCssPage(page));
		mv.setViewName("board/Math");
		return mv;
	}
	
	//사탐
		@RequestMapping(value = "/Social", method = RequestMethod.GET)
		public ModelAndView React(@RequestParam(defaultValue = "1") int page, HttpSession session) {
			String loginId = (String) session.getAttribute("loginId");
			if(loginId != null && loginId.length() > 0) {
					}
			// 퀴즈 게시판 카테고리 초기화.
			session.removeAttribute("category");
			ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
			mv.addObject("quizPage", service2.makeReactPage(page));
			mv.setViewName("board/Social");
			return mv;
		}
		
	//과탐
		@RequestMapping(value = "/Science", method = RequestMethod.GET)
		public ModelAndView Docker(@RequestParam(defaultValue = "1") int page, HttpSession session) {
			String loginId = (String) session.getAttribute("loginId");
			if(loginId != null && loginId.length() > 0) {
					}
			// 퀴즈 게시판 카테고리 초기화.
			session.removeAttribute("category");
			ModelAndView mv = new ModelAndView();   //make**page만 바꾸면 복붙 될듯?
			mv.addObject("quizPage", service2.makeDockerPage(page));
			mv.setViewName("board/Science");
			return mv;
		}
	
		

	
		////등록폼/////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//국어 퀴즈 등록 폼
		@RequestMapping("/quizWriteForm1")
		public ModelAndView quizWriteForm1(HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			ModelAndView mv = new ModelAndView();
			if (loginId != null && loginId.length() > 0) {
				mv.setViewName("Quiz/quizWriteForm1");
			} else {
				mv.setViewName("index");
			}
			return mv;
		}
		
		//영어 퀴즈 등록 폼
		@RequestMapping("/quizWriteForm2")
		public ModelAndView quizWriteForm2(HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			ModelAndView mv = new ModelAndView();
			if (loginId != null && loginId.length() > 0) {
				mv.setViewName("Quiz/quizWriteForm2");
			} else {
				mv.setViewName("index");
			}
			return mv;
		}
		
		//수학 퀴즈 등록 폼
		@RequestMapping("/quizWriteForm3")
		public ModelAndView quizWriteForm3(HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			ModelAndView mv = new ModelAndView();
			if (loginId != null && loginId.length() > 0) {
				mv.setViewName("Quiz/quizWriteForm3");
			} else {
				mv.setViewName("index");
			}
			return mv;
		}
		
		//사탐 퀴즈 등록 폼
		@RequestMapping("/quizWriteForm4")
		public ModelAndView quizWriteForm4(HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			ModelAndView mv = new ModelAndView();
			if (loginId != null && loginId.length() > 0) {
				mv.setViewName("Quiz/quizWriteForm4");
			} else {
				mv.setViewName("index");
			}
			return mv;
		}
		
		//과탐 퀴즈 등록 폼
		@RequestMapping("/quizWriteForm5")
		public ModelAndView quizWriteForm5(HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			ModelAndView mv = new ModelAndView();
			if (loginId != null && loginId.length() > 0) {
				mv.setViewName("Quiz/quizWriteForm5");
			} else {
				mv.setViewName("index");
			}
			return mv;
		}
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//국어 퀴즈 등록
		@RequestMapping(value = "/quizWrite1", method = RequestMethod.POST)
		public String quizWrite1(QuizBoardVo vo, @RequestParam("selectedQuizAnswer") String selectedQuizAnswer, HttpSession session) {
			// 로그인 확인용.
			String loginId = (String)session.getAttribute("loginId");
			int sqa = Integer.parseInt(selectedQuizAnswer);
			System.out.println(selectedQuizAnswer);

				vo.setQuizTrueAnswer(sqa);
				vo.setQuizWriter(loginId);
				service2.insertQuiz(vo, loginId);
		
			return "redirect:/Korean?category=0&page=1";
		}
		
		//영어 퀴즈 등록
			@RequestMapping(value = "/quizWrite2", method = RequestMethod.POST)
			public String quizWrite2(QuizBoardVo vo, @RequestParam("selectedQuizAnswer") String selectedQuizAnswer, HttpSession session) {
				// 로그인 확인용.
				String loginId = (String)session.getAttribute("loginId");
				int sqa = Integer.parseInt(selectedQuizAnswer);
				System.out.println(selectedQuizAnswer);

					vo.setQuizTrueAnswer(sqa);
					vo.setQuizWriter(loginId);
					service2.insertQuiz(vo, loginId);
				
				return "redirect:/English?category=0&page=1";
			}	
			
			//수학 퀴즈 등록
			@RequestMapping(value = "/quizWrite3", method = RequestMethod.POST)
			public String quizWrite3(QuizBoardVo vo, @RequestParam("selectedQuizAnswer") String selectedQuizAnswer, HttpSession session) {
				// 로그인 확인용.
				String loginId = (String)session.getAttribute("loginId");
				int sqa = Integer.parseInt(selectedQuizAnswer);
				System.out.println(selectedQuizAnswer);

					vo.setQuizTrueAnswer(sqa);
					vo.setQuizWriter(loginId);
					service2.insertQuiz(vo, loginId);
				
				return "redirect:/Math?category=0&page=1";
			}
			
			//사탐 퀴즈 등록
			@RequestMapping(value = "/quizWrite4", method = RequestMethod.POST)
			public String quizWrite4(QuizBoardVo vo, @RequestParam("selectedQuizAnswer") String selectedQuizAnswer, HttpSession session) {
				// 로그인 확인용.
				String loginId = (String)session.getAttribute("loginId");
				int sqa = Integer.parseInt(selectedQuizAnswer);
				System.out.println(selectedQuizAnswer);
				vo.setQuizTrueAnswer(sqa);
				vo.setQuizWriter(loginId);
				service2.insertQuiz(vo, loginId);
				return "redirect:/Social?category=0&page=1";
			}
			
			//과탐 퀴즈 등록
			@RequestMapping(value = "/quizWrite5", method = RequestMethod.POST)
			public String quizWrite5(QuizBoardVo vo, @RequestParam("selectedQuizAnswer") String selectedQuizAnswer, HttpSession session) {
				// 로그인 확인용.
				String loginId = (String)session.getAttribute("loginId");
				int sqa = Integer.parseInt(selectedQuizAnswer);
				System.out.println(selectedQuizAnswer);
				// 로그인 확인 후, 성공 시에는 해당 게시물 DB에 입력, 실패 시 QuizBoard 로 이동.
					vo.setQuizTrueAnswer(sqa);
					vo.setQuizWriter(loginId);
					service2.insertQuiz(vo, loginId);
				
				return "redirect:/Science?category=0&page=1";
			}
			
		
}
