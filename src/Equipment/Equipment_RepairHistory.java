package Equipment;
import java.util.ArrayList;

/*
 * [GUI 구현 시 추가 예정]
 *
 * 현재는 수리부위와 수리내용을 details 하나의 문자열로 관리한다.
 *
 * GUI 구현 시 수리 내역을 보다 상세하게 관리할 수 있도록
 * 수리 대상 부위를 별도의 항목으로 추가할 예정.
 *
 * 1. 호구 수리
 *    - 호구를 구성하는 4가지 장비 중 어떤 장비를 수리했는지 선택
 *      (호면 / 갑상 / 갑 / 호완)
 *    - 해당 장비의 구체적인 수리 내용을 기록
 *
 * 2. 죽도 수리
 *    - 죽도를 구성하는 부위 중 어떤 부위를 수리했는지 선택
 *      (선혁 / 선고무 / 중혁 / 병혁 / 등줄 / 코등이 / 코등이 받침)
 *    - 해당 부위의 구체적인 수리 내용을 기록
 *
 * 현재는 'details'에 수리 대상과 수리 내용을 함께 기록한다.
 * GUI 구현 단계에서 필요에 따라 수리 대상과 수리 내용을
 * 별도의 항목으로 분리하여 관리할 수 있다.
 */

import KKC.KKC_Member;

public class Equipment_RepairHistory {
	private KKC_Member user;
	private String date;
	private String details;
	private String result;
	private Equipment_Shinai shinai = null;
	private Equipment_Hogu hogu = null;
	
	private ArrayList <Equipment_RepairHistory> history = new ArrayList<>();
	
	public Equipment_Shinai getShinai() {
		return shinai;
	}
	
	public Equipment_Hogu getHogu() {
		return hogu;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getDetails() {
		return details;
	}
	
	public String getResult() {
		return result;
	}
	
	public KKC_Member getUser()	{
		return user;
	}
	
	public void showHistory() {
		if(hogu != null) {
			for(int i=0; i<history.size(); i++) {
				System.out.println("수리일자 : " + history.get(i).date);
				System.out.println("수리부위 : " + history.get(i).hogu.getNumber());
				System.out.println("수리내용 : " + history.get(i).details);
				System.out.println("수리결과 : " + history.get(i).result);
				if(history.get(i).user == null) {
					System.out.println("이용자 : 탈퇴");
				}
				else {
				System.out.println("이용자 : " + history.get(i).user.getName() + " " + history.get(i).user.getStudentID());
				}
				System.out.println("*********************************************");
			}
		}
		
		else if(shinai != null) {
			for(int i=0; i<history.size(); i++) {
				System.out.println("수리일자 : " + history.get(i).date);
				System.out.println("수리부위 : " + history.get(i).shinai.getNumber());
				System.out.println("수리내용 : " + history.get(i).details);
				System.out.println("수리결과 : " + history.get(i).result);
				if(history.get(i).user == null) {
					System.out.println("이용자 : 탈퇴 또는 미등록");
				}
				else {
				System.out.println("이용자 : " + history.get(i).user.getName() + " " + history.get(i).user.getStudentID());
				}
				System.out.println("*********************************************");
			}
		}
		
	}
	
	/*
	public void firstHistory(Equipment_Hogu hogu, Equipment_Shinai shinai,
							 String date, String details, String result) {
		
		if(hogu != null) {
			Equipment_RepairHistory newHistory = new Equipment_RepairHistory(hogu, date, details, result);
			history.add(newHistory);
		}
		
		else if(shinai != null) {
			Equipment_RepairHistory newHistory = new Equipment_RepairHistory(shinai, date, details, result);
			history.add(newHistory);
		}
	}
	*/
	
	public void addHistory(String date, String details, String result) {
		if(hogu != null) {
			Equipment_RepairHistory newHistory = new Equipment_RepairHistory(this.hogu, date, details, result);
			history.add(newHistory);
		}
		
		else if(shinai != null) {
			Equipment_RepairHistory newHistory = new Equipment_RepairHistory(this.shinai, date, details, result);
			history.add(newHistory);
		}
	}
	
	public Equipment_RepairHistory(Equipment_Hogu hogu) {

		this.hogu = hogu;
		this.user = hogu.getMember();
		this.date = "이력 없음";
		this.details = "이력 없음";
		this.result = "이력 없음";

	}
	
	public Equipment_RepairHistory(Equipment_Shinai shinai) {
		
		this.shinai = shinai;
		this.user = shinai.getMember();
		this.date = "이력 없음";
		this.details = "이력 없음";
		this.result = "이력 없음";
		 
	}
	
	public Equipment_RepairHistory(Equipment_Hogu hogu, String date,String details, String result) {

		this.hogu = hogu;
		this.user = hogu.getMember();
		this.date = date;
		this.details = details;
		this.result = result;

	}
	
	public Equipment_RepairHistory(Equipment_Shinai shinai, String date,  String details, String result) {
		
		this.shinai = shinai;
		this.user = shinai.getMember();
		this.date = date;
		this.details = details;
		this.result = result;
		 
	}
	
	public void deleteUser(KKC_Member user) {
		for(int i=0; i<history.size(); i++) {
			if(history.get(i).user == user) {
				history.get(i).user = null;
			}
		}
	}

}
