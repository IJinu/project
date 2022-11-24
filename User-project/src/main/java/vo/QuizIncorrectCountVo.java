package vo;

import lombok.Data;

@Data
public class QuizIncorrectCountVo {
	private String id;
	private int quizNum;
    private String quizTitle;
    private String quizType;
    private String quizChallenger;
    


	public QuizIncorrectCountVo(String id, int quizNum,String quizTitle, String quizType,String quizChallenger ) {
		super();
		this.id = id;
		this.quizNum = quizNum;
		this.quizTitle = quizTitle;
		this.quizType = quizType;
		this.quizChallenger = quizChallenger;
	}

	
}
