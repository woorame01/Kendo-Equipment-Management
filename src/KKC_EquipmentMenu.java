import java.util.ArrayList;
public class KKC_EquipmentMenu {
	KKC_MemberMenu memberMenu;
	private ArrayList <KKC_Equipment> equipmentList = new ArrayList <KKC_Equipment>();
	
	public KKC_EquipmentMenu(KKC_MemberMenu memberMenu) {
		this.memberMenu = memberMenu;
	}
	
	public ArrayList <KKC_Equipment> getEquipmentList () {
		return this.equipmentList;
	}
	
	public void addEquipment (String number, String type, String gender, String date, String studentID) {
		KKC_Member user = memberMenu.findMemberNoComment(studentID);
		KKC_Equipment newEquipment = new KKC_Equipment(number, type, gender, date, user);
		equipmentList.addLast(newEquipment);
		
		newEquipment.showEquipment();
		System.out.println("등록 완료");
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
		addMember.showMember();
				
		
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

}
