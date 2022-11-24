package com.example.demo.repository.mapper;

import org.springframework.web.bind.annotation.RequestParam;

import vo.MemberVo;

public interface MemberMapper {

	public int insert(MemberVo member);

	public MemberVo selectmember(String id);

	public int selectMemberNum(String id,  String password);

	public MemberVo select(int memberNum);

	public int update(MemberVo member);

	public int delete(int memberNum);

}