// v1.0 - 기본 장비 관리 기능 완성

public class KKC_Equipment {
	private String number, type, gender, date;
	private KKC_Member user;
	private EquipmentStatus status; 
	
	public KKC_Equipment(String number, String type, String gender, String date, KKC_Member user, EquipmentStatus status) {
		this.number = number;
		this.type = type;
		this.gender = gender;
		this.date = date;
		this.user = user;
		this.status = status;
	}
	
	public EquipmentStatus getStatus() {
		return status;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getType() {
		return type;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getDate() {
		return date;
	}
	
	public KKC_Member getUser() {
		return user;
	}
	
	public void setUser(KKC_Member user) {
		this.user = user;
	}
	
	public void setStatus(EquipmentStatus status) {
		this.status = status;
	}
	
	public void showEquipment() {
		if(user != null) {
			System.out.println("장비번호: "+number+" | 장비종류: "+type+" | 성별: "+gender+" | 등록일: "+date+" | 사용자: "+user.getName());
			System.out.println(status.getCanUsing()+" ( "+status.getStatusType()+" )");
		}
		
		else {
			System.out.println("장비번호: "+number+" | 장비종류: "+type+" | 성별: "+gender+" | 등록일: "+date+" | 사용자: 미등록");
			System.out.println(status.getCanUsing()+" ( "+status.getStatusType()+" )");
		}
	}

}
