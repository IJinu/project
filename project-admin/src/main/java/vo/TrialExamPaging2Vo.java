package vo;

import java.util.List;

public class TrialExamPaging2Vo {

	private List<TrialExam2Vo> boardList;
	private int currentPage;
	private int startPage;
	private int endPage;
	private int totalPage;

	public TrialExamPaging2Vo() {
		super();
	}
	
	public TrialExamPaging2Vo(List<TrialExam2Vo> boardList, int currentPage, int startPage, int endPage, int totalPage) {
		super();
		this.boardList = boardList;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;

	}

	public List<TrialExam2Vo> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<TrialExam2Vo> boardList) {
		this.boardList = boardList;
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
}
