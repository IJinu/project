package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.TrialExamMapper;

import vo.TrialExamVo;
import vo.TrialIncorrectCountVo;

@Component
public class TrialExamDao {
	
	@Autowired
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	// 종합문제 생성
		public int insertTrial(TrialExamVo tr) {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.insertTrial(tr);
			}
		// 종합문제 게시판에 보일 글 생성
			public int insertTrialHD(TrialExamVo tr) {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.insertTrialHD(tr);
					}
	// 종합문제 전체 개수 
		public int selectTrialTotalCount() {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.selectTrialTotalCount();
		}
		
	// 종합문제 상세보기
			public TrialExamVo selectTrial(int trialNum) {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.selectTrial(trialNum);
			}

	//종합문제 수정
		public int updateTrial(TrialExamVo vo) {
		TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
		return mapper.updateTrial(vo);
		}
	//종합문제 삭제
		public int deleteTrial(int trialNum) {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.deleteTrial(trialNum);
		}
		//틀린 이력 삭제
		public int deleteTrialIncorrectCount(int trialNum) {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.deleteTrialIncorrectCount(trialNum);
		}
	//종합문제 정답확인
		public int isAnswerCorrect(int trialNum, int selectedQuizAnswer) {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.isAnswerCorrect(trialNum, selectedQuizAnswer);
		}
	 // 오답종합문제 등록
		public int insertTrialIncorrectCount(TrialIncorrectCountVo vo) {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.insertTrialIncorrectCount(vo);
		}
		
		// 종합문제 리스트
		public List<TrialExamVo> selectTrialList(int startRow, int count){
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.selectTrialList(startRow, count);
		}
		// 종합문제 헤드리스트
		public List<TrialExamVo> selectTrialHDList(int startRow, int count){
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.selectTrialHDList(startRow, count);
		}
		
		
		// 틀린 이력
		public int selectTrialIncorrectHistory(String id, int trialNum) {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.selectTrialIncorrectHistory(id, trialNum);
		}
	

		// 오답 리스트
		public List<TrialExamVo> selectTrialIncorrectList(int startRow, int count){
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.selectTrialIncorrectList(startRow, count);
		}
		
		//오답 문제
		public int selectTrialIncorrectCount() {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.selectTrialIncorrectCount();
		}
      //마지막페이지
		public int maxPage(TrialExamVo vo) {
			TrialExamMapper mapper = session.getMapper(TrialExamMapper.class);
			return mapper.maxPage(vo);
		}

	
}
