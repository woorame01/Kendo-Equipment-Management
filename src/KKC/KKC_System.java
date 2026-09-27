// v1.0 - 기본 장비 관리 기능 완성
// v1.1 - 장비 상태 관리
package KKC;

import java.util.Scanner;
import Equipment.Equipment_Manager;

import java.util.InputMismatchException;
public class KKC_System {
	Scanner scanner = new Scanner(System.in);
	private  KKC_Member_Manager memberManager;
	private Equipment_Manager equipmentManager;
	
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
				System.out.println("등록된 총 부원은 "+memberManager.getMemberList().size()+"명 입니다.");
				System.out.println("            부원 목록");
				System.out.println();
				memberManager.showMemberList();
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
				
				memberManager.addMember(name, gender, studentID, phone);
				System.out.print("Enter to back...");
				scanner.nextLine();
				continue;
			}
			
			else if(answer == 3) {
				System.out.println("등록된 부원 정보를 찾습니다.");
				System.out.print("찾을 부원의 학번을 입력하세요 >>");
				String studentID = scanner.nextLine();
				System.out.println();
				memberManager.findMember(studentID);
				System.out.print("Enter to back...");
				scanner.nextLine();
				continue;
			}
			
			else if(answer == 4) {
				System.out.println("등록된 부원 정보를 삭제합니다.");
				System.out.print("삭제할 부원의 학번을 입력하세요 >>");
				String studentID = scanner.nextLine();
				KKC_Member findMember = memberManager.findMember(studentID);
				
				if(findMember == null) {
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
				}
				
				while (true) {
				System.out.print("위의 부원의 정보를 삭제하시겠습니까? (Y/N)");
				String YesOrNo = scanner.nextLine();
				if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
					memberManager.deleteMember(findMember);
					for(int i=0; i<equipmentManager.getHoguList().size(); i++) {
						if(equipmentManager.getHoguList().get(i).getMember() == findMember) {
							equipmentManager.deleteHogu(equipmentManager.getHoguList().get(i).getNumber());
						}
					}
					
					for(int i=0; i<equipmentManager.getShinaiList().size(); i++) {
						if(equipmentManager.getShinaiList().get(i).getMember() == findMember) {
							equipmentManager.deleteShinai(equipmentManager.getShinaiList().get(i).getNumber());
						}
					}
					
					equipmentManager.deleteRepairUser(findMember);
					
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
					boolean running = true;
					while(running) {
						System.out.print("어떤 장비를 보시겠습니까 (죽도 / 호구 / 호면 / 호완 / 갑 / 갑상 / 도복)>>");
						String EquipmentType = scanner.nextLine();
						switch (EquipmentType) {
						case "죽도" : {
							if(equipmentManager.getShinaiList().size() == 0) {
								System.out.println("현재 등록되어 있는 죽도가 없습니다.");
								break;
							}
							
							System.out.println("현재 " + equipmentManager.getShinaiList().size() + "개의 죽도가 등록되어 있습니다.");
							System.out.println();
							equipmentManager.showShinaiList();
							System.out.println("*****************************************");
							break; }
						
						case "호구" : {
							if(equipmentManager.getHoguList().size() == 0) {
								System.out.println("현재 등록되어 있는 호구가 없습니다.");
								break;
							}
							
							System.out.println("현재 " + equipmentManager.getHoguList().size() + "개의 호구가 등록되어 있습니다.");
							System.out.println();
							equipmentManager.showHoguList();
							System.out.println("*****************************************");
							break; }
							
						case "호면" : {
							if(equipmentManager.getHomenList().size() == 0) {
								System.out.println("현재 등록되어 있는 호면이 없습니다.");
								break;
							}
							
							System.out.println("현재 " + equipmentManager.getHomenList().size() + "개의 호면이 등록되어 있습니다.");
							System.out.println();
							equipmentManager.showHomenList();
							System.out.println("*****************************************");
							break; }
							
						case "호완" : {
							if(equipmentManager.getHowanList().size() == 0) {
								System.out.println("현재 등록되어 있는 호완이 없습니다.");
								break;
							}
							
							System.out.println("현재 " + equipmentManager.getHowanList().size() + "개의 호완이 등록되어 있습니다.");
							System.out.println();
							equipmentManager.showHowanList();
							System.out.println("*****************************************");
							break; }
							
						case "갑" : {
							if(equipmentManager.getGapList().size() == 0) {
								System.out.println("현재 등록되어 있는 갑이 없습니다.");
								break;
							}
							
							System.out.println("현재 " + equipmentManager.getGapList().size() + "개의 갑이 등록되어 있습니다.");
							System.out.println();
							equipmentManager.showGapList();
							System.out.println("*****************************************");
							break; }
							
						
						case "갑상" : {
							if(equipmentManager.getGapsangList().size() == 0) {
								System.out.println("현재 등록되어 있는 갑상이 없습니다.");
								break;
							}
							
							System.out.println("현재 " + equipmentManager.getGapsangList().size() + "개의 갑상이 등록되어 있습니다.");
							System.out.println();
							equipmentManager.showGapsangList();
							System.out.println("*****************************************");
							break; }
						
						case "도복" : {
							if(equipmentManager.getDobokList().size() == 0) {
								System.out.println("현재 등록되어 있는 도복이 없습니다.");
								break;
							}
							
							System.out.println("현재 " + equipmentManager.getDobokList().size() + "개의 도복이 등록되어 있습니다.");
							System.out.println();
							equipmentManager.showDobokList();
							System.out.println("*****************************************");
							break; }
						
						case "종료" : {
							running = false;
							break;}
							
						default :
							System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						} 
					}
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
				}
				
				else if(answer == 2) { //Equipment Register
					System.out.println("장비 등록을 시작합니다.");
					System.out.println("등록할 장비 종류를 입력하세요 (죽도 / 호구 / 호면 / 호완 / 갑 / 갑상 / 도복)>>");
					String EquipmentType = scanner.nextLine();
					switch (EquipmentType) {
					case "죽도" : {
						if(equipmentManager.getShinaiList().size() != 0) {
							System.out.println("현재 등록된 마지막 죽도 번호는 "+equipmentManager.getShinaiList().getLast().getNumber()+" 입니다."); }
							
							else {System.out.println("첫 장비 등록입니다. 장비번호는 1 입니다.");}
							
							System.out.print("장비번호 >>");
							String number = scanner.nextLine();
							System.out.print("등록일 >>");
							String date = scanner.nextLine();
							while (true) {
							System.out.print("이용자 학번 (없다면 Enter)>>");
							String studentID = scanner.nextLine();
							if(studentID.isEmpty()) {
								equipmentManager.addShinai(number, date); 
								break;
							}
							else {
								KKC_Member setMember = memberManager.findMember(studentID);
								System.out.println();
								if(setMember != null) {
									equipmentManager.addShinai(setMember, number, date);
									break;
								}
								
								else {
									continue;
								}
							}
							
							} 
							break;
					}
							
					case "호구" : {
						String setHomenNumber;
						String setHowanNumber;
						String setGapNumber;
						String setGapsangNumber;
						
						if(equipmentManager.getHoguList().size() != 0) {
							System.out.println("현재 등록된 마지막 호구 번호는 "+equipmentManager.getHoguList().getLast().getNumber()+" 입니다."); }
							
							else {System.out.println("첫 장비 등록입니다. 장비번호는 1 입니다.");}
							
							System.out.print("장비번호 >>");
							String number = scanner.nextLine();
							while (true) {
								System.out.print("등록할 호면번호 >>");
								setHomenNumber = scanner.nextLine();
								if(equipmentManager.findHomen(setHomenNumber) == null) {
									System.out.println("찾을 수 없습니다. 장비번호를 확인하세요.");
									continue;
								}
								else
									break;
								}
							
							while (true) {
								System.out.print("등록할 호완번호 >>");
								setHowanNumber = scanner.nextLine();
								if(equipmentManager.findHowan(setHowanNumber) == null) {
									System.out.println("찾을 수 없습니다. 장비번호를 확인하세요.");
									continue;
								}
								else
									break;
								}
							
							while (true) {
								System.out.print("등록할 갑번호 >>");
								setGapNumber = scanner.nextLine();
								if(equipmentManager.findGap(setGapNumber) == null) {
									System.out.println("찾을 수 없습니다. 장비번호를 확인하세요.");
									continue;
								}
								else
									break;
								}
							
							while (true) {
								System.out.print("등록할 갑상번호 >>");
								setGapsangNumber = scanner.nextLine();
								if(equipmentManager.findGapsang(setGapsangNumber) == null) {
									System.out.println("찾을 수 없습니다. 장비번호를 확인하세요.");
									continue;
								}
								else
									break;
								}
							
							while (true) {
							System.out.print("이용자 학번>>");
							String studentID = scanner.nextLine();
							KKC_Member setMember = memberManager.findMember(studentID);
							System.out.println();
							if(setMember != null) {
								equipmentManager.addHogu(number, equipmentManager.findHomen(setHomenNumber), equipmentManager.findHowan(setHowanNumber), equipmentManager.findGap(setGapNumber), equipmentManager.findGapsang(setGapsangNumber), setMember);
								break;
							}
								
								else {
									continue;
								}
							}
							
							break;
					}
					
					case "호면" : {
						if(equipmentManager.getHomenList().size() != 0) {
							System.out.println("현재 등록된 마지막 호면 번호는 "+equipmentManager.getHomenList().getLast().getNumber()+" 입니다."); }
							
							else {System.out.println("첫 장비 등록입니다. 장비번호는 1 입니다.");}
							
							System.out.print("장비번호 >>");
							String number = scanner.nextLine();
							System.out.print("등록일 >>");
							String date = scanner.nextLine();
							
							equipmentManager.addHomen(number, date);
							
							break;
					}
					

					case "호완" : {
						if(equipmentManager.getHowanList().size() != 0) {
							System.out.println("현재 등록된 마지막 호완 번호는 "+equipmentManager.getHowanList().getLast().getNumber()+" 입니다."); }
							
							else {System.out.println("첫 장비 등록입니다. 장비번호는 1 입니다.");}
							
							System.out.print("장비번호 >>");
							String number = scanner.nextLine();
							System.out.print("등록일 >>");
							String date = scanner.nextLine();
							
							equipmentManager.addHowan(number, date);
							
							break;
						
					}
					

					case "갑" : {
						if(equipmentManager.getGapList().size() != 0) {
							System.out.println("현재 등록된 마지막 갑 번호는 "+equipmentManager.getGapList().getLast().getNumber()+" 입니다."); }
							
							else {System.out.println("첫 장비 등록입니다. 장비번호는 1 입니다.");}
							
							System.out.print("장비번호 >>");
							String number = scanner.nextLine();
							System.out.print("등록일 >>");
							String date = scanner.nextLine();
							
							equipmentManager.addGap(number, date);
							
							break;
						
					}
					

					case "갑상" : {
						if(equipmentManager.getGapsangList().size() != 0) {
							System.out.println("현재 등록된 마지막 갑상 번호는 "+equipmentManager.getGapsangList().getLast().getNumber()+" 입니다."); }
							
							else {System.out.println("첫 장비 등록입니다. 장비번호는 1 입니다.");}
							
							System.out.print("장비번호 >>");
							String number = scanner.nextLine();
							System.out.print("등록일 >>");
							String date = scanner.nextLine();
							
							equipmentManager.addGapsang(number, date);
							
							break;
						
					}
					

					case "도복" : {
						if(equipmentManager.getDobokList().size() != 0) {
							System.out.println("현재 등록된 마지막 도복 번호는 "+equipmentManager.getDobokList().getLast().getNumber()+" 입니다."); }
							
							else {System.out.println("첫 장비 등록입니다. 장비번호는 1 입니다.");}
							
							System.out.print("장비번호 >>");
							String number = scanner.nextLine();
							System.out.print("등록일 >>");
							String date = scanner.nextLine();
							
							equipmentManager.addDobok(number, date);
							
							break;
						
					}
					

					case "종료" : {
						break;
					}
					
					default :
						System.out.println("잘못된 입력입니다.");
					
				}
					
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
					System.out.println("죽도 이용자를 등록합니다.");
					while (true) {
					System.out.print("이용자 미등록 죽도 목록을 보시겠습니까? (Y/N) >>");
					String YesOrNo = scanner.nextLine();
					
					if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
						System.out.println("현재 이용자 미등록 장비는 "+equipmentManager.getShinaiNullUserCount()+"개 입니다.");
						System.out.println("            미등록 장비 목록");
						System.out.println();
						equipmentManager.showShinaiNullUserList();
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
					
					if(equipmentManager.getShinaiNullUserCount() == 0) {
						System.out.println("현재 모든 장비 이용자가 등록되어 있습니다.");
						System.out.print("Enter to back...");
						scanner.nextLine();
						continue;
					}
					
					System.out.print("등록할 장비 번호를 입력하세요 >>");
					String number = scanner.nextLine();
					while (true) {
					System.out.print("등록할 사용자의 학번을 입력하세요 >>");
					String studentID = scanner.nextLine();
					KKC_Member member = memberManager.findMember(studentID); 
					if(member == null) {
						continue;
					}
					else {
						equipmentManager.setEquipment_User("죽도", number, member);
						break;
						}
					}
					
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
					}
					
					else if(answer == 2) {
						System.out.println("장비 이용자를 변경합니다.");
						System.out.print("변경할 장비 종류를 입력하세요 (죽도 / 호구) >>");
						String EquipmentType = scanner.nextLine();
						switch (EquipmentType) {
						case "죽도" : {
							while (true) {
								System.out.print("변경할 장비 번호를 입력하세요 >>");
								String number = scanner.nextLine();
								
								if(equipmentManager.findShinai(number) == null) {
									System.out.println("장비를 찾을 수 없습니다. 장비 번호를 확인하세요.");
									continue;
								}
								
								if(number.equals("취소")) {
									break;
								}
								
								System.out.print("변경할 이용자의 학번를 입력하세요 >>");
								String StudentID = scanner.nextLine();
								

								if(memberManager.findMemberNoComment(StudentID) == null) {
									System.out.println("이용자를 찾을 수 없습니다. 학번을 확인하세요.");
									continue;
								}
								
								if(StudentID.equals("취소")) {
									break;
								}
								
								equipmentManager.setEquipment_User(EquipmentType, number, memberManager.findMemberNoComment(StudentID));
								
								
								System.out.println("변경 완료");
								equipmentManager.showShinai(number);
								break;
							
							}
						}
							
						
						
						case "호구" : {
							while (true) {
								System.out.print("변경할 장비 번호를 입력하세요 >>");
								String number = scanner.nextLine();
								
								if(equipmentManager.findHogu(number) == null) {
									System.out.println("장비를 찾을 수 없습니다. 장비 번호를 확인하세요.");
									continue;
								}
								
								if(number.equals("취소")) {
									break;
								}
								
								System.out.print("변경할 이용자의 학번를 입력하세요 >>");
								String StudentID = scanner.nextLine();
								
								if(memberManager.findMemberNoComment(StudentID) == null) {
									System.out.println("이용자를 찾을 수 없습니다. 학번을 확인하세요.");
									continue;
								}
								
								
								if(StudentID.equals("취소")) {
									break;
								}
								
								equipmentManager.setEquipment_User(EquipmentType, number, memberManager.findMemberNoComment(StudentID));
								
								
								System.out.println("변경 완료");
								equipmentManager.showHogu(number);
								break;
							
							}

							
						}
						
						case "종료" : {
							break;
						}
						
						default :
							System.out.println("잘못된 입력입니다.");
						
						
						}
						
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
					System.out.print("변경할 장비 종류를 입력하세요 (죽도 / 호면 / 호완 / 갑 / 갑상) >>");
					String EquipmentType = scanner.nextLine();
					String number, part, statusType;
					switch (EquipmentType) {
					case "죽도" : {
						while (true) {
							System.out.print("변경할 장비 번호를 입력하세요 >>");
						 	number = scanner.nextLine();
						 	
						 	if(equipmentManager.findHogu(number) == null) {
								System.out.println("장비를 찾을 수 없습니다. 장비 번호를 확인하세요.");
								continue;
							}
						 	
						 	break;
						 	
						}
						 	
						while (true) {
						 	System.out.println("| 선혁 | 선고무 | 중혁 | 병혁 | 등줄 | 코등이 | 코등이 받침 |");
						 	System.out.print("변경할 장비 부위를 선택하세요>>");
						 	part = scanner.nextLine();
						 	
						 	if(part.equals("선혁") || part.equals("선고무") || part.equals("중혁") || part.equals("병혁")
						 	|| part.equals("등줄") || part.equals("코등이") || part.equals("코등이 받침")) {
						 		break;
						 	}
						 	
						 	else {
						 		System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						 		continue;
						 	}
						 	
						}
						
						while (true) {
						 	System.out.println("| 사용가능 | 수리필요 | 수리불가능 | 폐기 |");
						 	System.out.print("지정할 상태를 입력하세요 >>");
						 	statusType = scanner.nextLine();
						 
						 	if(statusType.equals("사용가능") || statusType.equals("수리필요") 
						 	|| statusType.equals("수리불가능") || statusType.equals("폐기")) {
						 		break;
						 	}
						 	
						 	else {
						 		System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						 		continue;
						 	}
			
						}
						
						equipmentManager.setShinai_Status(number, part, statusType);
						System.out.println("변경 완료");
						equipmentManager.showShinai(number);
						break;
					}
					
					case "호면" : {
						while (true) {
							System.out.print("변경할 장비 번호를 입력하세요 >>");
						 	number = scanner.nextLine();
						 	
						 	if(equipmentManager.findHomen(number) == null) {
								System.out.println("장비를 찾을 수 없습니다. 장비 번호를 확인하세요.");
								continue;
							}
						 	
						 	break;
						 	
						}
						
						while (true) {
						 	System.out.println("| 사용가능 | 수리필요 | 수리불가능 | 폐기 |");
						 	System.out.print("지정할 상태를 입력하세요 >>");
						 	statusType = scanner.nextLine();
						 
						 	if(statusType.equals("사용가능") || statusType.equals("수리필요") 
						 	|| statusType.equals("수리불가능") || statusType.equals("폐기")) {
						 		break;
						 	}
						 	
						 	else {
						 		System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						 		continue;
						 	}
			
						}
						
						equipmentManager.setHomen_Status(number, statusType);
						System.out.println("변경 완료");
						equipmentManager.showHomen(number);
						break;
						
					}
					

					case "호완" : {
						while (true) {
							System.out.print("변경할 장비 번호를 입력하세요 >>");
						 	number = scanner.nextLine();
						 	
						 	if(equipmentManager.findHowan(number) == null) {
								System.out.println("장비를 찾을 수 없습니다. 장비 번호를 확인하세요.");
								continue;
							}
						 	
						 	break;
						 	
						}
						
						while (true) {
						 	System.out.println("| 사용가능 | 수리필요 | 수리불가능 | 폐기 |");
						 	System.out.print("지정할 상태를 입력하세요 >>");
						 	statusType = scanner.nextLine();
						 
						 	if(statusType.equals("사용가능") || statusType.equals("수리필요") 
						 	|| statusType.equals("수리불가능") || statusType.equals("폐기")) {
						 		break;
						 	}
						 	
						 	else {
						 		System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						 		continue;
						 	}
			
						}
						
						equipmentManager.setHowan_Status(number, statusType);
						System.out.println("변경 완료");
						equipmentManager.showHowan(number);
						break;
						
					}
					

					case "갑" : {
						while (true) {
							System.out.print("변경할 장비 번호를 입력하세요 >>");
						 	number = scanner.nextLine();
						 	
						 	if(equipmentManager.findGap(number) == null) {
								System.out.println("장비를 찾을 수 없습니다. 장비 번호를 확인하세요.");
								continue;
							}
						 	
						 	break;
						 	
						}
						
						while (true) {
						 	System.out.println("| 사용가능 | 수리필요 | 수리불가능 | 폐기 |");
						 	System.out.print("지정할 상태를 입력하세요 >>");
						 	statusType = scanner.nextLine();
						 
						 	if(statusType.equals("사용가능") || statusType.equals("수리필요") 
						 	|| statusType.equals("수리불가능") || statusType.equals("폐기")) {
						 		break;
						 	}
						 	
						 	else {
						 		System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						 		continue;
						 	}
			
						}
						
						equipmentManager.setGap_Status(number, statusType);
						System.out.println("변경 완료");
						equipmentManager.showGap(number);
						break;
						
					}
					

					case "갑상" : {
						while (true) {
							System.out.print("변경할 장비 번호를 입력하세요 >>");
						 	number = scanner.nextLine();
						 	
						 	if(equipmentManager.findGapsang(number) == null) {
								System.out.println("장비를 찾을 수 없습니다. 장비 번호를 확인하세요.");
								continue;
							}
						 	
						 	break;
						 	
						}
						
						while (true) {
						 	System.out.println("| 사용가능 | 수리필요 | 수리불가능 | 폐기 |");
						 	System.out.print("지정할 상태를 입력하세요 >>");
						 	statusType = scanner.nextLine();
						 
						 	if(statusType.equals("사용가능") || statusType.equals("수리필요") 
						 	|| statusType.equals("수리불가능") || statusType.equals("폐기")) {
						 		break;
						 	}
						 	
						 	else {
						 		System.out.println("잘못된 입력입니다. 다시 입력하세요.");
						 		continue;
						 	}
			
						}
						
						equipmentManager.setGapsang_Status(number, statusType);
						System.out.println("변경 완료");
						equipmentManager.showGapsang(number);
						break;
						
					}
					

					case "종료" : {
						break;
					}
					
					default :
						System.out.println("잘못된 입력입니다.");
					
					
					}
					
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
					
				}
				
				else if(answer == 5) { //Find Equipment
					
					String EquipmentType, number;
					
					System.out.println("등록된 장비 정보를 찾습니다.");
					System.out.print("찾을 장비 종류를 입력하세요 (죽도 / 호구 / 호면 / 호완 / 갑 / 갑상) >>");
					EquipmentType = scanner.nextLine();
					
					switch (EquipmentType) {
					case "죽도" : {
						System.out.print("찾을 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findShinai(number) != null) {
							equipmentManager.showShinai(number);
						}
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
					}
				
					case "호구" : {
						System.out.print("찾을 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findHogu(number) != null) {
							equipmentManager.showHogu(number);
						}
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
					}

					case "호면" : {
						System.out.print("찾을 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findHomen(number) != null) {
							equipmentManager.showHomen(number);
						}
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
					}

					case "호완" : {
						System.out.print("찾을 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findHowan(number) != null) {
							equipmentManager.showHowan(number);
						}
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
						
					}

					case "갑" : {
						System.out.print("찾을 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findGap(number) != null) {
							equipmentManager.showGap(number);
						}
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
						
					}

					case "갑상" : {
						System.out.print("찾을 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findGapsang(number) != null) {
							equipmentManager.showGapsang(number);
						}
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
					}
				
					case "종료" : {
						break;
					}
					
					default :
						System.out.println("잘못된 입력입니다.");
					
					
					}
					
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
	
 				}
				
				else if(answer == 6) { //Delete Equipment
					String EquipmentType, number;
					
					System.out.println("등록된 장비 정보를 삭제합니다.");
					System.out.print("삭제할 장비 종류를 입력하세요 (죽도 / 호구 / 호면 / 호완 / 갑 / 갑상 / 도복) >>");
					EquipmentType = scanner.nextLine();
					
					switch (EquipmentType) {
					case "죽도" : {
						System.out.print("삭제할 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findShinai(number) != null) {
							equipmentManager.showShinai(number);
							
							while (true) {
								System.out.print("위 장비의 정보를 삭제하시겠습니까? (Y/N)");
								String YesOrNo = scanner.nextLine();
								if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
									equipmentManager.deleteShinai(number);
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
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
					}
				
					case "호구" : {
						System.out.print("삭제할 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findHogu(number) != null) {
							equipmentManager.showHogu(number);
							
							while (true) {
								System.out.print("위 장비의 정보를 삭제하시겠습니까? (Y/N)");
								String YesOrNo = scanner.nextLine();
								if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
									equipmentManager.deleteHogu(number);
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
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
					}

					case "호면" : {
						System.out.print("삭제할 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findHomen(number) != null) {
							equipmentManager.showHomen(number);
							
							while (true) {
								System.out.print("위 장비의 정보를 삭제하시겠습니까? (Y/N)");
								String YesOrNo = scanner.nextLine();
								if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
									equipmentManager.deleteHomen(number);
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
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
					}

					case "호완" : {
						System.out.print("찾을 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findHowan(number) != null) {
							equipmentManager.showHowan(number);
							
							while (true) {
								System.out.print("위 장비의 정보를 삭제하시겠습니까? (Y/N)");
								String YesOrNo = scanner.nextLine();
								if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
									equipmentManager.deleteHowan(number);
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
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
						
					}

					case "갑" : {
						System.out.print("찾을 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findGap(number) != null) {
							equipmentManager.showGap(number);
							
							while (true) {
								System.out.print("위 장비의 정보를 삭제하시겠습니까? (Y/N)");
								String YesOrNo = scanner.nextLine();
								if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
									equipmentManager.deleteGap(number);
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
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
						
					}

					case "갑상" : {
						System.out.print("찾을 장비 번호를 입력하세요>>");
						number = scanner.nextLine();
						if(equipmentManager.findGapsang(number) != null) {
							equipmentManager.showGapsang(number);
							
							while (true) {
								System.out.print("위 장비의 정보를 삭제하시겠습니까? (Y/N)");
								String YesOrNo = scanner.nextLine();
								if(YesOrNo.equals("y") || YesOrNo.equals("Y")) {
									equipmentManager.deleteGapsang(number);
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
						
						else
							System.out.println("등록된 장비가 없습니다.");
						
						break;
						
						
					}
				
					case "종료" : {
						break;
					}
					
					default :
						System.out.println("잘못된 입력입니다.");
					
					
					}
					
					System.out.print("Enter to back...");
					scanner.nextLine();
					continue;
	
 				}
				
				
				else if(answer == 7) { //Back to main
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
	
	public void run(KKC_Member_Manager memberManager, Equipment_Manager equipmentManager) {
		this.equipmentManager = equipmentManager;
		this.memberManager = memberManager;
		
		/* testSet(); */
		
		System.out.println("******** KKC Management System ********");
		getMenu();
		
		scanner.close();
	}
	
	
	
	public static void main(String[] args) {
		KKC_System open = new KKC_System();
		KKC_Member_Manager memberManager = new KKC_Member_Manager();
		Equipment_Manager equipmentManager = new Equipment_Manager();
		open.run(memberManager, equipmentManager);
		
	}

}
