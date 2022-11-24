package vo;

import java.util.Date;

import lombok.Data;
@Data
 public class TrialExam2Vo {
	private int trialNum;
	private String trialTitle;
	private String trialContents;
	private String trialChallenger;
	private String trialWriter;
	private Date trialWriteDate;
	private String trialAnswer1;
	private String trialAnswer2;
	private String trialAnswer3;
	private String trialAnswer4;
	private int trialTrueAnswer;
	private String trialType;
	private String trialSolution;
	private int trialX;  // 헤드넘버
	private String next;
	
	
	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public TrialExam2Vo() {
		super();
	}
	
	public TrialExam2Vo(int trialNum, String trialTitle, String trialContents, String trialWriter, Date trialWriteDate,
			String trialAnswer1, String trialAnswer2, String trialAnswer3, String trialAnswer4, int trialTrueAnswer,
			int trialView, String trialType, String trialSolution, int trialX, String trialChallenger) {
		super();
		this.trialNum = trialNum;
		this.trialTitle = trialTitle;
		this.trialContents = trialContents;
		this.trialWriter = trialWriter;
		this.trialWriteDate = trialWriteDate;
		this.trialAnswer1 = trialAnswer1;
		this.trialAnswer2 = trialAnswer2;
		this.trialAnswer3 = trialAnswer3;
		this.trialAnswer4 = trialAnswer4;
		this.trialTrueAnswer = trialTrueAnswer;
		this.trialType = trialType;
		this.trialSolution = trialSolution;
		this.trialX =trialX;
		this.trialChallenger =trialChallenger;
	}
	
	public int getTrialX() {
		return trialX;
	}

	public void setTrialX(int trialX) {
		this.trialX = trialX;
	}

	public int getTrialNum() {
		return trialNum;
	}

	public void setTrialNum(int trialNum) {
		this.trialNum = trialNum;
	}

	public String getTrialTitle() {
		return trialTitle;
	}

	public void setTrialTitle(String trialTitle) {
		this.trialTitle = trialTitle;
	}

	public String getTrialContents() {
		return trialContents;
	}

	public void setTrialContents(String trialContents) {
		this.trialContents = trialContents;
	}

	public String getTrialWriter() {
		return trialWriter;
	}

	public void setTrialWriter(String trialWriter) {
		this.trialWriter = trialWriter;
	}

	public Date getTrialWriteDate() {
		return trialWriteDate;
	}

	public void setTrialWriteDate(Date trialWriteDate) {
		this.trialWriteDate = trialWriteDate;
	}

	public String getTrialAnswer1() {
		return trialAnswer1;
	}

	public void setTrialAnswer1(String trialAnswer1) {
		this.trialAnswer1 = trialAnswer1;
	}

	public String getTrialAnswer2() {
		return trialAnswer2;
	}

	public void setTrialAnswer2(String trialAnswer2) {
		this.trialAnswer2 = trialAnswer2;
	}

	public String getTrialAnswer3() {
		return trialAnswer3;
	}

	public void setTrialAnswer3(String trialAnswer3) {
		this.trialAnswer3 = trialAnswer3;
	}

	public String getTrialAnswer4() {
		return trialAnswer4;
	}

	public void setTrialAnswer4(String trialAnswer4) {
		this.trialAnswer4 = trialAnswer4;
	}

	public int getTrialTrueAnswer() {
		return trialTrueAnswer;
	}

	public void setTrialTrueAnswer(int trialTrueAnswer) {
		this.trialTrueAnswer = trialTrueAnswer;
	}

	public String getTrialType() {
		return trialType;
	}

	public void setTrialType(String trialType) {
		this.trialType = trialType;
	}

	public String getTrialSolution() {
		return trialSolution;
	}

	public void setTrialSolution(String trialSolution) {
		this.trialSolution = trialSolution;
	}

}
