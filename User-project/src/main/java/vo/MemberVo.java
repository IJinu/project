package vo;


public class MemberVo {
private int memberNum;   //회원번호
private String id; 		 //아이디
private String password;  //패스워드]
private String name;
private String email; // 이메일
private String phone; // 핸드폰
private String admin;

public int getMemberNum() {
	return memberNum;
}
public void setMemberNum(int memberNum) {
	this.memberNum = memberNum;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAdmin() {
	return admin;
}
public void setAdmin(String admin) {
	this.admin = admin;
}
@Override
public String toString() {
	return "MemberVo [memberNum=" + memberNum + ", id=" + id + ", password=" + password + ", name=" + name
			+ ", email=" + email + ", phone=" + phone + ", admin=" + admin + "]";
}


}