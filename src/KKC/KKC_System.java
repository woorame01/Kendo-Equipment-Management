// v1.0 - 기본 장비 관리 기능 완성
// v1.1 - 장비 상태 관리
package KKC;

import java.util.Scanner;

import Equipment.EquipmentStatusList;
import Equipment.KKC_Equipment;

import java.util.InputMismatchException;
public class KKC_System {
	Scanner scanner = new Scanner(System.in);
	private  KKC_MemberMenu memberMenu;
	private KKC_EquipmentMenu equipmentMenu;
	private EquipmentStatusList statusList;
	int answer;
	
	public void getMenu() {
		while (true) {
		System.out.println();
		System.out.println("            Member Management");
		System.out.println("            Equipment Management");
		System.out.println();
		System.out.print("choice... 1(Member) | 2(Equipment) | 3(Close) >>");
		
		try {
		answer = scanner.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println();
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력하세요.");
			scanner.nextLine();
			continue;
		}
		
		if(answer == 1) {
			while (true) {
			System.out.println();
			System.out.println("            View member list");
			System.out.println("            Register as a new member");
			System.out.println("            Find member information");
			System.out.println("            Delete member information");
			System.out.print("choice... 1(View List) | 2(Register) | 3(Find) | 4(Delete) | 5(Back)>>");
			try {
			answer = scanner.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println();
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력하세요.");
				scanner.nextLine();
				continue;
			}
			scanner.nextLine();
			
			if(answer == 1) {
				System.out.println("등록된 총 부원은 "+memberMenu.getMemberList().size()+"명 입니다.");
				System.out.println("            부원 목록");
				System.out.println();
				memberMenu.showMemberList();
				System.out.print("Enter to back...");
				scanner.nextLine();
				continue;
			}
			
			else if(answer == 2) {
				System.out.println("부원 등록을 시작합니다.");
				System.out.print("이름 >>");
				String name = scanner.nextLine();
				System.out.print("성별 >>");
				String gender = scanner.nextLine();
				System.out.print("학번 >>");
				String studentID = scanner.nextLine();
				System.out.print("전화번호 >>");
				String phone = scanner.nextLine();
				
				memberMenu.addMember(name, gender, studentID, phone);
				System.out.print("Enter to back...");
				scanner.nextLine();
				continue;
			}
			
			else if(answer == 3) {
				System.out.println("등록된 부원 정보를 찾습니다.");
				System.out.print("찾을 부원의 학번을 입력하세요 >>");
				String studentID = scanner.nextLine();
				System.out.println();
				memberMenu.findMember(studentID);
				System.out.print("Enter to back...");
				scanner.nextLine();
				continue;
			}
			
			else if(answer == 4) {
				System.out.println("등록된 부원 정보를 삭제합니다.");
				System.out.print("삭제할 부원의 학번을 입력하세요 >>");
				String studentID = scanner.nextLine();
				KKC_Member findMember = memberMenu.findMember(studentID);
				
				if(findMember == null) {
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
				}
				
				while (true) {
				System.out.print("위의 부원의 정보를 삭제하시겠습니까? (Y/N)");
				String YesOrNo = scanner.nextLine();
				if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
					equipmentMenu.deleteEquipmentUser(findMember);
					memberMenu.deleteMember(findMember);
					break;
				}
				
				else if(YesOrNo.equals("n") || YesOrNo.equals("N")){
					System.out.println("부원 삭제를 취소하였습니다.");
					break;
				}
				
				else {
					System.out.println();
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력하세요.");
					continue;
				}
				}
				System.out.print("Enter to back...");
				scanner.nextLine();
				continue;
			}
			
			else if(answer == 5) {
				break;
			}
			
			else {
				System.out.println();
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력하세요.");
				continue;
			}
			}
			
		}
		
		if(answer == 2) {
			while (true) {
				System.out.println();
				System.out.println("            View Equipment list");
				System.out.println("            Register new equipment");
				System.out.println("            Equipment User Registration/Change");
				System.out.println("            Change equipment status");
				System.out.println("            Find equipment information");
				System.out.println("            Delete equipment information");
				System.out.print("choice... 1(View List) | 2(Equipment Register) | 3(User Register/Change) | 4(Changer Status) | 5(Find) | 6(Delete) | 7(Back)>>");
				
				try {
				answer = scanner.nextInt();
				}
				catch (InputMismatchException e) {
					System.out.println();
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력하세요.");
					scanner.nextLine();
					continue;
				}
				scanner.nextLine();
				
				if(answer == 1) { //view list
					System.out.println("등록된 총 장비는 "+equipmentMenu.getEquipmentList().size()+"개 입니다.");
					System.out.println("            장비 목록");
					System.out.println();
					equipmentMenu.showEquipmentList();
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
				}
				
				else if(answer == 2) { //Equipment Register
					System.out.println("장비 등록을 시작합니다.");
					if(equipmentMenu.getEquipmentList().size() != 0) {
					System.out.println("현재 등록된 마지막 장비 번호는 "+equipmentMenu.getEquipmentList().getLast().getNumber()+" 입니다."); }
					
					else {System.out.println("첫 장비 등록입니다. 장비번호는 죽도-001 입니다.");}
					
					System.out.print("장비번호 >>");
					String Number = scanner.nextLine();
					System.out.print("장비종류 >>");
					String type = scanner.nextLine();
					System.out.print("성별 >>");
					String gender = scanner.nextLine();
					System.out.print("등록일 >>");
					String date = scanner.nextLine();
					System.out.print("이용자 학번 (없다면 Enter)>>");
					String studentID = scanner.nextLine();
					int nowStatus;
					while (true) {
					statusList.showStatusList();
					System.out.print("장비 상태 >>");
					try {
					nowStatus = scanner.nextInt();
					}
					
					catch (InputMismatchException e) {
						System.out.println();
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력하세요.");
						scanner.nextLine();
						continue;
					}
					
					if(nowStatus > statusList.getSize() || nowStatus < 0) {
						System.out.println();
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력하세요.");
						scanner.nextLine();
						continue;
					}
					
					break;
					
					}
					
					scanner.nextLine();
					
					equipmentMenu.addEquipment(Number, type, gender, date, studentID, nowStatus);
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
					
				}
				
				else if(answer == 3) { //User Register or Change
					
					while (true) {
						System.out.println();
						System.out.println("            Equipment User Registration/Change");
						System.out.println("            Equipment User Registration");
						System.out.println("            Equipment User Change");
						System.out.print("choice... 1(User Registration) | 2(User Change) | 3(Back) >>");
						
						try {
						answer = scanner.nextInt();
						}
						catch (InputMismatchException e) {
							System.out.println();
							System.out.println("잘못된 입력입니다.");
							System.out.println("다시 입력하세요.");
							scanner.nextLine();
							continue;
						}
						scanner.nextLine();
						break;
					}
					if(answer == 1) {
					System.out.println("장비 이용자를 등록합니다.");
					while (true) {
					System.out.print("이용자 미등록 장비 목록을 보시겠습니까? (Y/N) >>");
					String YesOrNo = scanner.nextLine();
					
					if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
						System.out.println("현재 이용자 미등록 장비는 "+equipmentMenu.EquipmentNullUserCount()+"개 입니다.");
						System.out.println("            미등록 장비 목록");
						System.out.println();
						equipmentMenu.showEquipmentNullUserList();
						System.out.print("Enter to continue...");
						scanner.nextLine();
						break;
					}
					
					else if(YesOrNo.equals("n") || YesOrNo.equals("N"))
						break;
					
					else {
						System.out.println();
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력하세요.");
						continue;
					}
					
					}
					
					if(equipmentMenu.EquipmentNullUserCount() == 0) {
						System.out.println("현재 모든 장비 이용자가 등록되어 있습니다.");
						System.out.print("Enter to back...");
						scanner.nextLine();
						continue;
					}
					
					System.out.print("등록할 장비 번호를 입력하세요 >>");
					String number = scanner.nextLine();
					System.out.print("등록할 사용자의 학번을 입력하세요 >>");
					String studentID = scanner.nextLine();
					
					equipmentMenu.addEquipmentUser(number, studentID);
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
					}
					
					else if(answer == 2) {
						System.out.println("장비 이용자를 변경합니다.");
						KKC_Equipment findEquipment;
						String studentID;
						
						while (true) {
						System.out.print("변경할 장비 번호를 입력하세요 >>");
						String number = scanner.nextLine();
						
						if(number.equals("취소")) {
							findEquipment = null;
							break;
						}
						
						findEquipment = equipmentMenu.findEquipmentNoComment(number);
						
						if(findEquipment == null) {
							System.out.println();
							continue;
						}
						
						findEquipment.showEquipment();
						break;
						
						}
						
						if(findEquipment == null) {
							System.out.print("Enter to back...");
							scanner.nextLine();
							continue;
						}
						
						while (true) {
						System.out.print("새로 등록할 이용자의 학번을 입력하세요(미등록으로 변경 시 미등록 입력) >>");
						studentID = scanner.nextLine();
						
						if(studentID.equals("미등록")) {
							findEquipment.setUser(null);
						}
						
						else {
							KKC_Member findMember = memberMenu.findMemberNoComment(studentID);
							if(findMember == null) {
								System.out.println("등록할 이용자를 찾을 수 없습니다. 다시 입력하세요.");
								System.out.println();
								continue;
							}
							
							findMember.showMember();
							
							findEquipment.setUser(findMember);
							
							break;
						}
						
						}
						
						System.out.println("변경 완료");
						findEquipment.showEquipment();
						System.out.print("Enter to back...");
						scanner.nextLine();
						continue;
					
					}
					
					else if(answer == 3)
						break;
					
					else {
						System.out.println();
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력하세요.");
						continue;
					}
					
				}
				
				else if(answer == 4) { // Changer Status
					System.out.println("장비 상태를 변경합니다.");
					System.out.print("변경할 장비 번호를 입력하세요 >>");
					String number = scanner.nextLine();
					
					int nowStatus;
					while (true) {
					statusList.showStatusList();
					System.out.print("장비 상태를 입력하세요 >>");
					try {
					nowStatus = scanner.nextInt();
					}
					
					catch (InputMismatchException e) {
						System.out.println();
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력하세요.");
						scanner.nextLine();
						continue;
					}
					
					if(nowStatus > statusList.getSize() || nowStatus < 0) {
						System.out.println();
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력하세요.");
						scanner.nextLine();
						continue;
					}
					
					break;
					
					}
					scanner.nextLine();
					
					equipmentMenu.setEquipmentStauts(number, nowStatus);
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
					
				}
				
				else if(answer == 5) { //Find Equipment
					System.out.println("등록된 장비 정보를 찾습니다.");
					System.out.print("찾을 장비 번호를 입력하세요 >>");
					String number = scanner.nextLine();
					System.out.println();
					equipmentMenu.findEquipment(number);
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
	
 				}
				
				else if(answer == 6) { //Delete Equipment
					System.out.println("등록된 장비 정보를 삭제합니다.");
					System.out.print("삭제할 장비 번호를 입력하세요 >>");
					String number = scanner.nextLine();
					KKC_Equipment findEquipment = equipmentMenu.findEquipment(number);
					
					if(findEquipment == null) {
						System.out.print("Enter to back...");
						scanner.nextLine();
						continue;
					}
					while (true) {
					System.out.print("위 장비의 정보를 삭제하시겠습니까? (Y/N)");
					String YesOrNo = scanner.nextLine();
					if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
						equipmentMenu.deleteEquipment(findEquipment);
						System.out.print("Enter to back...");
						scanner.nextLine();
						break;
					}
					
					else if(YesOrNo.equals("n") || YesOrNo.equals("N")){
						System.out.println("장비 삭제를 취소하였습니다.");
						System.out.print("Enter to back...");
						scanner.nextLine();
						break;
					}
					
					else {
						System.out.println();
						System.out.println("잘못된 입력입니다.");
						System.out.println("다시 입력하세요.");
						continue;
					}
					}
					
				}
				
				else if(answer == 7) { //Back to main
					break;
				}
				
				else if(answer == 0) {
					System.out.println("장비 상태를 등록합니다.");
					System.out.print("등록할 상태 입력 >>");
					String statusType = scanner.nextLine();
					boolean canUsing;
					while (true) {
						System.out.print("상태에 대한 사용 가능 여부를 입력하세요(O/X).");
						String OorX = scanner.nextLine();
						if(OorX.equals("O") || OorX.equals("o")) {
							canUsing = true;
							break;
						}
					
						else if(OorX.equals("X") || OorX.equals("x")) {
							canUsing = false;
							break;
						}
						
						else {
							System.out.println();
							System.out.println("잘못된 입력입니다.");
							System.out.println("다시 입력하세요.");
							continue;
						}
					}
					
					equipmentMenu.statusList.addStatus(statusType, canUsing);
					continue;
					
				}
				
				else {
					System.out.println();
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력하세요.");
					continue;
				}
			}
		}
		
		if(answer == 3) {
			System.out.println("KKC Management Close");
			break;
		}
		
		else {
			System.out.println();
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력하세요.");
			continue;
		}
			
	}
		
	}
	
	/*
	public void testSet() {
		memberMenu.addMember("김우람", "남성", "5753764", "010-6645-3909");
		memberMenu.addMember("이민준", "남성", "5754123", "010-2378-4512");
		memberMenu.addMember("박서연", "여성", "5756891", "010-5832-7164");
		memberMenu.addMember("최현우", "남성", "5757342", "010-9461-3287");
		memberMenu.addMember("정다은", "여성", "5758015", "010-3157-8924");
		memberMenu.addMember("한지훈", "남성", "5759236", "010-7284-1635");
		memberMenu.addMember("윤서진", "여성", "5761048", "010-4529-6371");
		memberMenu.addMember("강민석", "남성", "5762387", "010-8916-2543");
		memberMenu.addMember("오지아", "여성", "5763519", "010-6742-5189");
		memberMenu.addMember("배준호", "남성", "5764672", "010-3265-7491");
		
		equipmentMenu.addEquipment("죽도-001", "죽도", "여성용", "26-09-16", null, 1);
		equipmentMenu.addEquipment("죽도-002", "죽도", "남성용", "26-09-16", null, 1);
		equipmentMenu.addEquipment("죽도-003", "죽도", "여성용", "26-09-16", null, 1);
		equipmentMenu.addEquipment("죽도-004", "죽도", "남성용", "26-09-16", null, 1);
		equipmentMenu.addEquipment("죽도-005", "죽도", "남성용", "26-09-16", null, 1);
		equipmentMenu.addEquipment("죽도-006", "죽도", "여성용", "26-09-16", null, 1);
		equipmentMenu.addEquipment("죽도-007", "죽도", "남성용", "26-09-16", null, 1);
		equipmentMenu.addEquipment("죽도-008", "죽도", "여성용", "26-09-16", null, 1);
		equipmentMenu.addEquipment("죽도-009", "죽도", "남성용", "26-09-16", null, 1);
		equipmentMenu.addEquipment("죽도-010", "죽도", "여성용", "26-09-16", null, 1);
	}
	*/
	
	public void firstSet() {
		statusList.addStatus("양호", true);
		statusList.addStatus("최상", true);
		statusList.addStatus("파손", false);
		statusList.addStatus("폐기", false);
	}
	
	public void run(KKC_MemberMenu memberMenu, KKC_EquipmentMenu equipmentMenu, EquipmentStatusList statusList) {
		this.equipmentMenu = equipmentMenu;
		this.memberMenu = memberMenu;
		this.statusList = statusList;
		
		firstSet();
		
		/* testSet(); */
		
		System.out.println("******** KKC Management System ********");
		getMenu();
		
		scanner.close();
	}
	
	
	
	public static void main(String[] args) {
		KKC_System open = new KKC_System();
		EquipmentStatusList statusList = new EquipmentStatusList();
		KKC_MemberMenu memberMenu = new KKC_MemberMenu();
		KKC_EquipmentMenu equipmentMenu = new KKC_EquipmentMenu(memberMenu, statusList);
		open.run(memberMenu, equipmentMenu, statusList);
		
	}

}
