package com.example.demo.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import vo.TrialExam4Vo;
import vo.TrialIncorrectCount4Vo ;

@Mapper
public interface TrialExam4Mapper {

	//종합문제 생성
	public int insertTrial(TrialExam4Vo tr);
	//종합헤드 생성
	public int insertTrialHD(TrialExam4Vo tr);
	//종합문제 총 개수
	public int selectTrialTotalCount();
	//종합문제 개수
    public int selectTrialCount();

    // 종합문제 상세보기
    public TrialExam4Vo selectTrial(int trialNum);
      //종합문제 수정
    public int updateTrial(TrialExam4Vo vo);
    
    
	//종합문제 삭제
	public int deleteTrial(int trialNum);	
	//틀린 이력 삭제
    public int deleteTrialIncorrectCount(int trialNum);
    
    
     //종합문제 정답확인
	public int isAnswerCorrect(int trialNum, int selectedTrialAnswer);
     // 오답종합문제 등록
	public int insertTrialIncorrectCount(TrialIncorrectCount4Vo  vo);
	//종합문제 리스트
	public List<TrialExam4Vo> selectTrialList(int startRow, int count);
	//종합문제 헤드리스트
	public List<TrialExam4Vo> selectTrialHDList(int startRow, int count);
	//오답리스트
    public List<TrialExam4Vo> selectTrialIncorrectList(@Param("startRow") int startRow, @Param("count") int count);
	// 틀린 이력
	public int selectTrialIncorrectHistory(String id, int trialNum);
	// 정답 이력
	public int selectTrialCorrectHistory(String id, int trialNum);
	//오답 문제
	public int selectTrialIncorrectCount();
	//마지막 페이지
	public int maxPage(TrialExam4Vo vo);
}
