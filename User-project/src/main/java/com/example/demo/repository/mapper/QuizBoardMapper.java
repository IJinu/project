package com.example.demo.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import vo.QuizBoardVo;
import vo.QuizIncorrectCountVo;
import vo.TrialExamVo;



@Mapper
public interface QuizBoardMapper {
	
	public int insertQuiz(QuizBoardVo vo);
	
	public int insertTrialExam(TrialExamVo vo);

	public int selectQuizTotalCount(String loginId);
	
	public int selectQuizTotalCount1();

	public QuizBoardVo selectQuiz(int quizNum);

	public List<QuizBoardVo> selectQuizList(@Param("startRow") int startRow, @Param("count") int count);

	public int updateQuiz(QuizBoardVo vo);

	public int deleteQuiz(int quizNum);
	
	//퀴즈 정답확인
	public int isAnswerCorrect(int quizNum, int selectedQuizAnswer);
	           
	//퀴즈 오답등록
	public int insertQuizIncorrectCount(QuizIncorrectCountVo vo);
	
    //자바 문제리스트
	public List<QuizBoardVo> selectJavaList(@Param("startRow") int startRow, @Param("count") int count);
    //SQL 문제리스트
	public List<QuizBoardVo> selectSqlList(@Param("startRow") int startRow, @Param("count") int count);
	//CSS&& 리스트
	public List<QuizBoardVo> selectCssList(@Param("startRow") int startRow, @Param("count") int count);
	//React 리스트
	public List<QuizBoardVo> selectReactList(@Param("startRow") int startRow, @Param("count") int count);
	//Docker 리스트
	public List<QuizBoardVo> selectDockerList(@Param("startRow") int startRow, @Param("count") int count);


	//오답리스트
	public List<QuizBoardVo> selectQuizIncorrectList(@Param("startRow") int startRow, @Param("count") int count);

	//자바문제 개수
	public int selectJavaCount();
	//SQL문제 개수
    public int selectSqlCount();
	//CSS&&문제 개수
    public int selectCssCount();
	//React 개수
    public int selectReactCount();
	//Docker문제 개수
    public int selectDockerCount();

   
    // 오답문제 개수
    public int selectQuizIncorrectCount();
    // 틀린 이력
    public int selectQuizIncorrectHistory(String id, int quizNum);
    //틀린 이력 삭제
    public int deleteQuizIncorrectCount(int quizNum,String loginId);

	public int deleteQuizIncorrectCount1(int quizNum, String loginId);
    
}



