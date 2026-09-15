// v1.0 - 기본 장비 관리 기능 완성
// v1.1 - 장비 상태 관리

import java.util.ArrayList;
public class KKC_EquipmentMenu {
	EquipmentStatusList statusList;
	KKC_MemberMenu memberMenu;
	private ArrayList <KKC_Equipment> equipmentList = new ArrayList <KKC_Equipment>();
	
	public KKC_EquipmentMenu(KKC_MemberMenu memberMenu, EquipmentStatusList statusList) {
		this.memberMenu = memberMenu;
		this.statusList = statusList;
	}
	
	public ArrayList <KKC_Equipment> getEquipmentList () {
		return this.equipmentList;
	}
	
	public void addEquipment (String number, String type, String gender, String date, String studentID, int nowStatus) {
		KKC_Member user = memberMenu.findMemberNoComment(studentID);
		EquipmentStatus status = statusList.findStatusNoComment(nowStatus);
		KKC_Equipment newEquipment = new KKC_Equipment(number, type, gender, date, user, status);
		equipmentList.addLast(newEquipment);
		
		newEquipment.showEquipment();
		System.out.println("등록 완료");
	}
	
	public KKC_Equipment findEquipmentNoComment(String number) {
		for(int i=0; i<equipmentList.size(); i++) {
			if(equipmentList.get(i).getNumber().equals(number)) {
				KKC_Equipment findEquipment = equipmentList.get(i);
				findEquipment.showEquipment();
				
				return findEquipment;
			}
		}
		return null;
	}
	
	public KKC_Equipment findEquipment(String number) {
		for(int i=0; i<equipmentList.size(); i++) {
			if(equipmentList.get(i).getNumber().equals(number)) {
				System.out.println("등록된 장비를 찾았습니다.");
				KKC_Equipment findEquipment = equipmentList.get(i);
				findEquipment.showEquipment();
				
				return findEquipment;
			}
		}
		System.out.println("등록된 장비를 찾을 수 없습니다. 장비번호를 확인하세요.");
		return null;
	}
	
	public void deleteEquipment(KKC_Equipment findEquipment) {
		equipmentList.remove(findEquipment);
		System.out.println("등록된 장비 정보를 제거하였습니다.");
	}
	
	public void showEquipmentNullUserList() {
		for(int i=0; i<equipmentList.size(); i++) {
			if(equipmentList.get(i).getUser() == null) {
				KKC_Equipment findEquipmentNullUser = equipmentList.get(i);
				findEquipmentNullUser.showEquipment();
			}
		}
		System.out.println("-------- 끝 ---------");
	}
	
	public int EquipmentNullUserCount() {
		int count = 0;
		for(int i=0; i<equipmentList.size(); i++) {
			if(equipmentList.get(i).getUser() == null) {
				++count;
			}
		}
		return count;
	}
	
	public void addEquipmentUser(String number, String StudentID) {
		KKC_Equipment addEquipment = null;
		KKC_Member addMember = null;
		for(int i=0; i<equipmentList.size(); i++) {
			if(equipmentList.get(i).getNumber().equals(number)) {
				addEquipment = equipmentList.get(i);
				System.out.print("등록할 장비 >>");
				addEquipment.showEquipment();
				break;
			}
		}
		
		addMember = memberMenu.findMemberNoComment(StudentID);
		System.out.print("등록할 사용자 >>");
		if(addMember != null)
			addMember.showMember();
		
		else
			System.out.println("등록할 사용자를 찾을 수 없습니다.");
				
		
		if(addEquipment == null)
			System.out.println("등록할 장비를 찾을 수 없습니다.");
		
		if(addEquipment == null || addMember == null) {
			System.out.println("등록할 장비 및 사용자를 다시 확인하세요.");
		}
		
		else {
			addEquipment.setUser(addMember);
			addEquipment.showEquipment();
			System.out.println("등록 완료");
		}
	}
	
	public void showEquipmentList() {
		for(int i=0; i<equipmentList.size(); i++) {
			equipmentList.get(i).showEquipment();
		}
		System.out.println("-------- 끝 ---------");
	}
	
	public void deleteEquipmentUser(KKC_Member findMember) {
		for(int i=0; i<equipmentList.size(); i++) {
			if(equipmentList.get(i).getUser() == null) {
				continue;
			}
			
			else if(equipmentList.get(i).getUser().equals(findMember)) {
				System.out.println(equipmentList.get(i).getUser().getName()+"의 장비 "+equipmentList.get(i).getNumber()+"을 미등록 상태로 변경하였습니다.");
				equipmentList.get(i).setUser(null);
			}
		}
	}
	
	public void setEquipmentStauts(String number, int nowStatus) {
		KKC_Equipment findEquipment = findEquipmentNoComment(number);
		EquipmentStatus findStatus = statusList.findStatusNoComment(nowStatus);
		
		if(findEquipment == null) {
			System.out.println("등록된 장비를 찾을 수 없습니다. 장비번호를 확인하세요.");
		}
		
		else if(findStatus == null) {
			System.out.println("등록할 상태 정보를 찾을 수 없습니다. 상태 정보를 확인하세요.");
		}
		
		else {
			System.out.print(findEquipment.getNumber()+"의 상태를 "+findEquipment.getStatus().getStatusType()+" 에서 ");
			findEquipment.setStatus(findStatus);
			System.out.println(findEquipment.getStatus().getStatusType()+" 으로 변경하였습니다.");
		}
		
	}

}
