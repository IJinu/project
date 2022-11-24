package com.example.demo.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.mapper.MemberMapper;

import vo.MemberVo;

@Component
public class MemberDao{
	@Autowired
	private SqlSessionTemplate session;
	
	public int insert(MemberVo member) {
		MemberMapper mapper=session.getMapper(MemberMapper.class);
		return mapper.insert(member);
	}
	public MemberVo select(String id) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.selectmember(id);
	}
	
	public int selectMemberNum(String id,String password) {
		MemberMapper mapper =session.getMapper(MemberMapper.class);
		return mapper.selectMemberNum(id, password);
	}
	
	public MemberVo select(int memberNum) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.select(memberNum);
	}
	public int update(MemberVo member) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.update(member);
	}
	public int delete(int memberNum) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.delete(memberNum);
	}
}