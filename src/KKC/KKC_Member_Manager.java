// v1.0 - 기본 장비 관리 기능 완성
// v1.1 - 장비 상태 관리
package KKC;

import java.util.ArrayList;

public class KKC_Member_Manager {
	private ArrayList <KKC_Member> memberList = new ArrayList <KKC_Member>();
	
	public void addMember(String name, String gender, String studentID, String phone) {
		KKC_Member newMember = new KKC_Member(name, gender, studentID, phone);
		memberList.addLast(newMember);
		
		newMember.showMember();
		System.out.println("등록 완료");
		
	}
	
	public ArrayList <KKC_Member> getMemberList () {
		return this.memberList;
	}
	
	
	public KKC_Member findMemberNoComment (String studentID) {
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getStudentID().equals(studentID)) {
				KKC_Member findMember = memberList.get(i);

				return findMember;
			}
		}
		return null;
	}
	
	public KKC_Member findMember (String studentID) {
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getStudentID().equals(studentID)) {
				System.out.println("부원의 정보를 찾았습니다.");
				KKC_Member findMember = memberList.get(i);
				findMember.showMember();
				
				return findMember;
			}
		}
		System.out.println("등록된 부원을 찾을 수 없습니다. 학번을 확인하세요.");
		return null;
	}
	
	public void deleteMember(KKC_Member findMember) {
		memberList.remove(findMember);
		System.out.println("등록된 부원 정보를 제거하였습니다.");
	}
	
	public void showMemberList() {
		for(int i=0; i<memberList.size(); i++) {
			memberList.get(i).showMember();
		}
		System.out.println("*********************************************");
	}

}
