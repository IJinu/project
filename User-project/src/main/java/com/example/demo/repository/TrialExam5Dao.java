package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.TrialExam5Mapper;

import vo.TrialExam5Vo;
import vo.TrialIncorrectCount5Vo;

@Component
public class TrialExam5Dao {
	
	@Autowired
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	// 종합문제 생성
		public int insertTrial(TrialExam5Vo tr) {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.insertTrial(tr);
			}
		// 종합문제 게시판에 보일 글 생성
			public int insertTrialHD(TrialExam5Vo tr) {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.insertTrialHD(tr);
					}
	// 종합문제 전체 개수 
		public int selectTrialTotalCount() {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.selectTrialTotalCount();
		}
		
	// 종합문제 상세보기
			public TrialExam5Vo selectTrial(int trialNum) {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.selectTrial(trialNum);
			}

	//종합문제 수정
		public int updateTrial(TrialExam5Vo vo) {
		TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
		return mapper.updateTrial(vo);
		}
	//종합문제 삭제
		public int deleteTrial(int trialNum) {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.deleteTrial(trialNum);
		}
		//틀린 이력 삭제
		public int deleteTrialIncorrectCount(int trialNum) {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.deleteTrialIncorrectCount(trialNum);
		}
	//종합문제 정답확인
		public int isAnswerCorrect(int trialNum, int selectedQuizAnswer) {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.isAnswerCorrect(trialNum, selectedQuizAnswer);
		}
	 // 오답종합문제 등록
		public int insertTrialIncorrectCount(TrialIncorrectCount5Vo vo) {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.insertTrialIncorrectCount(vo);
		}
		
		// 종합문제 리스트
		public List<TrialExam5Vo> selectTrialList(int startRow, int count){
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.selectTrialList(startRow, count);
		}
		// 종합문제 헤드리스트
		public List<TrialExam5Vo> selectTrialHDList(int startRow, int count){
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.selectTrialHDList(startRow, count);
		}
		
		
		// 틀린 이력
		public int selectTrialIncorrectHistory(String id, int trialNum) {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.selectTrialIncorrectHistory(id, trialNum);
		}
	

		// 오답 리스트
		public List<TrialExam5Vo> selectTrialIncorrectList(int startRow, int count){
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.selectTrialIncorrectList(startRow, count);
		}
		
		//오답 문제
		public int selectTrialIncorrectCount() {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.selectTrialIncorrectCount();
		}
      //마지막페이지
		public int maxPage(TrialExam5Vo vo) {
			TrialExam5Mapper mapper = session.getMapper(TrialExam5Mapper.class);
			return mapper.maxPage(vo);
		}

	
}
