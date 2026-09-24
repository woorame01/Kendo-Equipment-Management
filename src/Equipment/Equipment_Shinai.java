package Equipment;
import KKC.KKC_Member;

/* 이거 처리를 검도 하나의 EquipmentStatus를 두고 각각의 부위별로 상태를 입력한 뒤에
하나라도 수리필요가 있으면 수리필요로 바꾸고 어떤 부위에 수리가 필요한지 조회할 수 있게 하는게
날듯, 그리고 하나라도 수리불가능이나 폐기라면 전체적인 EquipmentStatus를 수리불가능, 폐기로 바꾸는 걸로
하는거임.*/

public class Equipment_Shinai extends KKC_Equipment {
	private KKC_Member member;          // 이용자
	private Equipment_Status Sakigawa;   // 선혁
	private Equipment_Status Sakigomu;   // 선고무
	private Equipment_Status Nakayui;    // 중혁
	private Equipment_Status Tsukagawa;  // 병혁
	private Equipment_Status Tsuru;      // 등줄
	private Equipment_Status Tsuba;      // 코등이
	private Equipment_Status TsubaDome;  // 코등이 받침

	public Equipment_Shinai(String number, String date) {
		super(number, date);
		
		this.member = null;
		this.Sakigawa = Equipment_Status.사용가능;
		this.Sakigomu = Equipment_Status.사용가능;
		this.Nakayui = Equipment_Status.사용가능;
		this.Tsukagawa = Equipment_Status.사용가능;
		this.Tsuru = Equipment_Status.사용가능;
		this.Tsuba = Equipment_Status.사용가능;
		this.TsubaDome = Equipment_Status.사용가능;
	}
	
	public Equipment_Shinai(KKC_Member member, String number, String date) {
		super(number, date);
		
		this.member = member;
		this.Sakigawa = Equipment_Status.사용가능;
		this.Sakigomu = Equipment_Status.사용가능;
		this.Nakayui = Equipment_Status.사용가능;
		this.Tsukagawa = Equipment_Status.사용가능;
		this.Tsuru = Equipment_Status.사용가능;
		this.Tsuba = Equipment_Status.사용가능;
		this.TsubaDome = Equipment_Status.사용가능;
	}
	
	public void shinaiStatus() {
		if(Sakigawa == Equipment_Status.폐기 || 
		   Sakigomu == Equipment_Status.폐기 || 
		   Nakayui == Equipment_Status.폐기 ||
		   Tsukagawa == Equipment_Status.폐기 || 
		   Tsuru == Equipment_Status.폐기 || 
		   Tsuba == Equipment_Status.폐기 ||
		   TsubaDome == Equipment_Status.폐기) {
			this.setStatus("폐기");
			
		}
		
		else if(Sakigawa == Equipment_Status.수리불가능 || 
				Sakigomu == Equipment_Status.수리불가능 || 
				Nakayui == Equipment_Status.수리불가능 ||
				Tsukagawa == Equipment_Status.수리불가능 || 
				Tsuru == Equipment_Status.수리불가능 || 
				Tsuba == Equipment_Status.수리불가능 ||
				TsubaDome == Equipment_Status.수리불가능) {
				 this.setStatus("수리불가능");
				 
		}
		
		else if(Sakigawa == Equipment_Status.수리필요 || 
				Sakigomu == Equipment_Status.수리필요 || 
				Nakayui == Equipment_Status.수리필요 ||
				Tsukagawa == Equipment_Status.수리필요 || 
				Tsuru == Equipment_Status.수리필요 || 
				Tsuba == Equipment_Status.수리필요 ||
				TsubaDome == Equipment_Status.수리필요) {
				 this.setStatus("수리필요");
				 
		}
		
		else {
			this.setStatus("사용가능");
			
		}
				
	}
	
	public KKC_Member getMember() {
		return member;
	}
	
	public Equipment_Status getSakiawa() {
		return Sakigawa;
	}
	
	public Equipment_Status getSakigomu() {
		return Sakigomu;
	}
	
	public Equipment_Status getNakayui() {
		return Nakayui;
	}
	
	public Equipment_Status getTsukagawa() {
		return Tsukagawa;
	}
	
	public Equipment_Status getTsuru() {
		return Tsuru;
	}
	
	public Equipment_Status getTsuba() {
		return Tsuba;
	}
	
	public Equipment_Status getTsubaDome() {
		return TsubaDome;
	}
	
	public void setMember(KKC_Member member) {
		this.member = member;
	}
	
	public void setStatus(String part, String statusType) {
		switch (part) {
		case "선혁" :
			switch (statusType) {
			case "사용가능" :
				this.Sakigawa = Equipment_Status.사용가능;
				break;
				
			case "수리필요" :
				this.Sakigawa = Equipment_Status.수리필요;
				break;
				
			case "수리불가능" :
				this.Sakigawa = Equipment_Status.수리불가능;
				break;
				
			case "폐기" :
				this.Sakigawa = Equipment_Status.폐기;
				break;
		}
			break;
		
		case "선고무" :
			switch (statusType) {
			case "사용가능" :
				this.Sakigomu = Equipment_Status.사용가능;
				break;
				
			case "수리필요" :
				this.Sakigomu = Equipment_Status.수리필요;
				break;
				
			case "수리불가능" :
				this.Sakigomu = Equipment_Status.수리불가능;
				break;
				
			case "폐기" :
				this.Sakigomu = Equipment_Status.폐기;
				break;
		}
			break;
			
		case "중혁" :
			switch (statusType) {
			case "사용가능" :
				this.Nakayui = Equipment_Status.사용가능;
				break;
				
			case "수리필요" :
				this.Nakayui = Equipment_Status.수리필요;
				break;
				
			case "수리불가능" :
				this.Nakayui = Equipment_Status.수리불가능;
				break;
				
			case "폐기" :
				this.Nakayui = Equipment_Status.폐기;
				break;
		}
			break;
			
		case "병혁" :
			switch (statusType) {
			case "사용가능" :
				this.Tsukagawa = Equipment_Status.사용가능;
				break;
				
			case "수리필요" :
				this.Tsukagawa = Equipment_Status.수리필요;
				break;
				
			case "수리불가능" :
				this.Tsukagawa = Equipment_Status.수리불가능;
				break;
				
			case "폐기" :
				this.Tsukagawa = Equipment_Status.폐기;
				break;
		}
			break;
			
		case "등줄" :
			switch (statusType) {
			case "사용가능" :
				this.Tsuru = Equipment_Status.사용가능;
				break;
				
			case "수리필요" :
				this.Tsuru = Equipment_Status.수리필요;
				break;
				
			case "수리불가능" :
				this.Tsuru = Equipment_Status.수리불가능;
				break;
				
			case "폐기" :
				this.Tsuru = Equipment_Status.폐기;
				break;
		}
			break;
			
		case "코등이" :
			switch (statusType) {
			case "사용가능" :
				this.Tsuba = Equipment_Status.사용가능;
				break;
				
			case "수리필요" :
				this.Tsuba = Equipment_Status.수리필요;
				break;
				
			case "수리불가능" :
				this.Tsuba = Equipment_Status.수리불가능;
				break;
				
			case "폐기" :
				this.Tsuba = Equipment_Status.폐기;
				break;
		}
			break;
			
		case "코등이 받침" :
			switch (statusType) {
			case "사용가능" :
				this.TsubaDome = Equipment_Status.사용가능;
				break;
				
			case "수리필요" :
				this.TsubaDome = Equipment_Status.수리필요;
				break;
				
			case "수리불가능" :
				this.TsubaDome = Equipment_Status.수리불가능;
				break;
				
			case "폐기" :
				this.TsubaDome = Equipment_Status.폐기;
				break;
		}
			break;
		}
	}
		
}
