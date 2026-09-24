package Equipment;
import java.util.ArrayList;
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
				System.out.println("이용자 : " + history.get(i).user.getName() + " " + history.get(i).user.getStudentID());
				System.out.println("*********************************************");
			}
		}
		
		else if(shinai != null) {
			for(int i=0; i<history.size(); i++) {
				System.out.println("수리일자 : " + history.get(i).date);
				System.out.println("수리부위 : " + history.get(i).shinai.getNumber());
				System.out.println("수리내용 : " + history.get(i).details);
				System.out.println("수리결과 : " + history.get(i).result);
				System.out.println("이용자 : " + history.get(i).user.getName() + " " + history.get(i).user.getStudentID());
				System.out.println("*********************************************");
			}
		}
		
	}
	
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
	
	public Equipment_RepairHistory(Equipment_Hogu hogu, String date,
						 String details, String result) {

		this.hogu = hogu;
		this.user = hogu.getMember();
		this.date = date;
		this.details = details;
		this.result = result;

}
	
	public Equipment_RepairHistory(Equipment_Shinai shinai, String date, 
						 String details, String result) {
		
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
