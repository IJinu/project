package vo;

import java.util.List;

public class MemberPagingVo {
		private List<MemberVo> memberList;
		private int currentPage;
		private int startPage;
		private int endPage;
		private int totalPage;
		
		public MemberPagingVo(List<MemberVo> memberList, int currentPage, int startPage, int endPage, int totalPage) {
			super();
			this.memberList = memberList;
			this.currentPage = currentPage;
			this.startPage = startPage;
			this.endPage = endPage;
			this.totalPage = totalPage;

		}
		
		public List<MemberVo> getMemberList() {
			return memberList;
		}
		public void setMemberList(List<MemberVo> memberList) {
			this.memberList = memberList;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getStartPage() {
			return startPage;
		}
		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}
		public int getEndPage() {
			return endPage;
		}
		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		@Override
		public String toString() {
			return "MemberPagingVo [memberList=" + memberList + ", currentPage=" + currentPage + ", startPage="
					+ startPage + ", endPage=" + endPage + ", totalPage=" + totalPage + "]";
		}



}
