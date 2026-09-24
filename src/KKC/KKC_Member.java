// v1.0 - 기본 장비 관리 기능 완성
// v1.1 - 장비 상태 관리
package KKC;

public class KKC_Member {
	private String name, gender, studentID, phone;
	
	public KKC_Member(String name, String gender, String studentID, String phone) {
		this.name = name;
		this.gender = gender;
		this.studentID = studentID;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void showMember() { 
		System.out.println("이름: "+name+" | 성별: "+gender+" | 학번: "+studentID+" | 전화번호: "+phone);
	}
	
}
