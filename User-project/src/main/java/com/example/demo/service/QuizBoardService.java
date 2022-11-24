package com.example.demo.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.QuizBoardDao;

import vo.QuizBoardPagingVo;
import vo.QuizBoardVo;
import vo.QuizIncorrectCountVo;

@Component
public class QuizBoardService{
	@Autowired
	private QuizBoardDao dao;
	//퀴즈 등록
	public int insertQuiz(QuizBoardVo vo, String loginId) {
		vo.setQuizWriteDate(new Date()); // 작성일자
		vo.setQuizWriter(loginId); // 작성자

		return dao.insertQuiz(vo);
	}
	
	//퀴즈 선택
	public QuizBoardVo selectQuiz(int quizNum, String loginId) {
		QuizBoardVo vo = dao.selectQuiz(quizNum);
		if (loginId != null && loginId.equals(vo.getQuizWriter())) {
			return vo;
		} else {
			return dao.selectQuiz(quizNum);
		}
	}
 // 조회수 /*비활성화*/
	public QuizBoardVo readNoCount(int quizNum) {
		return dao.selectQuiz(quizNum);
	}

	//퀴즈 수정
	public boolean updateQuiz(QuizBoardVo vo, String loginId) {
		QuizBoardVo real = dao.selectQuiz(vo.getQuizNum());

		if (loginId != null && loginId.equals(real.getQuizWriter())) {
			vo.setQuizWriteDate(new Date());
			dao.updateQuiz(vo);
			return true;
		} else {
			return false;
		}
	}
		
	//퀴즈 삭제
	public boolean deleteQuiz(int quizNum, String loginId) {
		QuizBoardVo quiz = dao.selectQuiz(quizNum);

		if (loginId != null && loginId.equals(quiz.getQuizWriter())) {
			dao.deleteQuiz(quizNum);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteQuizIncorrectCount1(int quizNum, String loginId) {
		int vo = dao.deleteQuizIncorrectCount1(quizNum,loginId);
		return true;
	}
	
	//틀린 이력 검색
	public int selectQuizIncorrectHistory(String id, int quizNum) {
		return dao.selectQuizIncorrectHistory(id, quizNum);
	}
	
	
	//정답확인 및 오답등록
		public int insertQuizAnswer(QuizIncorrectCountVo vo, int selectedQuizAnswer,String loginId) {
			int result = 0;
			int quizNum = vo.getQuizNum();
			if(dao.isAnswerCorrect(quizNum, selectedQuizAnswer) == 1) {
				result = 1;
			
			} else if(dao.isAnswerCorrect(quizNum, selectedQuizAnswer) == 0 && dao.selectQuizIncorrectHistory(vo.getId(), quizNum) == 0) {
				vo.setQuizChallenger(loginId); // 작성자
				dao.insertQuizIncorrectCount(vo);
			
			} return result;
			
		}
		

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //페이지,리스트 서비스/////
	private static final int COUNT_PER_PAGE = 10;
	public QuizBoardPagingVo makeQuizPage(int currentPage) {
		// 게시글 총 갯수
		int totalCount = dao.selectQuizTotalCount1();
		// 페이지 총 갯수
		int totalPage = totalCount / COUNT_PER_PAGE;

		if (totalCount % COUNT_PER_PAGE != 0) {
			totalPage++;
		}

		int startPage = (currentPage - 1) / 10 * 10 + 1;

		int endPage = startPage + 9;
		if (totalPage < endPage) {
			endPage = totalPage;
		}

		int startRow = (currentPage - 1) * COUNT_PER_PAGE;

		List<QuizBoardVo> quizList = dao.selectQuizList(startRow, COUNT_PER_PAGE);

		return new QuizBoardPagingVo(quizList, currentPage, startPage, endPage, totalPage);
	}
	
	
	
	//자바
		public QuizBoardPagingVo makeJavaPage(int currentPage) {
			// 게시글 총 갯수
			int totalCount = dao.selectQuizTotalCount1();

			// 페이지 총 갯수
			int totalPage = totalCount / COUNT_PER_PAGE;

			if (totalCount % COUNT_PER_PAGE != 0) {
				totalPage++;
			}

			int startPage = (currentPage - 1) / 10 * 10 + 1;

			int endPage = startPage + 9;
			if (totalPage < endPage) {
				endPage = totalPage;
			}

			int startRow = (currentPage - 1) * COUNT_PER_PAGE;


			List<QuizBoardVo> javaList = dao.selectJavaList(startRow, COUNT_PER_PAGE);

			return new QuizBoardPagingVo(javaList, currentPage, startPage, endPage, totalPage);
		}

		//SQL
				public QuizBoardPagingVo makeSqlPage(int currentPage) {
					// 게시글 총 갯수
					int totalCount = dao.selectQuizTotalCount1();

					// 페이지 총 갯수
					int totalPage = totalCount / COUNT_PER_PAGE;

					if (totalCount % COUNT_PER_PAGE != 0) {
						totalPage++;
					}

					int startPage = (currentPage - 1) / 10 * 10 + 1;

					int endPage = startPage + 9;
					if (totalPage < endPage) {
						endPage = totalPage;
					}

					int startRow = (currentPage - 1) * COUNT_PER_PAGE;


					List<QuizBoardVo> SqlList = dao.selectSqlList(startRow, COUNT_PER_PAGE);

					return new QuizBoardPagingVo(SqlList, currentPage, startPage, endPage, totalPage);
				}
	   //CSS &&
				public QuizBoardPagingVo makeCssPage(int currentPage) {
					// 게시글 총 갯수
					int totalCount = dao.selectQuizTotalCount1();

					// 페이지 총 갯수
					int totalPage = totalCount / COUNT_PER_PAGE;

					if (totalCount % COUNT_PER_PAGE != 0) {
						totalPage++;
					}

					int startPage = (currentPage - 1) / 10 * 10 + 1;

					int endPage = startPage + 9;
					if (totalPage < endPage) {
						endPage = totalPage;
					}

					int startRow = (currentPage - 1) * COUNT_PER_PAGE;


					List<QuizBoardVo> CssList = dao.selectCssList(startRow, COUNT_PER_PAGE);

					return new QuizBoardPagingVo(CssList, currentPage, startPage, endPage, totalPage);
				}			
				
				  //Docker
				public QuizBoardPagingVo makeDockerPage(int currentPage) {
					// 게시글 총 갯수
					int totalCount = dao.selectQuizTotalCount1();

					// 페이지 총 갯수
					int totalPage = totalCount / COUNT_PER_PAGE;

					if (totalCount % COUNT_PER_PAGE != 0) {
						totalPage++;
					}

					int startPage = (currentPage - 1) / 10 * 10 + 1;

					int endPage = startPage + 9;
					if (totalPage < endPage) {
						endPage = totalPage;
					}

					int startRow = (currentPage - 1) * COUNT_PER_PAGE;


					List<QuizBoardVo> DockerList = dao.selectDockerList(startRow, COUNT_PER_PAGE);

					return new QuizBoardPagingVo(DockerList, currentPage, startPage, endPage, totalPage);
				}	
				
			//React
				public QuizBoardPagingVo makeReactPage(int currentPage) {
					// 게시글 총 갯수
					int totalCount = dao.selectQuizTotalCount1();

					// 페이지 총 갯수
					int totalPage = totalCount / COUNT_PER_PAGE;

					if (totalCount % COUNT_PER_PAGE != 0) {
						totalPage++;
					}

					int startPage = (currentPage - 1) / 10 * 10 + 1;

					int endPage = startPage + 9;
					if (totalPage < endPage) {
						endPage = totalPage;
					}

					int startRow = (currentPage - 1) * COUNT_PER_PAGE;


					List<QuizBoardVo> ReactList = dao.selectReactList(startRow, COUNT_PER_PAGE);

					return new QuizBoardPagingVo(ReactList, currentPage, startPage, endPage, totalPage);
				}		
				
			
				
			
				
				  //오답 리스트
				public QuizBoardPagingVo makeQuizIncorrectPage2(int currentPage, String loginId) {
					// 게시글 총 갯수
					int totalCount = dao.selectQuizTotalCount(loginId);

					// 페이지 총 갯수
					int totalPage = totalCount / COUNT_PER_PAGE;

					if (totalCount % COUNT_PER_PAGE != 0) {
						totalPage++;
					}

					int startPage = (currentPage - 1) / 10 * 10 + 1;

					int endPage = startPage + 9;
					if (totalPage < endPage) {
						endPage = totalPage;
					}

					int startRow = (currentPage - 1) * COUNT_PER_PAGE;


					List<QuizBoardVo> QuizIncorrectList = dao.selectQuizIncorrectList(startRow, COUNT_PER_PAGE);

					return new QuizBoardPagingVo(QuizIncorrectList, currentPage, startPage, endPage, totalPage);
				}
				

				public Object makeQuizIncorrectPage(int currentPage, String loginId) {
					// 게시글 총 갯수
					int totalCount = dao.selectQuizTotalCount(loginId);

					// 페이지 총 갯수
					int totalPage = totalCount / COUNT_PER_PAGE;

					if (totalCount % COUNT_PER_PAGE != 0) {
						totalPage++;
					}

					int startPage = (currentPage - 1) / 10 * 10 + 1;

					int endPage = startPage + 9;
					if (totalPage < endPage) {
						endPage = totalPage;
					}

					int startRow = (currentPage - 1) * COUNT_PER_PAGE;


					List<QuizBoardVo> QuizIncorrectList = dao.selectQuizIncorrectList(startRow, COUNT_PER_PAGE);

					return new QuizBoardPagingVo(QuizIncorrectList, currentPage, startPage, endPage, totalPage);
				}
			}


			
	
				
				
	

