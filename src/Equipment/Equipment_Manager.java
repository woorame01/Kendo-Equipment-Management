package Equipment;
import KKC.KKC_Member;
import java.util.ArrayList;

/* 기능 목록
 * 장비 등록 v
 * 장비 조회 v
 * 장비 삭제 v
 * 장비 상태 변경 v
 * 호구 구성 v
 * 죽도 이용자 등록 v
 * 수리 내역 등록/조회 v
 * */

public class Equipment_Manager {
	private ArrayList <Equipment_Shinai> shinaiList = new ArrayList <Equipment_Shinai>();
	private ArrayList <Equipment_Homen> homenList = new ArrayList <Equipment_Homen>();
	private ArrayList <Equipment_Howan> howanList = new ArrayList <Equipment_Howan>();
	private ArrayList <Equipment_Gap> gapList = new ArrayList <Equipment_Gap>();
	private ArrayList <Equipment_Gapsang> gapsangList = new ArrayList <Equipment_Gapsang>();
	private ArrayList <Equipment_Hogu> hoguList = new ArrayList <Equipment_Hogu>();
	private ArrayList <Equipment_Dobok> dobokList = new ArrayList <Equipment_Dobok>();
	private int shinaiNumber = 1;
	private int homenNumber = 1;
	private int howanNumber = 1;
	private int gapNumber = 1;
	private int gapsangNumber = 1;
	private int hoguNumber = 1;
	private int dobokNumber = 1;
	
	
	public ArrayList <Equipment_Shinai> getShinaiList() {
		return shinaiList;
	}
	
	public ArrayList <Equipment_Homen> getHomenList() {
		return homenList;
	}
	
	public ArrayList <Equipment_Howan> getHowanList() {
		return howanList;
	}
	
	public ArrayList <Equipment_Gap> getGapList() {
		return gapList;
	}
	
	public ArrayList <Equipment_Gapsang> getGapsangList() {
		return gapsangList;
	}
	
	public ArrayList <Equipment_Hogu> getHoguList() {
		return hoguList;
	}
	
	public ArrayList <Equipment_Dobok> getDobokList() {
		return dobokList;
	}
	
	public void addShinai(KKC_Member member, String date) {
		Equipment_Shinai newShinai = new Equipment_Shinai(member, shinaiNumber, date);
		shinaiList.add(newShinai);
		shinaiNumber++;
	}
	
	public void addShinai(String date) {
		Equipment_Shinai newShinai = new Equipment_Shinai(shinaiNumber, date);
		shinaiList.add(newShinai);
		shinaiNumber++;
	}
	
	public void addHomen(String date) {
		Equipment_Homen newHomen = new Equipment_Homen(homenNumber, date);
		homenList.add(newHomen);
		homenNumber++;
	}
	
	public void addHowan(String date) {
		Equipment_Howan newHowan = new Equipment_Howan(howanNumber, date);
		howanList.add(newHowan);
		howanNumber++;
	}
	
	public void addGap(String date) {
		Equipment_Gap newGap = new Equipment_Gap(gapNumber, date);
		gapList.add(newGap);
		gapNumber++;
	}
	
	public void addGapsang(String date) {
		Equipment_Gapsang newGapsang = new Equipment_Gapsang(gapsangNumber, date);
		gapsangList.add(newGapsang);
		gapsangNumber++;
	}
	
	public void addHogu(Equipment_Homen homen, 
						Equipment_Howan howan, Equipment_Gap gap, 
						Equipment_Gapsang gapsang, KKC_Member member) {
		Equipment_Hogu newHogu = new Equipment_Hogu(hoguNumber, homen, howan, gap, gapsang, member);
		hoguList.add(newHogu);
		homen.getHistory().setHogu(newHogu);
		howan.getHistory().setHogu(newHogu);
		gap.getHistory().setHogu(newHogu);
		gapsang.getHistory().setHogu(newHogu);
		hoguNumber++;
	}
	
	public void addDobok(String date) {
		Equipment_Dobok newDobok = new Equipment_Dobok(dobokNumber, date);
		dobokList.add(newDobok);
		dobokNumber++;
	}
	
	public int getShinaiNullUserCount() {
		int count = 0;
		for(int i=0; i<shinaiList.size(); i++) {
			if(shinaiList.get(i).getMember() == null)
				count++;
		}
		
		return count;
	}
	
	public void showHogu(int EquipmentNumber) {
		for(int i=0; i<hoguList.size(); i++) {
			if(hoguList.get(i).getNumber() == EquipmentNumber) {
				hoguList.get(i).checkStatus();
				
				System.out.println("장비번호 : " + hoguList.get(i).getNumber() +
								   " | 장비상태 : " + hoguList.get(i).getStatus() +
								   " | 이용자 : " + hoguList.get(i).getMember().getName()+"("+hoguList.get(i).getMember().getStudentID()+")");
				
				System.out.println("세부정보 | 호면 : " + hoguList.get(i).getHomen().getNumber() +"("+ hoguList.get(i).getHomen().getStatus() +")"+
								   "| 호완 : " + hoguList.get(i).getHowan().getNumber() +"("+ hoguList.get(i).getHowan().getStatus() +")"+
								   "| 갑 : " + hoguList.get(i).getGap().getNumber() +"("+ hoguList.get(i).getGap().getStatus() +")"+
								   "| 갑상 : " + hoguList.get(i).getGapsang().getNumber() +"("+ hoguList.get(i).getGapsang().getStatus()+")"); 
				
				System.out.println();
				break;
			}
		}
	}
	
	public void showShinai(int EquipmentNumber) {
		for(int i=0; i<shinaiList.size(); i++) {
			if(shinaiList.get(i).getNumber() == EquipmentNumber) {
				shinaiList.get(i).shinaiStatus();
				System.out.println("장비번호 : " + shinaiList.get(i).getNumber() +
						   "| 등록일자 : " + shinaiList.get(i).getDate() +
						   "| 장비상태 : " + shinaiList.get(i).getStatus() +
						   "| 이용자 : 미등록");

				System.out.println("장비세부상태 | 선혁 : " + shinaiList.get(i).getSakiawa() +
						   " 선고무 : " + shinaiList.get(i).getSakigomu() +
						   " 중혁 : " + shinaiList.get(i).getNakayui() +
						   " 병혁 : " + shinaiList.get(i).getTsukagawa() +
						   " 등줄 : " + shinaiList.get(i).getTsuru() +
						   " 코등이 : " + shinaiList.get(i).getTsuba() +
						   " 코등이 받침 : " + shinaiList.get(i).getTsubaDome());
		
				System.out.println();
					break;
			}
		}
	}
	
	public void showShinaiNullUserList() {
		for(int i=0; i<shinaiList.size(); i++) {
			if(shinaiList.get(i).getMember() == null) {
				shinaiList.get(i).shinaiStatus();
				System.out.println("장비번호 : " + shinaiList.get(i).getNumber() +
								   "| 등록일자 : " + shinaiList.get(i).getDate() +
								   "| 장비상태 : " + shinaiList.get(i).getStatus() +
								   "| 이용자 : 미등록");
			}
		}
	}
	
	public void showShinaiList() {
		for(int i=0; i<shinaiList.size(); i++) {
			shinaiList.get(i).shinaiStatus();
			if(shinaiList.get(i).getMember() == null) {
				System.out.println("장비번호 : " + shinaiList.get(i).getNumber() +
								   "| 등록일자 : " + shinaiList.get(i).getDate() +
								   "| 장비상태 : " + shinaiList.get(i).getStatus() +
								   "| 이용자 : 미등록");
		
				System.out.println("장비세부상태 | 선혁 : " + shinaiList.get(i).getSakiawa() +
								   " 선고무 : " + shinaiList.get(i).getSakigomu() +
								   " 중혁 : " + shinaiList.get(i).getNakayui() +
								   " 병혁 : " + shinaiList.get(i).getTsukagawa() +
								   " 등줄 : " + shinaiList.get(i).getTsuru() +
								   " 코등이 : " + shinaiList.get(i).getTsuba() +
								   " 코등이 받침 : " + shinaiList.get(i).getTsubaDome());
				
				System.out.println();
			}
			
			else {
				System.out.println("장비번호 : " + shinaiList.get(i).getNumber() +
							       "| 등록일자 : " + shinaiList.get(i).getDate() +
							       "| 장비상태 : " + shinaiList.get(i).getStatus() +
							       "| 이용자 : " + shinaiList.get(i).getMember().getName() +"("+ shinaiList.get(i).getMember().getStudentID() +")");
			
				System.out.println("장비세부상태 | 선혁 : " + shinaiList.get(i).getSakiawa() +
								   "| 선고무 : " + shinaiList.get(i).getSakigomu() +
								   "| 중혁 : " + shinaiList.get(i).getNakayui() +
								   "| 병혁 : " + shinaiList.get(i).getTsukagawa() +
								   "| 등줄 : " + shinaiList.get(i).getTsuru() +
								   "| 코등이 : " + shinaiList.get(i).getTsuba() +
								   "| 코등이 받침 : " + shinaiList.get(i).getTsubaDome());
			
				System.out.println();
			}
		}
	}
	
	public void showHoguList() {
		for(int i=0; i<hoguList.size(); i++) {
			hoguList.get(i).checkStatus();
			
			System.out.println("장비번호 : " + hoguList.get(i).getNumber() +
							   " | 장비상태 : " + hoguList.get(i).getStatus() +
							   " | 이용자 : " + hoguList.get(i).getMember().getName()+"("+hoguList.get(i).getMember().getStudentID()+")");
			
			System.out.println("세부정보 | 호면 : " + hoguList.get(i).getHomen().getNumber() +"("+ hoguList.get(i).getHomen().getStatus() +")"+
							   "| 호완 : " + hoguList.get(i).getHowan().getNumber() +"("+ hoguList.get(i).getHowan().getStatus() +")"+
							   "| 갑 : " + hoguList.get(i).getGap().getNumber() +"("+ hoguList.get(i).getGap().getStatus() +")"+
							   "| 갑상 : " + hoguList.get(i).getGapsang().getNumber() +"("+ hoguList.get(i).getGapsang().getStatus()+")"); 
			
			System.out.println();
		}
	}
	
	public void showHomenList() {
		for(int i=0; i<homenList.size(); i++) {
			System.out.println("장비번호 : " + homenList.get(i).getNumber() +
					" | 등록일자 : " + homenList.get(i).getDate() +
					" | 장비상태 : " + homenList.get(i).getStatus());

			
			System.out.println();
		}
	}
	
	public void showHomen(int EquipmentNumber) {
		for(int i=0; i<homenList.size(); i++) {
			if(homenList.get(i).getNumber() == EquipmentNumber) {
				System.out.println("장비번호 : " + homenList.get(i).getNumber() +
								" | 등록일자 : " + homenList.get(i).getDate() +
								" | 장비상태 : " + homenList.get(i).getStatus());
			
				System.out.println();
				break;
			}
		}
	}
	
	public void showHowanList() {
		for(int i=0; i<howanList.size(); i++) {
			System.out.println("장비번호 : " + howanList.get(i).getNumber() +
					" | 등록일자 : " + howanList.get(i).getDate() +
					" | 장비상태 : " + howanList.get(i).getStatus());

			System.out.println();
		}
	}
	
	public void showHowan(int EquipmentNumber) {
		for(int i=0; i<howanList.size(); i++) {
			if(howanList.get(i).getNumber() == EquipmentNumber) {
				System.out.println("장비번호 : " + howanList.get(i).getNumber() +
								" | 등록일자 : " + howanList.get(i).getDate() +
								" | 장비상태 : " + howanList.get(i).getStatus());
			
				System.out.println();
				break;
			}
		}
	}
	
	public void showGapList() {
		for(int i=0; i<gapList.size(); i++) {
			System.out.println("장비번호 : " + gapList.get(i).getNumber() +
					" | 등록일자 : " + gapList.get(i).getDate() +
					" | 장비상태 : " + gapList.get(i).getStatus());

			System.out.println();
		}
	}
	
	public void showGap(int EquipmentNumber) {
		for(int i=0; i<gapList.size(); i++) {
			if(gapList.get(i).getNumber() == EquipmentNumber) {
				System.out.println("장비번호 : " + gapList.get(i).getNumber() +
								" | 등록일자 : " + gapList.get(i).getDate() +
								" | 장비상태 : " + gapList.get(i).getStatus());
			
				System.out.println();
				break;
			}
		}
	}
	
	public void showGapsangList() {
		for(int i=0; i<gapsangList.size(); i++) {
			System.out.println("장비번호 : " + gapsangList.get(i).getNumber() +
					" | 등록일자 : " + gapsangList.get(i).getDate() +
					" | 장비상태 : " + gapsangList.get(i).getStatus());

			System.out.println();
		}
	}
	
	public void showGapsang(int EquipmentNumber) {
		for(int i=0; i<gapsangList.size(); i++) {
			if(gapsangList.get(i).getNumber() == EquipmentNumber) {
				System.out.println("장비번호 : " + gapsangList.get(i).getNumber() +
								" | 등록일자 : " + gapsangList.get(i).getDate() +
								" | 장비상태 : " + gapsangList.get(i).getStatus());
			
				System.out.println();
				break;
			}
		}
	}
	
	public void showDobokList() {
		for(int i=0; i<dobokList.size(); i++) {
			System.out.println("장비번호 : " + dobokList.get(i).getNumber() +
							   " | 등록일자 : " + dobokList.get(i).getDate());
			
			System.out.println();
		}
	}
	
	public void deleteShinai(int delete_EquipmentNumber) {
		for(int i=0; i<shinaiList.size(); i++) {
			if(shinaiList.get(i).getNumber() == delete_EquipmentNumber) {
				shinaiList.remove(i);
				break;
			}
		}
	}
	
	public void deleteHogu(int delete_EquipmentNumber) {
		for(int i=0; i<hoguList.size(); i++) {
			if(hoguList.get(i).getNumber() == delete_EquipmentNumber) {
				hoguList.get(i).getHomen().getHistory().setOffHogu();
				hoguList.get(i).getHowan().getHistory().setOffHogu();
				hoguList.get(i).getGap().getHistory().setOffHogu();
				hoguList.get(i).getGapsang().getHistory().setOffHogu();
				hoguList.remove(i);
				break;
			}
		}
	}
	
	public void deleteHomen(int delete_EquipmentNumber) {
		for(int i=0; i<homenList.size(); i++) {
			if(homenList.get(i).getNumber() == delete_EquipmentNumber) {
				homenList.remove(i);
				break;
			}
		}
	}
	
	public void deleteHowan(int delete_EquipmentNumber) {
		for(int i=0; i<howanList.size(); i++) {
			if(howanList.get(i).getNumber() == delete_EquipmentNumber) {
				howanList.remove(i);
				break;
			}
		}
	}
	
	public void deleteGap(int delete_EquipmentNumber) {
		for(int i=0; i<gapList.size(); i++) {
			if(gapList.get(i).getNumber() == delete_EquipmentNumber) {
				gapList.remove(i);
				break;
			}
		}
	}
	
	public void deleteGapsang(int delete_EquipmentNumber) {
		for(int i=0; i<gapsangList.size(); i++) {
			if(gapsangList.get(i).getNumber() == delete_EquipmentNumber) {
				gapsangList.remove(i);
				break;
			}
		}
	}
	
	public void deleteDobok(int delete_EquipmentNumber) {
		for(int i=0; i<dobokList.size(); i++) {
			if(dobokList.get(i).getNumber() == delete_EquipmentNumber) {
				dobokList.remove(i);
				break;
			}
		}
	}
	
	public void setShinai_Status(int number, String part, String statusType) {
		for(int i=0; i<shinaiList.size(); i++) {
			if(shinaiList.get(i).getNumber() == number) {
				shinaiList.get(i).setStatus(part, statusType);
				shinaiList.get(i).shinaiStatus();
				break;
			}
		}
	}
	
	public void setHomen_Status(int number, String statusType) {
		for(int i=0; i<homenList.size(); i++) {
			if(homenList.get(i).getNumber() == number) {
				homenList.get(i).setStatus(statusType);
				break;
			}
		}
	}
	
	public void setHowan_Status(int number, String statusType) {
		for(int i=0; i<howanList.size(); i++) {
			if(howanList.get(i).getNumber() == number) {
				howanList.get(i).setStatus(statusType);
				break;
			}
		}
	}
	
	public void setGap_Status(int number, String statusType) {
		for(int i=0; i<gapList.size(); i++) {
			if(gapList.get(i).getNumber() == number) {
				gapList.get(i).setStatus(statusType);
				break;
			}
		}
	}
	
	public void setGapsang_Status(int number, String statusType) {
		for(int i=0; i<gapsangList.size(); i++) {
			if(gapsangList.get(i).getNumber() == number) {
				gapsangList.get(i).setStatus(statusType);
				break;
			}
		}
	}
	
	public void setHogu(int setHogu_Number, String setPart, int setEquipment_Number) {
		
		boolean Nooo = false;
		boolean okey = false;
		
		for(int i=0; i<hoguList.size(); i++) {
			if(hoguList.get(i).getNumber() == setHogu_Number) {
				switch (setPart) {
				case "호면" : {
					
					for(int ii=0; ii<hoguList.size(); ii++) {
						if(hoguList.get(ii).getHomen().getNumber() == setEquipment_Number) {
							System.out.println("이미 등록된 장비입니다. 다른 장비를 입력하세요.");
							Nooo = true;
							break;
						}
					}
					
					if(Nooo == true)
						break;
						
						
					if(hoguList.get(i).getHomen() != null) {
						hoguList.get(i).getHomen().getHistory().setOffHogu();
					}
						
					for(int iii=0; iii<homenList.size(); iii++) {
						if(homenList.get(iii).getNumber() == setEquipment_Number) {
							Equipment_Homen setEquipment = homenList.get(iii);
							hoguList.get(i).setHomen(setEquipment);
							setEquipment.getHistory().setHogu(hoguList.get(i));
							System.out.println("구성 변경 완료");
							okey = true;
							break;
						}
					}
					
					
					if(okey == false) 
					System.out.println("변경 실패 | 장비 번호를 확인하세요.");
					
					break;
				}
					
				case "호완" : {
					
					for(int ii=0; ii<hoguList.size(); ii++) {
						if(hoguList.get(ii).getHowan().getNumber() == setEquipment_Number) {
							System.out.println("이미 등록된 장비입니다. 다른 장비를 입력하세요.");
							Nooo = true;
							break;
						}
					}
					
					if(Nooo == true)
						break;
				
						if(hoguList.get(i).getHowan() != null) {
							hoguList.get(i).getHowan().getHistory().setOffHogu();
						}
						
						for(int iii=0; iii<howanList.size(); iii++) {
							if(howanList.get(iii).getNumber() == setEquipment_Number) {
								Equipment_Howan setEquipment = howanList.get(iii);
								hoguList.get(i).setHowan(setEquipment);
								setEquipment.getHistory().setHogu(hoguList.get(i));
								System.out.println("구성 변경 완료");
								okey = true;
								break;
							}
						}
					
					
					if(okey == false) 
					System.out.println("변경 실패 | 장비 번호를 확인하세요.");
					
					break;
				}
					
				case "갑" : {
					
					for(int ii=0; ii<hoguList.size(); ii++) {
						if(hoguList.get(ii).getGap().getNumber() == setEquipment_Number) {
							System.out.println("이미 등록된 장비입니다. 다른 장비를 입력하세요.");
							Nooo = true;
							break;
						}
					}
				
					if(Nooo == true)
						break;
					
						if(hoguList.get(i).getGap() != null) {
							hoguList.get(i).getGap().getHistory().setOffHogu();
						}
						
						for(int iii=0; iii<gapList.size(); iii++) {
							if(gapList.get(iii).getNumber() == setEquipment_Number) {
								Equipment_Gap setEquipment = gapList.get(iii);
								hoguList.get(i).setGap(setEquipment);
								setEquipment.getHistory().setHogu(hoguList.get(i));
								System.out.println("구성 변경 완료");
								okey = true;
								break;
							}
						}
					
					
					if(okey == false) 
					System.out.println("변경 실패 | 장비 번호를 확인하세요.");
					
					break;
				}
					
				case "갑상" : {
					
					for(int ii=0; ii<hoguList.size(); ii++) {
						if(hoguList.get(ii).getGapsang().getNumber() == setEquipment_Number) {
							System.out.println("이미 등록된 장비입니다. 다른 장비를 입력하세요.");
							Nooo = true;
							break;
						}
					}
				
					if(Nooo == true)
						break;
						
						if(hoguList.get(i).getGapsang() != null) {
							hoguList.get(i).getGapsang().getHistory().setOffHogu();
						}
						
						for(int iii=0; iii<gapsangList.size(); iii++) {
							if(gapsangList.get(iii).getNumber() == setEquipment_Number) {
								Equipment_Gapsang setEquipment = gapsangList.get(iii);
								hoguList.get(i).setGapsang(setEquipment);
								setEquipment.getHistory().setHogu(hoguList.get(i));
								System.out.println("구성 변경 완료");
								okey = true;
								break;
							}
						}
					
					
					if(okey == false) 
					System.out.println("변경 실패 | 장비 번호를 확인하세요.");
					
					break;
				}
					
				} break;
			}
		}
	}
	
	public void setEquipment_User(String EquipmentType, int setEquipment_Number, KKC_Member member) {
		
		boolean okey = false;
		
		switch (EquipmentType) {
		case "죽도" :
			for(int i=0; i<shinaiList.size(); i++) {
				if(shinaiList.get(i).getNumber() == setEquipment_Number) {
					shinaiList.get(i).setMember(member);
					okey = true;
					break;
				}
					
			}
			
			if(okey == false) {
			System.out.println("정보를 찾을 수 없습니다.");
			System.out.println();
			}
			
			break;
		
		case "호구" :
			for(int i=0; i<hoguList.size(); i++) {
				if(hoguList.get(i).getNumber() == setEquipment_Number) {
					hoguList.get(i).setMember(member);
					okey = true;
					break;
				}
				
			}
			
			if(okey == false) {
				System.out.println("정보를 찾을 수 없습니다.");
				System.out.println();
				}
		}
	}
	
	public void addShinaiRepairHistory(int shinaiNumber, String date, String detail, String result) {
			for(int i=0; i<shinaiList.size(); i++) {
				if(shinaiList.get(i).getNumber() == shinaiNumber) {
					shinaiList.get(i).getHistory().addHistory(date, detail, result);
					break;
				}
			} 
	}
	
	public void addHoguRepairHistory(int hoguNumber, String part, String date, String details, String result) {
		for(int i=0; i<hoguList.size(); i++) {
			if(hoguList.get(i).getNumber() == hoguNumber) {
				switch (part) {
				case "호면" : {
					hoguList.get(i).getHomen().getHistory().addHistory(date, details, result);
					break;
				}
			
				case "호완" : {
					hoguList.get(i).getHowan().getHistory().addHistory(date, details, result);
					break;
				}

				case "갑" : {
					hoguList.get(i).getGap().getHistory().addHistory(date, details, result);
					break;
				}

				case "갑상" : {
					hoguList.get(i).getGapsang().getHistory().addHistory(date, details, result);
					break;
				}
				
				} break;
			} 
		}
	}
	
	public void addNullHoguRepairHistory(int hoguNumber, String part, String date, String details, String result) {
				switch (part) {
				case "호면" : {
					for(int i=0; i<homenList.size(); i++) {
						if(homenList.get(i).getNumber() == hoguNumber) {
							homenList.get(i).getHistory().addHistory(date, details, result);
							break;
						}
					} break;
				}
			
				case "호완" : {
					for(int i=0; i<howanList.size(); i++) {
						if(howanList.get(i).getNumber() == hoguNumber) {
							howanList.get(i).getHistory().addHistory(date, details, result);
							break;
						}
					} break;
				}

				case "갑" : {
					for(int i=0; i<gapList.size(); i++) {
						if(gapList.get(i).getNumber() == hoguNumber) {
							gapList.get(i).getHistory().addHistory(date, details, result);
							break;
						}
					} break;
				}

				case "갑상" : {
					for(int i=0; i<gapsangList.size(); i++) {
						if(gapsangList.get(i).getNumber() == hoguNumber) {
							gapsangList.get(i).getHistory().addHistory(date, details, result);
							break;
						}
					} break;
				}
				
				} 
			} 
		
	
	
	public void showRepairHistory(String EquipmentType, int equipmentNumber) {
		switch (EquipmentType) {
		case "죽도" :
			for(int i=0; i<shinaiList.size(); i++) {
				if(shinaiList.get(i).getNumber() == equipmentNumber) {
					shinaiList.get(i).getHistory().showHistory();
					break;
				}
			} break; 
			
			
		case "호면" :
			for(int i=0; i<homenList.size(); i++) {
				if(homenList.get(i).getNumber() == equipmentNumber) {
					homenList.get(i).getHistory().showHistory();
					break;
				}
			} break;
			
		case "호완" :
			for(int i=0; i<howanList.size(); i++) {
				if(howanList.get(i).getNumber() == equipmentNumber) {
					howanList.get(i).getHistory().showHistory();
					break;
				}
			} break;
			
		case "갑" :
			for(int i=0; i<gapList.size(); i++) {
				if(gapList.get(i).getNumber() == equipmentNumber) {
					gapList.get(i).getHistory().showHistory();
					break;
				}
			} break;
			
		case "갑상" :
			for(int i=0; i<gapsangList.size(); i++) {
				if(gapsangList.get(i).getNumber() == equipmentNumber) {
					gapsangList.get(i).getHistory().showHistory();
					break;
				}
			} break;
			
		}
	}
	
	public void deleteRepairUser(KKC_Member user) {
			for(int i=0; i<shinaiList.size(); i++) {
				shinaiList.get(i).getHistory().deleteUser(user);
			}
			
			for(int i=0; i<homenList.size(); i++) {
				homenList.get(i).getHistory().deleteUser(user);
			}
			
			for(int i=0; i<howanList.size(); i++) {
				howanList.get(i).getHistory().deleteUser(user);
			}
			
			for(int i=0; i<gapList.size(); i++) {
				gapList.get(i).getHistory().deleteUser(user);
			}
			
			for(int i=0; i<gapsangList.size(); i++) {
				gapsangList.get(i).getHistory().deleteUser(user);
			}
		}
	
	public Equipment_Shinai findShinai(int find_EquipmentNumber) {
		for(int i=0; i<shinaiList.size(); i++) {
			if(shinaiList.get(i).getNumber() == find_EquipmentNumber) {
				return shinaiList.get(i);
			}
		}
		return null;
	}
	
	public Equipment_Hogu findHogu(int find_EquipmentNumber) {
		for(int i=0; i<hoguList.size(); i++) {
			if(hoguList.get(i).getNumber() == find_EquipmentNumber) {
				return hoguList.get(i);
			}
		}
		return null;
	}
	
	
	public Equipment_Homen findHomen(int find_EquipmentNumber) {
		for(int i=0; i<homenList.size(); i++) {
			if(homenList.get(i).getNumber() == find_EquipmentNumber) {
				return homenList.get(i);
			}
		}
		return null;
	}
	
	public Equipment_Howan findHowan(int find_EquipmentNumber) {
		for(int i=0; i<howanList.size(); i++) {
			if(howanList.get(i).getNumber() == find_EquipmentNumber) {
				return howanList.get(i);
			}
		}
		return null;
	}
	
	public Equipment_Gap findGap(int find_EquipmentNumber) {
		for(int i=0; i<gapList.size(); i++) {
			if(gapList.get(i).getNumber() == find_EquipmentNumber) {
				return gapList.get(i);
			}
		}
		return null;
	}
	
	public Equipment_Gapsang findGapsang(int find_EquipmentNumber) {
		for(int i=0; i<gapsangList.size(); i++) {
			if(gapsangList.get(i).getNumber() == find_EquipmentNumber) {
				return gapsangList.get(i);
			}
		}
		return null;
	}
	
}
