package vo;

import java.util.List;

public class TrialExamPaging4Vo {

	private List<TrialExam4Vo> boardList;
	private int currentPage;
	private int startPage;
	private int endPage;
	private int totalPage;

	public TrialExamPaging4Vo() {
		super();
	}
	
	public TrialExamPaging4Vo(List<TrialExam4Vo> trialHDList, int currentPage, int startPage, int endPage, int totalPage) {
		super();
		this.boardList = trialHDList;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;

	}

	public List<TrialExam4Vo> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<TrialExam4Vo> boardList) {
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
