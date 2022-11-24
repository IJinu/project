package vo;

import lombok.Data;

@Data
public class TrialIncorrectCount2Vo {
	private String id;
	private int trialNum;
    private String trialTitle;
    private String trialType;
    private String trialChallenger;
    


	public TrialIncorrectCount2Vo(String id, int trialNum,String trialTitle, String trialType, String trialChallenger ) {
		super();
		this.id = id;
		this.trialNum = trialNum;
		this.trialTitle = trialTitle;
		this.trialType = trialType;
		this.trialChallenger = trialChallenger;
	}

	
}
