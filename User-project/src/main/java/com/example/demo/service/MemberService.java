package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.example.demo.repository.MemberDao;

import vo.MemberVo;

@Component
public class MemberService {
	@Autowired
	private MemberDao dao;

	// 회원가입
	public boolean join(MemberVo member) throws DuplicateKeyException {
		try {

			if (dao.insert(member) > 0) {
				return true;
			} else {
				return false;
			}

		} catch (DuplicateKeyException e) {
			e.printStackTrace();
		} finally {
			System.out.println("에러");
		}
		return false;
	}

	// 로그인
	public boolean login(String id, String password) {
		if (dao.selectMemberNum(id, password) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public MemberVo getMemberInfo(String loginId) {
		return dao.select(loginId);
	}

	public MemberVo readinfo(int memberNum) {
		return dao.select(memberNum);
	}

	public int delete(int memberNum) {
		return dao.delete(memberNum);
	}
	
	public int update(MemberVo member) {
		return dao.update(member);
	}
}

