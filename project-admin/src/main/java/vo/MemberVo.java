package vo;

import lombok.Data;
@Data 
public class MemberVo {
private int memberNum;   //회원번호
private String id; 		 //아이디
private String password;  //패스워드]
private String name;
private String email; // 이메일
private String phone; // 핸드폰
private String level;
private int admin;


public MemberVo() {
	super();
}

public MemberVo(int memberNum, String id, String password, String name, String email,
		String phone, String level, int admin) {
	super();
	this.memberNum = memberNum;
	this.id = id;
	this.password = password;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.level = level;
	this.admin = admin;
}



}