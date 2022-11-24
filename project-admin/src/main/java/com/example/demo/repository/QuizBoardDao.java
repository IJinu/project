package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.QuizBoardMapper;

import vo.QuizBoardVo;
import vo.QuizIncorrectCountVo;


 @Component
public class QuizBoardDao{
	@Autowired
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}

// 퀴즈 생성
	public int insertQuiz(QuizBoardVo vo) {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.insertQuiz(vo);
	}

	// 퀴즈 전체 개수 
	public int selectQuizTotalCount() {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectQuizTotalCount();
	}
	

	
	
	// 퀴즈 상세보기
	public QuizBoardVo selectQuiz(int quizNum) {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectQuiz(quizNum);
	}
	
  
	
	//퀴즈 리스트
	public List<QuizBoardVo> selectQuizList(int startRow, int count){
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectQuizList(startRow, count);
	}
	//퀴즈 수정
	public int updateQuiz(QuizBoardVo vo) {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.updateQuiz(vo);
	}
	

	//퀴즈 삭제
	public int deleteQuiz(int quizNum) {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.deleteQuiz(quizNum);
	}
	

	
	//퀴즈 정답확인
	public int isAnswerCorrect(int quizNum, int selectedQuizAnswer) {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.isAnswerCorrect(quizNum, selectedQuizAnswer);
	}
	
	
	 // 오답퀴즈 등록
	public int insertQuizIncorrectCount(QuizIncorrectCountVo vo) {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.insertQuizIncorrectCount(vo);
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//자바 문제 리스트
	public List<QuizBoardVo> selectJavaList(int startRow, int count){
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectJavaList(startRow, count);
	}
	//SQL 문제 리스트
	public List<QuizBoardVo> selectSqlList(int startRow, int count){
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectSqlList(startRow, count);
	}
	//css,html,js리스트
	public List<QuizBoardVo> selectCssList(int startRow, int count){
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectCssList(startRow, count);
	}
	//React리스트
	public List<QuizBoardVo> selectReactList(int startRow, int count){
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectReactList(startRow, count);
	}
	//Docker리스트
	public List<QuizBoardVo> selectDockerList(int startRow, int count){
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectDockerList(startRow, count);
	}
	//Spring리스트
	public List<QuizBoardVo> selectSpringList(int startRow, int count){
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectSpringList(startRow, count);
	}
	//Aws리스트
	public List<QuizBoardVo> selectAwsList(int startRow, int count){
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectAwsList(startRow, count);
	}
	

	
	// 오답 리스트
	public List<QuizBoardVo> selectQuizIncorrectList(int startRow, int count){
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectQuizIncorrectList(startRow, count);
	}
	
	
	///////////////////////////////////////////////////////////////////////////
    //자바 문제
	public int selectJavaCount() {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectJavaCount();
	}
    //SQL 문제
	public int selectSqlCount() {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectSqlCount();
	}
	//CSS&& 문제
	public int selectCssCount() {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectCssCount();
	}
	//React 문제
	public int selectReactCount() {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectReactCount();
	}
	//Docker 문제
	public int selectDockerCount() {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectDockerCount();
	}
	//Spring 문제
	public int selectSpringCount() {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectSpringCount();
	}
	//Aws 문제
	public int selectAwsCount() {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectAwsCount();
	}

	//오답 문제
	public int selectQuizIncorrectCount() {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectQuizIncorrectCount();
	}
	// 틀린 이력
	public int selectQuizIncorrectHistory(String id, int quizNum) {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.selectQuizIncorrectHistory(id, quizNum);
	}
	//틀린 이력 삭제
	public int deleteQuizIncorrectCount(int quizNum) {
		QuizBoardMapper mapper = session.getMapper(QuizBoardMapper.class);
		return mapper.deleteQuizIncorrectCount(quizNum);
	}
}