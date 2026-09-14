// 장비 관리 시스템
// GitHub 개발 환경 테스트

import java.util.Scanner;
import java.util.InputMismatchException;
public class KKC_System {
	Scanner scanner = new Scanner(System.in);
	private  KKC_MemberMenu memberMenu;
	private KKC_EquipmentMenu equipmentMenu;
	int answer;
	
	public void getMenu() {
		while (true) {
		System.out.println();
		System.out.println("            Member Management");
		System.out.println("            Equipment Management");
		System.out.println();
		System.out.print("choice... 1(Member) | 2(Equipment) | 3(Close) >>");
		answer = scanner.nextInt();
		
		if(answer == 1) {
			while (true) {
			System.out.println();
			System.out.println("            View member list");
			System.out.println("            Register as a new member");
			System.out.println("            Find member information");
			System.out.println("            Delete member information");
			System.out.print("choice... 1(View List) | 2(Register) | 3(Find) | 4(Delete) | 5(Back)>>");
			answer = scanner.nextInt();
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
				System.out.print("위의 부원의 정보를 삭제하시겠습니까? (Y/N)");
				String answer = scanner.nextLine();
				if(answer.equals("y") || answer.equals("Y")) {
					memberMenu.deleteMember(findMember);
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
				}
				
				else {
					System.out.println("부원 삭제를 취소하였습니다.");
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
				}
			}
			
			else if(answer == 5) {
				break;
			}
		}
		}
		
		if(answer == 2) {
			while (true) {
				System.out.println();
				System.out.println("            View Equipment list");
				System.out.println("            Register new equipment");
				System.out.println("            Equipment User Registration");
				System.out.println("            Find equipment information");
				System.out.println("            Delete equipment information");
				System.out.print("choice... 1(View List) | 2(Equipment Register) | 3(User Register) | 4(Find) | 5(Delete) | 6(Back)>>");
				answer = scanner.nextInt();
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
					
					equipmentMenu.addEquipment(Number, type, gender, date, studentID);
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
					
				}
				
				else if(answer == 3) { //User Register
					System.out.println("장비 이용자를 등록합니다.");
					System.out.print("이용자 미등록 장비 목록을 보시겠습니까? (Y/N) >>");
					String answer = scanner.nextLine();
					
					if(answer.equals("y") || answer.equals("Y")) {
						System.out.println("현재 이용자 미등록 장비는 "+equipmentMenu.EquipmentNullUserCount()+"개 입니다.");
						System.out.println("            미등록 장비 목록");
						System.out.println();
						equipmentMenu.showEquipmentNullUserList();
						System.out.print("Enter to continue...");
						scanner.nextLine();
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
				
				else if(answer == 4) { //Find Equipment
					System.out.println("등록된 장비 정보를 찾습니다.");
					System.out.print("찾을 장비 번호를 입력하세요 >>");
					String number = scanner.nextLine();
					System.out.println();
					equipmentMenu.findEquipment(number);
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
	
 				}
				
				else if(answer == 5) { //Delete Equipment
					System.out.println("등록된 장비 정보를 삭제합니다.");
					System.out.print("삭제할 장비 번호를 입력하세요 >>");
					String number = scanner.nextLine();
					KKC_Equipment findEquipment = equipmentMenu.findEquipment(number);
					
					if(findEquipment == null) {
						System.out.print("Enter to back...");
						scanner.nextLine();
						continue;
					}
					System.out.print("위 장비의 정보를 삭제하시겠습니까? (Y/N)");
					String answer = scanner.nextLine();
					if(answer.equals("y") || answer.equals("Y")) {
						equipmentMenu.deleteEquipment(findEquipment);
						System.out.print("Enter to back...");
						scanner.nextLine();
						continue;
					}
					
					else {
						System.out.println("장비 삭제를 취소하였습니다.");
						System.out.print("Enter to back...");
						scanner.nextLine();
						continue;
					}
					
				}
				
				else if(answer == 6) { //Back to main
					break;
				}
				
			}
		}
		
		if(answer == 3) {
			System.out.println("KKC Management Close");
			break;
		}
			
	}
		
	}
	
	public void run(KKC_MemberMenu memberMenu, KKC_EquipmentMenu equipmentMenu) {
		this.equipmentMenu = equipmentMenu;
		this.memberMenu = memberMenu;
		
		System.out.println("******** KKC Management System ********");
		getMenu();
		
		scanner.close();
	}
	
	
	
	public static void main(String[] args) {
		KKC_System open = new KKC_System();
		KKC_MemberMenu memberMenu = new KKC_MemberMenu();
		KKC_EquipmentMenu equipmentMenu = new KKC_EquipmentMenu(memberMenu);
		open.run(memberMenu, equipmentMenu);
		
	}

}
