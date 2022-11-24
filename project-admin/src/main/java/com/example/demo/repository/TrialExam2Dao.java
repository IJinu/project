package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.TrialExam2Mapper;

import vo.TrialExam2Vo;
import vo.TrialIncorrectCount2Vo;
import vo.TrialIncorrectCountVo;

@Component
public class TrialExam2Dao {
	
	@Autowired
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	// 종합문제 생성
		public int insertTrial(TrialExam2Vo tr) {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.insertTrial(tr);
			}
		// 종합문제 게시판에 보일 글 생성
			public int insertTrialHD(TrialExam2Vo tr) {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.insertTrialHD(tr);
					}
	// 종합문제 전체 개수 
		public int selectTrialTotalCount() {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.selectTrialTotalCount();
		}
		
	// 종합문제 상세보기
			public TrialExam2Vo selectTrial(int trialNum) {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.selectTrial(trialNum);
			}

	//종합문제 수정
		public int updateTrial(TrialExam2Vo vo) {
		TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
		return mapper.updateTrial(vo);
		}
	//종합문제 삭제
		public int deleteTrial(int trialNum) {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.deleteTrial(trialNum);
		}
		//틀린 이력 삭제
		public int deleteTrialIncorrectCount(int trialNum) {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.deleteTrialIncorrectCount(trialNum);
		}
	//종합문제 정답확인
		public int isAnswerCorrect(int trialNum, int selectedQuizAnswer) {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.isAnswerCorrect(trialNum, selectedQuizAnswer);
		}
	 // 오답종합문제 등록
		public int insertTrialIncorrectCount(TrialIncorrectCount2Vo vo) {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.insertTrialIncorrectCount(vo);
		}
		
		// 종합문제 리스트
		public List<TrialExam2Vo> selectTrialList(int startRow, int count){
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.selectTrialList(startRow, count);
		}
		// 종합문제 헤드리스트
		public List<TrialExam2Vo> selectTrialHDList(int startRow, int count){
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.selectTrialHDList(startRow, count);
		}
		
		
		// 틀린 이력
		public int selectTrialIncorrectHistory(String id, int trialNum) {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.selectTrialIncorrectHistory(id, trialNum);
		}
	

		// 오답 리스트
		public List<TrialExam2Vo> selectTrialIncorrectList(int startRow, int count){
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.selectTrialIncorrectList(startRow, count);
		}
		
		//오답 문제
		public int selectTrialIncorrectCount() {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.selectTrialIncorrectCount();
		}
      //마지막페이지
		public int maxPage(TrialExam2Vo vo) {
			TrialExam2Mapper mapper = session.getMapper(TrialExam2Mapper.class);
			return mapper.maxPage(vo);
		}

	
}
