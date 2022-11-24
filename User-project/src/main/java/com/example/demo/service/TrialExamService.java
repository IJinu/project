package com.example.demo.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.TrialExamDao;

import vo.TrialExamVo;
import vo.TrialIncorrectCountVo;
import vo.TrialExam2Vo;
import vo.TrialExamPagingVo;

@Component
public class TrialExamService {
	@Autowired
	private TrialExamDao dao;
	
	//퀴즈 등록
	public int insertTrial(TrialExamVo vo, String loginId) {
		vo.setTrialWriteDate(new Date()); // 작성일자
		vo.setTrialWriter(loginId); // 작성자

		return dao.insertTrial(vo);
	}
	
	//퀴즈 헤드
	public int insertTrialHD(TrialExamVo vo, String loginId) {
		vo.setTrialWriteDate(new Date()); // 작성일자
		vo.setTrialWriter(loginId); // 작성자

		return dao.insertTrialHD(vo);
	}
	
	//종합문제 상세보기
	public TrialExamVo selectTrial(int trialNum, String loginId) {
		TrialExamVo vo = dao.selectTrial(trialNum);
		if (loginId != null && loginId.equals(vo.getTrialWriter())) {
			return vo;
		} else {
			return dao.selectTrial(trialNum);
		}
	}

	
	//퀴즈 수정
	public boolean updateTrial(TrialExamVo vo, String loginId) {
		TrialExamVo real = dao.selectTrial(vo.getTrialNum());

		if (loginId != null && loginId.equals(real.getTrialWriter())) {
			vo.setTrialWriteDate(new Date());
			dao.updateTrial(vo);
			return true;
		} else {
			return false;
		}
	}
		

	/**
	 * 퀴즈 삭제하기.
	 * @param quizNum 퀴즈 고유 번호.
	 * @return 성공 시 1, 실패 시 그외의 값을 반환함.
	 */
	public int deleteTrial(int trialNum) {
		return dao.deleteTrial(trialNum);
	}
	
	/**
	 * 맞춘 퀴즈 이력 삭제.
	 * @param quizNum 퀴즈 고유 번호.
	 * @return 성공 시 1, 실패 시 그외의 값을 반환함.
	 */
	public int deleteTrialIncorrectCount(int trialNum) {
		return dao.deleteTrialIncorrectCount(trialNum);
	}
	
	
	//틀린 이력 검색
	public int selectTrialIncorrectHistory(String id, int trialNum) {
		return dao.selectTrialIncorrectHistory(id, trialNum);
	}
	
//정답확인 및 오답등록
	public int insertTrialAnswer(TrialIncorrectCountVo vo,int selectedTrialAnswer,String loginId) {
		int result = 0;
		int trialNum = vo.getTrialNum();
		if(dao.isAnswerCorrect(trialNum, selectedTrialAnswer) == 1){
			result = 1;
		} else if(dao.isAnswerCorrect(trialNum, selectedTrialAnswer) == 0 && dao.selectTrialIncorrectHistory(vo.getId(), trialNum) == 0) {
			vo.setTrialChallenger(loginId);
			dao.insertTrialIncorrectCount(vo);
		} return result;
		
	}
	public int maxPage(TrialExamVo vo) {
		return dao.maxPage(vo);
	}
	
	
	  //종합문제
		private static final int COUNT_PER_PAGE = 10;
		public TrialExamPagingVo makeTrialPage(int currentPage) {
			// 게시글 총 갯수
			int totalCount = dao.selectTrialTotalCount();

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


			List<TrialExamVo> TrialExamList = dao.selectTrialList(startRow, COUNT_PER_PAGE);

			return new TrialExamPagingVo(TrialExamList, currentPage, startPage, endPage, totalPage);
		}		
		
		  //종합문제 헤드
		
				public TrialExamPagingVo makeTrialHDPage(int currentPage) {
					// 게시글 총 갯수
					int totalCount = dao.selectTrialTotalCount();

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


					List<TrialExamVo> TrialHDList = dao.selectTrialHDList(startRow, COUNT_PER_PAGE);

					return new TrialExamPagingVo(TrialHDList, currentPage, startPage, endPage, totalPage);
				}		
	

		  //오답
		public TrialExamPagingVo makeTrialIncorrectPage(int currentPage, String loginId) {
			// 게시글 총 갯수
			int totalCount = dao.selectTrialTotalCount();

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


			List<TrialExamVo> TrialIncorrectList = dao.selectTrialIncorrectList(startRow, COUNT_PER_PAGE);

			return new TrialExamPagingVo(TrialIncorrectList, currentPage, startPage, endPage, totalPage);
		}	
		


		
}
