package com.example.demo.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import vo.MemberVo;

public interface MemberMapper {

	public int insert(MemberVo member);

	public MemberVo selectmember(String id);

	public int selectMemberNum(String id, String password);

	public MemberVo select(int memberNum);

	public int update(MemberVo member);

	public int delete(int memberNum);

	// 회원 토탈 카운트
	public int selectMemberTotalCount();

	// 회원 개수
	public int selectMemberListCount();

	// 회원리스트
	public List<MemberVo> selectMemberList(@Param("startRow") int startRow, @Param("count") int count);
}