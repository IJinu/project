package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.example.demo.repository.MemberDao;

import vo.MemberPagingVo;
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

	//페이지,리스트 서비스
	private static final int COUNT_PER_PAGE = 10;
	public MemberPagingVo makeMemberPage(int currentPage) {
		// 게시글 총 갯수
		int totalCount = dao.selectMemberTotalCount();

		// 페이지 총 갯수
		int totalPage = totalCount / COUNT_PER_PAGE;

		if (totalCount % COUNT_PER_PAGE != 0) {
			totalPage++;
		}

		int startPage = (currentPage - 1) / 10 * 10 + 1;

		int endPage = startPage + 9;
		if (totalPage < endPage) {
			endPage = totalPage;
		}

		int startRow = (currentPage - 1) * COUNT_PER_PAGE;

		List<MemberVo> memberList = dao.selectMemberList(startRow, COUNT_PER_PAGE);

		return new MemberPagingVo(memberList, currentPage, startPage, endPage, totalPage);
	}
	
	
	//회원리스트
	public MemberPagingVo makeMemberlistPage(int currentPage) {
		// 게시글 총 갯수
		int totalCount = dao.selectMemberTotalCount();

		// 페이지 총 갯수
		int totalPage = totalCount / COUNT_PER_PAGE;

		if (totalCount % COUNT_PER_PAGE != 0) {
			totalPage++;
		}

		int startPage = (currentPage - 1) / 10 * 10 + 1;

		int endPage = startPage + 9;
		if (totalPage < endPage) {
			endPage = totalPage;
		}

		int startRow = (currentPage - 1) * COUNT_PER_PAGE;


		List<MemberVo> memberList = dao.selectMemberList(startRow, COUNT_PER_PAGE);

		return new MemberPagingVo(memberList, currentPage, startPage, endPage, totalPage);
	}


}

