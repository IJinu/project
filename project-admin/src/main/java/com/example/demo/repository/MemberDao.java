package com.example.demo.repository;

import java.util.List;

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
	// 회원 전체 개수 
	public int selectMemberTotalCount() {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.selectMemberTotalCount();
	}
	//회원 리스트
	public List<MemberVo> selectMemberList(int startRow, int count){
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return mapper.selectMemberList(startRow, count);
	}
	
}
