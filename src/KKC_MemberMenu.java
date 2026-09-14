import java.util.ArrayList;
public class KKC_MemberMenu {
	ArrayList <KKC_Member> memberList = new ArrayList <KKC_Member>();
	
	public void addMember(String name, String gender, String studentID, String phone) {
		KKC_Member newMember = new KKC_Member(name, gender, studentID, phone);
		memberList.addLast(newMember);
		
		newMember.showMember();
		System.out.println("등록 완료");
		
	}
	
	public KKC_Member findMember (String studentID) {
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getStudentID().equals(studentID)) {
				System.out.println("부원의 정보를 찾았습니다.");
				System.out.println("이름: "+memberList.get(i).getName()+
								 " | 성별: "+memberList.get(i).getGender()+
								 " | 학번: "+memberList.get(i).getStudentID()+
								 " | 전화번호: "+memberList.get(i).getPhone());
				
				KKC_Member findMember = memberList.get(i);
				
				return findMember;
			}
		}
		System.out.println("등록되지 않은 부원입니다.");
		return null;
	}
	
	public void deleteMember(KKC_Member findMember) {
		memberList.remove(findMember);
		System.out.println("부원 정보를 제거하였습니다.");
	}
	
	public void showMemberList() {
		for(int i=0; i<memberList.size(); i++) {
			System.out.println("이름: "+memberList.get(i).getName()+
					 " | 성별: "+memberList.get(i).getGender()+
					 " | 학번: "+memberList.get(i).getStudentID()+
					 " | 전화번호: "+memberList.get(i).getPhone());
		}
		System.out.println("-------- 끝 ---------");
	}

}
