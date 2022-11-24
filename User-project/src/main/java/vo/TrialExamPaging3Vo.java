package vo;

import java.util.List;

public class TrialExamPaging3Vo {

	private List<TrialExam3Vo> boardList;
	private int currentPage;
	private int startPage;
	private int endPage;
	private int totalPage;

	public TrialExamPaging3Vo() {
		super();
	}
	
	public TrialExamPaging3Vo(List<TrialExam3Vo> trialExamList, int currentPage, int startPage, int endPage, int totalPage) {
		super();
		this.boardList = trialExamList;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;

	}

	public List<TrialExam3Vo> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<TrialExam3Vo> boardList) {
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
