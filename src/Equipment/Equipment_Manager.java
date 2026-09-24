package Equipment;
import KKC.KKC_Member;
import java.util.ArrayList;

/* 기능 목록
 * 장비 등록 v
 * 장비 조회 v
 * 장비 삭제
 * 장비 상태 변경
 * 호구 구성
 * 죽도 이용자 등록
 * 수리 내역 등록/조회
 * */

public class Equipment_Manager {
	private ArrayList <Equipment_Shinai> shinaiList = new ArrayList <Equipment_Shinai>();
	private ArrayList <Equipment_Homen> homenList = new ArrayList <Equipment_Homen>();
	private ArrayList <Equipment_Howan> howanList = new ArrayList <Equipment_Howan>();
	private ArrayList <Equipment_Gap> gapList = new ArrayList <Equipment_Gap>();
	private ArrayList <Equipment_Gapsang> gapsangList = new ArrayList <Equipment_Gapsang>();
	private ArrayList <Equipment_Hogu> hoguList = new ArrayList <Equipment_Hogu>();
	private ArrayList <Equipment_Dobok> dobokList = new ArrayList <Equipment_Dobok>();
	
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
			System.out.println("장비번호 : " + hoguList.get(i).getNumber() +
							   " | 장비상태 : " + hoguList.get(i).getStatus() +
							   " | 이용자 : " + hoguList.get(i).getMember().getName()+"("+hoguList.get(i).getMember().getStudentID()+")");
			
			System.out.println("세부정보 | 호면 : " + hoguList.get(i).getHomen() +
							   "| 호완 : " + hoguList.get(i).getHowan() +
							   "| 갑 : " + hoguList.get(i).getGap() +
							   "| 갑상 : " + hoguList.get(i).getGapsang());
			
			System.out.println();
		}
	}
	
	public void ShowHomenList() {
		for(int i=0; i<homenList.size(); i++) {
			System.out.println("장비번호 : " + homenList.get(i).getNumber() +
							   " | 등록일자 : " + homenList.get(i).getDate());
			
			System.out.println();
		}
	}
	
	public void ShowHowanList() {
		for(int i=0; i<howanList.size(); i++) {
			System.out.println("장비번호 : " + howanList.get(i).getNumber() +
							   " | 등록일자 : " + howanList.get(i).getDate());
			
			System.out.println();
		}
	}
	
	public void ShowGapList() {
		for(int i=0; i<gapList.size(); i++) {
			System.out.println("장비번호 : " + gapList.get(i).getNumber() +
							   " | 등록일자 : " + gapList.get(i).getDate());
			
			System.out.println();
		}
	}
	
	public void ShowGapsangList() {
		for(int i=0; i<gapsangList.size(); i++) {
			System.out.println("장비번호 : " + gapsangList.get(i).getNumber() +
							   " | 등록일자 : " + gapsangList.get(i).getDate());
			
			System.out.println();
		}
	}
	
	public void ShowDobokList() {
		for(int i=0; i<dobokList.size(); i++) {
			System.out.println("장비번호 : " + dobokList.get(i).getNumber() +
							   " | 등록일자 : " + dobokList.get(i).getDate());
			
			System.out.println();
		}
	}
	

}
