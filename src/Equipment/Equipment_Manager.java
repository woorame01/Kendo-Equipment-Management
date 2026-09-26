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
	
	public void addShinai(KKC_Member member, String number, String date) {
		Equipment_Shinai newShinai = new Equipment_Shinai(member, number, date);
		shinaiList.add(newShinai);	
	}
	
	public void addShinai(String number, String date) {
		Equipment_Shinai newShinai = new Equipment_Shinai(number, date);
		shinaiList.add(newShinai);	
	}
	
	public void addHomen(String number, String date) {
		Equipment_Homen newHomen = new Equipment_Homen(number, date);
		homenList.add(newHomen);
	}
	
	public void addHowan(String number, String date) {
		Equipment_Howan newHowan = new Equipment_Howan(number, date);
		howanList.add(newHowan);
	}
	
	public void addGap(String number, String date) {
		Equipment_Gap newGap = new Equipment_Gap(number, date);
		gapList.add(newGap);
	}
	
	public void addGapsang(String number, String date) {
		Equipment_Gapsang newGapsang = new Equipment_Gapsang(number, date);
		gapsangList.add(newGapsang);
	}
	
	public void addHogu(String number, Equipment_Homen homen, 
						Equipment_Howan howan, Equipment_Gap gap, 
						Equipment_Gapsang gapsang, KKC_Member member) {
		Equipment_Hogu newHogu = new Equipment_Hogu(number, homen, howan, gap, gapsang, member);
		hoguList.add(newHogu);
	}
	
	public void addDobok(String number, String date) {
		Equipment_Dobok newDobok = new Equipment_Dobok(number, date);
		dobokList.add(newDobok);
	}
	
	public void showShinaiList() {
		for(int i=0; i<shinaiList.size(); i++) {
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
							   " | 등록일자 : " + homenList.get(i).getDate());
			
			System.out.println();
		}
	}
	
	public void showHowanList() {
		for(int i=0; i<howanList.size(); i++) {
			System.out.println("장비번호 : " + howanList.get(i).getNumber() +
							   " | 등록일자 : " + howanList.get(i).getDate());
			
			System.out.println();
		}
	}
	
	public void showGapList() {
		for(int i=0; i<gapList.size(); i++) {
			System.out.println("장비번호 : " + gapList.get(i).getNumber() +
							   " | 등록일자 : " + gapList.get(i).getDate());
			
			System.out.println();
		}
	}
	public void showGapsangList() {
		for(int i=0; i<gapsangList.size(); i++) {
			System.out.println("장비번호 : " + gapsangList.get(i).getNumber() +
							   " | 등록일자 : " + gapsangList.get(i).getDate());
			
			System.out.println();
		}
	}
	
	public void showDobokList() {
		for(int i=0; i<dobokList.size(); i++) {
			System.out.println("장비번호 : " + dobokList.get(i).getNumber() +
							   " | 등록일자 : " + dobokList.get(i).getDate());
			
			System.out.println();
		}
	}
	
	public void deleteShinai(String delete_EquipmentNumber) {
		for(int i=0; i<shinaiList.size(); i++) {
			if(shinaiList.get(i).getNumber().equals(delete_EquipmentNumber)) {
				shinaiList.remove(i);
				break;
			}
		}
	}
	
	public void deleteHogu(String delete_EquipmentNumber) {
		for(int i=0; i<hoguList.size(); i++) {
			if(hoguList.get(i).getNumber().equals(delete_EquipmentNumber)) {
				hoguList.remove(i);
				break;
			}
		}
	}
	
	public void deleteHomen(String delete_EquipmentNumber) {
		for(int i=0; i<homenList.size(); i++) {
			if(homenList.get(i).getNumber().equals(delete_EquipmentNumber)) {
				homenList.remove(i);
				break;
			}
		}
	}
	
	public void deleteHowan(String delete_EquipmentNumber) {
		for(int i=0; i<howanList.size(); i++) {
			if(howanList.get(i).getNumber().equals(delete_EquipmentNumber)) {
				howanList.remove(i);
				break;
			}
		}
	}
	
	public void deleteGap(String delete_EquipmentNumber) {
		for(int i=0; i<gapList.size(); i++) {
			if(gapList.get(i).getNumber().equals(delete_EquipmentNumber)) {
				gapList.remove(i);
				break;
			}
		}
	}
	
	public void deleteGapsang(String delete_EquipmentNumber) {
		for(int i=0; i<gapsangList.size(); i++) {
			if(gapsangList.get(i).getNumber().equals(delete_EquipmentNumber)) {
				gapsangList.remove(i);
				break;
			}
		}
	}
	
	public void deleteDobok(String delete_EquipmentNumber) {
		for(int i=0; i<dobokList.size(); i++) {
			if(dobokList.get(i).getNumber().equals(delete_EquipmentNumber)) {
				dobokList.remove(i);
				break;
			}
		}
	}
	
	public void setShinai_Status(String number, String part, String statusType) {
		for(int i=0; i<shinaiList.size(); i++) {
			if(shinaiList.get(i).getNumber().equals(number)) {
				shinaiList.get(i).setStatus(part, statusType);
				shinaiList.get(i).shinaiStatus();
				break;
			}
		}
	}
	
	public void setHomen_Status(String number, String statusType) {
		for(int i=0; i<homenList.size(); i++) {
			if(homenList.get(i).getNumber().equals(number)) {
				homenList.get(i).setStatus(statusType);
				break;
			}
		}
	}
	
	public void setHowan_Status(String number, String statusType) {
		for(int i=0; i<howanList.size(); i++) {
			if(howanList.get(i).getNumber().equals(number)) {
				howanList.get(i).setStatus(statusType);
				break;
			}
		}
	}
	
	public void setGap_Status(String number, String statusType) {
		for(int i=0; i<gapList.size(); i++) {
			if(gapList.get(i).getNumber().equals(number)) {
				gapList.get(i).setStatus(statusType);
				break;
			}
		}
	}
	
	public void setGapsang_Status(String number, String statusType) {
		for(int i=0; i<gapsangList.size(); i++) {
			if(gapsangList.get(i).getNumber().equals(number)) {
				gapsangList.get(i).setStatus(statusType);
				break;
			}
		}
	}
	
	public void setHogu(String setHogu_Number, String setPart, String setEquipment_Number) {
		for(int i=0; i<hoguList.size(); i++) {
			if(hoguList.get(i).getNumber().equals(setHogu_Number)) {
				switch (setPart) {
				case "호면" :
					for(int ii=0; ii<homenList.size(); ii++) {
						if(homenList.get(ii).getNumber().equals(setEquipment_Number)) {
							Equipment_Homen setEquipment = homenList.get(ii);
							hoguList.get(i).setHomen(setEquipment);
							break;
						}
					} break;
					
				case "호완" :
					for(int ii=0; ii<howanList.size(); ii++) {
						if(howanList.get(ii).getNumber().equals(setEquipment_Number)) {
							Equipment_Howan setEquipment = howanList.get(ii);
							hoguList.get(i).setHowan(setEquipment);
							break;
						}
					} break;
					
				case "갑" :
					for(int ii=0; ii<gapList.size(); ii++) {
						if(gapList.get(ii).getNumber().equals(setEquipment_Number)) {
							Equipment_Gap setEquipment = gapList.get(ii);
							hoguList.get(i).setGap(setEquipment);
							break;
						}
					} break;
					
				case "갑상" :
					for(int ii=0; ii<gapsangList.size(); ii++) {
						if(gapsangList.get(ii).getNumber().equals(setEquipment_Number)) {
							Equipment_Gapsang setEquipment = gapsangList.get(ii);
							hoguList.get(i).setGapsang(setEquipment);
							break;
						}
					} break;
					
				default:
					System.out.println("잘못된 입력입니다.");
					
				} break;
			}
		}
	}
	
	public void setEquipment_User(String EquipmentType, String EquipmentNumber, KKC_Member member) {
		switch (EquipmentType) {
		case "죽도" :
			for(int i=0; i<shinaiList.size(); i++) {
				if(shinaiList.get(i).getNumber().equals(EquipmentNumber)) {
					shinaiList.get(i).setMember(member);
					break;
				}
				
				else {
					System.out.println("정보를 찾을 수 없습니다.");
					System.out.println();
				}
					
			} break;
		
		case "호구" :
			for(int i=0; i<hoguList.size(); i++) {
				if(hoguList.get(i).getNumber().equals(EquipmentNumber)) {
					hoguList.get(i).setMember(member);
					break;
				}
				
				else {
					System.out.println("정보를 찾을 수 없습니다.");
					System.out.println();
				}
			}
		}
	}
	
	public void addRepairHistory(String EquipmentType, String Number, String date, String detail, String result) {
		switch (EquipmentType) {
		case "죽도" :
			for(int i=0; i<shinaiList.size(); i++) {
				if(shinaiList.get(i).getNumber().equals(Number)) {
					shinaiList.get(i).getHistory().addHistory(date, detail, result);
					break;
				}
			} break; 
			
			
		case "호구" :
			for(int i=0; i<hoguList.size(); i++) {
				if(hoguList.get(i).getNumber().equals(Number)) {
					hoguList.get(i).getHistory().addHistory(date, detail, result);
					break;
				}
			} break;
		}
	}
	
	public void showRepairHistory(String EquipmentType, String Number) {
		switch (EquipmentType) {
		case "죽도" :
			for(int i=0; i<shinaiList.size(); i++) {
				if(shinaiList.get(i).getNumber().equals(Number)) {
					shinaiList.get(i).getHistory().showHistory();
					break;
				}
			} break; 
			
			
		case "호구" :
			for(int i=0; i<hoguList.size(); i++) {
				if(hoguList.get(i).getNumber().equals(Number)) {
					hoguList.get(i).getHistory().showHistory();
					break;
				}
			} break;
		}
	}
	
	public void deleteRepairUser(String EquipmentType, KKC_Member user) {
		switch (EquipmentType) {
		case "죽도" :
			for(int i=0; i<shinaiList.size(); i++) {
				shinaiList.get(i).getHistory().deleteUser(user);
			} break; 
			
			
		case "호구" :
			for(int i=0; i<hoguList.size(); i++) {
				hoguList.get(i).getHistory().deleteUser(user);
			} break;
		}
	}
	
	public Equipment_Homen findHomen(String find_EquipmentNumber) {
		for(int i=0; i<homenList.size(); i++) {
			if(homenList.get(i).getNumber().equals(find_EquipmentNumber)) {
				return homenList.get(i);
			}
		}
		return null;
	}
	
	public Equipment_Howan findHowan(String find_EquipmentNumber) {
		for(int i=0; i<howanList.size(); i++) {
			if(howanList.get(i).getNumber().equals(find_EquipmentNumber)) {
				return howanList.get(i);
			}
		}
		return null;
	}
	
	public Equipment_Gap findGap(String find_EquipmentNumber) {
		for(int i=0; i<gapList.size(); i++) {
			if(gapList.get(i).getNumber().equals(find_EquipmentNumber)) {
				return gapList.get(i);
			}
		}
		return null;
	}
	
	public Equipment_Gapsang findGapsang(String find_EquipmentNumber) {
		for(int i=0; i<gapsangList.size(); i++) {
			if(gapsangList.get(i).getNumber().equals(find_EquipmentNumber)) {
				return gapsangList.get(i);
			}
		}
		return null;
	}
	
}
