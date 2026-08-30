import java.util.Scanner;
import java.util.InputMismatchException;
public class KKC_System {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a=8, b=4;
		int count = 0;
		
		String 부원List[][] = new String[a][4];                 				//이름,성별,학번,전화번호
		String 장비List[][] = new String[b][5];								//장비번호,장비종류,성별,등록일,사용자
		
		장비List[0][0] = "죽도-001";
		장비List[0][1] =	"죽도";
		장비List[0][2] = "남성용";
		장비List[0][3] = "26-08-28";
		장비List[0][4] = "5753764";
		
		장비List[1][0] = "죽도-002";
		장비List[1][1] =	"죽도";
		장비List[1][2] = "여성용";
		장비List[1][3] = "26-08-28";
		장비List[1][4] = "3333333";
		
		장비List[2][0] = "죽도-003";
		장비List[2][1] =	"죽도";
		장비List[2][2] = "남성용";
		장비List[2][3] = "26-08-28";
		장비List[2][4] = "미등록";
		
		장비List[3][0] = "죽도-004";
		장비List[3][1] =	"죽도";
		장비List[3][2] = "남성용";
		장비List[3][3] = "26-08-28";
		장비List[3][4] = "미등록";
				
		부원List[0][0] = "김우람";
		부원List[0][1] = "남성";
		부원List[0][2] = "5753764";
		부원List[0][3] = "010-6645-3909";
		
		부원List[1][0] = "홍길동";
		부원List[1][1] = "남성";
		부원List[1][2] = "1111111";
		부원List[1][3] = "010-5678-1234";
		
		부원List[2][0] = "김삿갓";
		부원List[2][1] = "남성";
		부원List[2][2] = "2222222";
		부원List[2][3] = "010-2342-2762";
		
		부원List[3][0] = "황정이";
		부원List[3][1] = "여성";
		부원List[3][2] = "3333333";
		부원List[3][3] = "010-3263-7393";
		
		부원List[4][0] = "테스트1";
		부원List[4][1] = "남성";
		부원List[4][2] = "4444444";
		부원List[4][3] = "010-6635-3249";
		
		부원List[5][0] = "테스트2";
		부원List[5][1] = "남성";
		부원List[5][2] = "5555555";
		부원List[5][3] = "010-5018-1204";
		
		부원List[6][0] = "테스트3";
		부원List[6][1] = "남성";
		부원List[6][2] = "6666666";
		부원List[6][3] = "010-2252-6822";
		
		부원List[7][0] = "테스트4";
		부원List[7][1] = "여성";
		부원List[7][2] = "7777777";
		부원List[7][3] = "010-3093-3872";
		
		while (true) {
			
		System.out.println("===== 검도부 장비 관리 =====");
		System.out.println();
		System.out.println("------- 부원 관리 -------");
		System.out.println("------- 장비 관리 -------");
		System.out.println();
		System.out.println("시스템을 종료하려면 종료를 입력해주세요.");
		System.out.print(">>");
		String 메뉴 = scanner.nextLine();
		
		if(메뉴.equals("종료")) {
			System.out.println("시스템을 종료합니다.");
			break;
		}
		
		if(메뉴.equals("부원 관리") || 메뉴.equals("부원관리")) {
			while (true) {
				System.out.println("======= 부원 관리 =======");
				System.out.println();
				System.out.println("------- 부원 목록 -------");
				System.out.println("------- 부원 등록 -------");
				System.out.println("------- 부원 삭제 -------");
				System.out.println();
				System.out.println("메인 메뉴로 나가려면 뒤로가기를 입력해주세요.");
				System.out.print(">>");
				String 부원 = scanner.nextLine();                                 //부원 목록, 부원 등록 인식 기능 추가
				
				if(부원.equals("뒤로가기") || 부원.equals("뒤로 가기")) {
					System.out.println();
					break;
				}
				
				if(부원.equals("부원 목록") || 부원.equals("부원목록")) {
					System.out.println("======= 부원 목록 =======");
					System.out.println();
					for(int i=0; i<부원List.length; i++) {
							System.out.print("이름 " + 부원List[i][0] + " ");
							System.out.print("성별 " + 부원List[i][1] + " ");
							System.out.print("학번 " + 부원List[i][2] + " ");
							System.out.println("전화번호 " + 부원List[i][3] + " ");
							System.out.println();
					}
					
					System.out.println("-------- 끝 ---------");
					
					System.out.println();
					System.out.println("Enter...");
					scanner.nextLine();
					continue;
				}
				
				if(부원.equals("부원 등록") || 부원.equals("부원등록")) {
					
					System.out.println("======= 부원 등록 =======");
					System.out.println();
					
					int ai = a-1;
					
					System.out.print("이름 >>");
					부원List[ai][0] = scanner.nextLine();
					
					System.out.print("성별 >>");
					부원List[ai][1] = scanner.next();
					
					System.out.print("학번 >>");
					부원List[ai][2] = scanner.next();
					
					System.out.print("전화번호 >>");
					부원List[ai][3] = scanner.next();
					System.out.println();
					System.out.print("등록완료");
					scanner.nextLine();
					
					a++;													// 이건 부원 등록하면 배열 하나 추가해서 자리 마련하는 건데
					String[][] newList = new String[a+1][4];				// 잘 안됨 잘 안되는게 아니고 안됨 그냥 나중에 새로 구연해야될듯.
					부원List = newList;										// DB 배워서 구연하는게 날듯
					
					System.out.println();
					System.out.println("Enter...");
					scanner.nextLine();
					continue;
					
				}
				
				if(부원.equals("부원 삭제") || 부원.equals("부원삭제")) {
					
					System.out.println("======= 부원 삭제 =======");
					System.out.println();
					
					System.out.print("삭제할 학번 >>");
					String 삭제 = scanner.next();
					
					int i = 0;
					
					while (i<=부원List.length) {	
						
						if (i==부원List.length) {
							System.out.println("등록된 정보가 없습니다.");
							scanner.nextLine();
							break;	
						}
						
						if(부원List[i][2].equals(삭제)) {
							System.out.println("삭제할 부원의 정보를 찾았습니다.");
							System.out.println();
							System.out.print("이름 " + 부원List[i][0] + " ");
							System.out.print("성별 " + 부원List[i][1] + " ");
							System.out.print("학번 " + 부원List[i][2] + " ");
							System.out.println("전화번호 " + 부원List[i][3] + " ");
							System.out.print("이 부원 정보를 삭제하시겠습니까?(Y/N) >>");
							String text = scanner.next();
							
							if(text.equals("Y") || text.equals("y")) {
								scanner.nextLine();
								for(int j=i+1; j<부원List.length; j++) {
									
									if(j<(부원List.length-1))
										부원List[i] = 부원List[j];					// 삭제할 부원의 데이터를 다음 배열에 있는 데이터로 변경 (한칸씩 떙겨서 저장)
								
									
									if(j==(부원List.length-1))
										부원List[j] = null;
									
									i++;
										
								}
								
									System.out.println("부원 정보를 성공적으로 삭제하였습니다."); break;       // 마지막 배열의 정보는 null로 변경되는데 문제는 출력시 예외가 발생하여 예외 처리 필요
							}
							
							if(text.equals("N") || text.equals("n")) {
								scanner.nextLine();
								System.out.println("부원 정보 삭제를 취소합니다.");
							} break;
						}	
							
						i++;
					
					}
					
					System.out.println();
					System.out.println("Enter...");
					scanner.nextLine();
					continue;
				}
			} continue;
		}
		
		
		if(메뉴.equals("장비 관리") || 메뉴.equals("장비관리")) {
			
			while (true) {
				System.out.println("======= 장비 관리 =======");
				System.out.println();
				System.out.println("------- 장비 목록 -------");
				System.out.println("------- 장비 등록 -------");
				System.out.println("---- 장비 사용자 등록 -----");
				System.out.println();
				System.out.println("메인 메뉴로 나가려면 뒤로가기를 입력해주세요.");
				System.out.print(">>");
				String 장비 = scanner.nextLine(); 								//장비 목록, 장비 등록 인식 기능 추가
				
				if(장비.equals("뒤로가기") || 장비.equals("뒤로 가기")) {
					System.out.println();
					break;
				}
				
				if(장비.equals("장비 목록") || 장비.equals("장비목록")) {
					System.out.println("======= 장비 목록 =======");
					System.out.println();
					for(int i=0; i<장비List.length; i++) {
							System.out.print("장비번호 > " + 장비List[i][0] + " ");
							System.out.print("장비종류 > " + 장비List[i][1] + " ");
							System.out.print("성별 > " + 장비List[i][2] + " ");
							System.out.print("등록일 > " + 장비List[i][3] + " ");
							System.out.println("사용자 > " + 장비List[i][4] + " ");
							System.out.println();
					}
					
					System.out.println("-------- 끝 ---------");
					
					System.out.println();
					System.out.println("Enter...");
					scanner.nextLine();
					continue;
					
				}
				
				if(장비.equals("장비 등록") || 장비.equals("장비등록")) {
					
					System.out.println("======= 장비 등록 =======");
					System.out.println("마지막 장비 번호는 "+장비List[장비List.length-1][0]+"입니다.");
					System.out.println();
					
					int bi = b-1;
					
					System.out.print("장비번호 >>");
					장비List[bi][0] = scanner.nextLine();
					
					System.out.print("장비종류 >>");
					장비List[bi][1] = scanner.next();
					
					System.out.print("성별 >>");
					장비List[bi][2] = scanner.next();
					scanner.nextLine();
					
					System.out.print("등록일 >>");
					장비List[bi][3] = scanner.nextLine();
					
					System.out.print("장비 사용자를 등록하시겠습니까?(Y/N) >>");
					String 장비등록여부 = scanner.nextLine();
					
					if(장비등록여부.equals("Y") || 장비등록여부.equals("y")) {
						count = 0;
						System.out.print("등록할 사용자의 학번을 입력하세요.>>");
						String 장비등록학번1 = scanner.nextLine();
						
						for(int i=0; i<부원List.length; i++) {
							
							if(부원List[i][2].equals(장비등록학번1)) {
								count++;
								System.out.println("등록할 사용자는 "+부원List[i][0]+" "+부원List[i][2]+" 입니다.");
								System.out.println("등록 하시겠습니까?(Y/N) >>");
								String 장비등록여부확인1 = scanner.nextLine();
								
								if(장비등록여부확인1.equals("Y") || 장비등록여부확인1.equals("y")) {
									장비List[bi][4] = 부원List[i][2];
									System.out.println(장비List[bi][0]+"의 사용자로 "+부원List[i][2]+"을 등록했습니다.");
									break;
								}
								if(장비등록여부확인1.equals("N") || 장비등록여부확인1.equals("n")) {
									count++;
									System.out.println("장비의 사용자를 미등록으로 저장합니다.");
									장비List[bi][4] = "미등록";
									break;
								}
								
							}
							
						}
						
						if(count == 0) {
							System.out.print("등록할 사용자를 찾을 수 없습니다.");
							System.out.println("장비의 사용자를 미등록으로 저장합니다.");
							장비List[bi][4] = "미등록";
						}
						
					}
					
					if(장비등록여부.equals("N") || 장비등록여부.equals("n")) {
						System.out.println("장비의 사용자를 미등록으로 저장합니다.");
						장비List[bi][4] = "미등록";
					}
					
					System.out.println();
				
					System.out.println("장비 등록완료");
					
					b++;													// 이건 장비 등록하면 배열 하나 추가해서 자리 마련하는 건데
					String[][] newList = new String[b+1][5];				// 잘 안됨 잘 안되는게 아니고 안됨 그냥 나중에 새로 구연해야될듯.
					장비List = newList;										// DB 배워서 구연하는게 날듯
																			// 추가로 이딴식으로 하면 위에 저장한 값 다 초기화됨.
					System.out.println();
					System.out.println("Enter...");
					scanner.nextLine();
					continue;
				
				}
				
				if(장비.equals("장비 사용자 등록") || 장비.equals("장비사용자 등록") ||
					장비.equals("장비 사용자등록") || 장비.equals("장비사용자등록")) {
					System.out.println("===== 장비 사용자 등록 =====");
					System.out.println();
					System.out.print("등록할 장비의 번호를 입력하세요>>");
					count=0;
					String 등록장비번호 = scanner.nextLine();
					for(int i=0; i<장비List.length; i++) {
						if(장비List[i][0].equals(등록장비번호)) {
							if(장비List[i][4].equals("미등록")) {
								System.out.print("등록할 사용자의 학번을 입력하세요>>");
								String 장비등록학번2 =scanner.nextLine();
								
								for(int j=0; j<부원List.length; j++) {
									if(부원List[j][2].equals(장비등록학번2)) {
										System.out.println("등록할 사용자는 "+부원List[j][0]+" "+부원List[j][2]+" 입니다.");
										System.out.println("등록 하시겠습니까?(Y/N) >>");
										String 장비등록여부확인1 = scanner.nextLine();
										
										if(장비등록여부확인1.equals("Y") || 장비등록여부확인1.equals("y")) {
											장비List[i][4] = 부원List[j][2];
											System.out.println(장비List[i][0]+"의 사용자로 "+부원List[j][2]+"을 등록했습니다.");
											count++;
											break;
											
										}
										
										if(장비등록여부확인1.equals("N") || 장비등록여부확인1.equals("n")) {
											System.out.println("장비 사용자 등록을 종료합니다.");
											count++;
											break;
										}
									}
									}
								
								}
							
							else {
								System.out.println("현재 "+등록장비번호+"의 사용자는 "+장비List[i][4]+"로 등록되어 있습니다.");
								
								for(int j=0; j<부원List.length; j++) {
									
									if(장비List[i][4].equals(부원List[j][2])) {
									System.out.println(장비List[i][4]+"는 "+부원List[j][0]+"입니다."); 
									break;
									}
								}
								System.out.print("사용자를 변경하시겠습니까?(Y/N)>>");
								String 장비등록변경여부 = scanner.nextLine();
								
								if(장비등록변경여부.equals("Y") || 장비등록변경여부.equals("y")) {
									System.out.print("등록할 사용자의 학번을 입력하세요>>");
									String 장비등록학번2 =scanner.nextLine();
									
									for(int j=0; j<부원List.length; j++) {
										if(부원List[j][2].equals(장비등록학번2)) {
											System.out.println("등록할 사용자는 "+부원List[j][0]+" "+부원List[j][2]+" 입니다.");
											System.out.println("등록 하시겠습니까?(Y/N) >>");
											String 장비등록여부확인1 = scanner.nextLine();
											
											if(장비등록여부확인1.equals("Y") || 장비등록여부확인1.equals("y")) {
												장비List[i][4] = 부원List[j][2];
												System.out.println(장비List[i][0]+"의 사용자로 "+부원List[j][2]+"을 등록했습니다.");
												count++;
												break;
												
											}
											
											if(장비등록여부확인1.equals("N") || 장비등록여부확인1.equals("n")) {
												System.out.println("장비 사용자 등록을 종료합니다.");
												count++;
												break;
											}
										}
									}
								}
								if(장비등록변경여부.equals("N") || 장비등록변경여부.equals("n")) {
									System.out.println("장비 사용자 등록을 종료합니다.");
									count++;
									break;
								}
							
							}
							
							}
							
						}
					
					if(count == 0) {
						System.out.println("등록할 사용자를 찾을 수 없습니다.");
						System.out.println("장비 사용자 등록을 종료합니다.");
						
					}
					
					System.out.println();
					System.out.println("Enter...");
					scanner.nextLine();
					continue;
					
					}
				}	
			}
		}
		scanner.close();
	}

}
