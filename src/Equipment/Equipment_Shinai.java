package Equipment;
import KKC.KKC_Member;

/* 이거 처리를 검도 하나의 EquipmentStatus를 두고 각각의 부위별로 상태를 입력한 뒤에
하나라도 수리필요가 있으면 수리필요로 바꾸고 어떤 부위에 수리가 필요한지 조회할 수 있게 하는게
날듯, 그리고 하나라도 수리불가능이나 폐기라면 전체적인 EquipmentStatus를 수리불가능, 폐기로 바꾸는 걸로
하는거임.*/

public class Equipment_Shinai extends KKC_Equipment {
	private KKC_Member member;          // 이용자
	private EquipmentStatus Sakigawa;   // 선혁
	private EquipmentStatus Sakigomu;   // 선고무
	private EquipmentStatus Nakayui;    // 중혁
	private EquipmentStatus Tsukagawa;  // 병혁
	private EquipmentStatus Tsuru;      // 등줄
	private EquipmentStatus Tsuba;      // 코등이
	private EquipmentStatus TsubaDome;  // 코등이 받침

	public Equipment_Shinai(String number, String date) {
		super(number, date);
		
		this.member = null;
		this.Sakigawa = EquipmentStatus.사용가능;
		this.Sakigomu = EquipmentStatus.사용가능;
		this.Nakayui = EquipmentStatus.사용가능;
		this.Tsukagawa = EquipmentStatus.사용가능;
		this.Tsuru = EquipmentStatus.사용가능;
		this.Tsuba = EquipmentStatus.사용가능;
		this.TsubaDome = EquipmentStatus.사용가능;
	}
	
	public Equipment_Shinai(KKC_Member member, String number, String date) {
		super(number, date);
		
		this.member = member;
		this.Sakigawa = EquipmentStatus.사용가능;
		this.Sakigomu = EquipmentStatus.사용가능;
		this.Nakayui = EquipmentStatus.사용가능;
		this.Tsukagawa = EquipmentStatus.사용가능;
		this.Tsuru = EquipmentStatus.사용가능;
		this.Tsuba = EquipmentStatus.사용가능;
		this.TsubaDome = EquipmentStatus.사용가능;
	}
	
	public void shinaiStatus() {
		if(Sakigawa == EquipmentStatus.폐기 || 
		   Sakigomu == EquipmentStatus.폐기 || 
		   Nakayui == EquipmentStatus.폐기 ||
		   Tsukagawa == EquipmentStatus.폐기 || 
		   Tsuru == EquipmentStatus.폐기 || 
		   Tsuba == EquipmentStatus.폐기 ||
		   TsubaDome == EquipmentStatus.폐기) {
			this.setStatus("폐기");
			
		}
		
		else if(Sakigawa == EquipmentStatus.수리불가능 || 
				Sakigomu == EquipmentStatus.수리불가능 || 
				Nakayui == EquipmentStatus.수리불가능 ||
				Tsukagawa == EquipmentStatus.수리불가능 || 
				Tsuru == EquipmentStatus.수리불가능 || 
				Tsuba == EquipmentStatus.수리불가능 ||
				TsubaDome == EquipmentStatus.수리불가능) {
				 this.setStatus("수리불가능");
				 
		}
		
		else if(Sakigawa == EquipmentStatus.수리필요 || 
				Sakigomu == EquipmentStatus.수리필요 || 
				Nakayui == EquipmentStatus.수리필요 ||
				Tsukagawa == EquipmentStatus.수리필요 || 
				Tsuru == EquipmentStatus.수리필요 || 
				Tsuba == EquipmentStatus.수리필요 ||
				TsubaDome == EquipmentStatus.수리필요) {
				 this.setStatus("수리필요");
				 
		}
		
		else {
			this.setStatus("사용가능");
			
		}
				
	}
	
	public KKC_Member getMember() {
		return member;
	}
	
	public EquipmentStatus getSakiawa() {
		return Sakigawa;
	}
	
	public EquipmentStatus getSakigomu() {
		return Sakigomu;
	}
	
	public EquipmentStatus getNakayui() {
		return Nakayui;
	}
	
	public EquipmentStatus getTsukagawa() {
		return Tsukagawa;
	}
	
	public EquipmentStatus getTsuru() {
		return Tsuru;
	}
	
	public EquipmentStatus getTsuba() {
		return Tsuba;
	}
	
	public EquipmentStatus getTsubaDome() {
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
				this.Sakigawa = EquipmentStatus.사용가능;
				break;
				
			case "수리필요" :
				this.Sakigawa = EquipmentStatus.수리필요;
				break;
				
			case "수리불가능" :
				this.Sakigawa = EquipmentStatus.수리불가능;
				break;
				
			case "폐기" :
				this.Sakigawa = EquipmentStatus.폐기;
				break;
		}
			break;
		
		case "선고무" :
			switch (statusType) {
			case "사용가능" :
				this.Sakigomu = EquipmentStatus.사용가능;
				break;
				
			case "수리필요" :
				this.Sakigomu = EquipmentStatus.수리필요;
				break;
				
			case "수리불가능" :
				this.Sakigomu = EquipmentStatus.수리불가능;
				break;
				
			case "폐기" :
				this.Sakigomu = EquipmentStatus.폐기;
				break;
		}
			break;
			
		case "중혁" :
			switch (statusType) {
			case "사용가능" :
				this.Nakayui = EquipmentStatus.사용가능;
				break;
				
			case "수리필요" :
				this.Nakayui = EquipmentStatus.수리필요;
				break;
				
			case "수리불가능" :
				this.Nakayui = EquipmentStatus.수리불가능;
				break;
				
			case "폐기" :
				this.Nakayui = EquipmentStatus.폐기;
				break;
		}
			break;
			
		case "병혁" :
			switch (statusType) {
			case "사용가능" :
				this.Tsukagawa = EquipmentStatus.사용가능;
				break;
				
			case "수리필요" :
				this.Tsukagawa = EquipmentStatus.수리필요;
				break;
				
			case "수리불가능" :
				this.Tsukagawa = EquipmentStatus.수리불가능;
				break;
				
			case "폐기" :
				this.Tsukagawa = EquipmentStatus.폐기;
				break;
		}
			break;
			
		case "등줄" :
			switch (statusType) {
			case "사용가능" :
				this.Tsuru = EquipmentStatus.사용가능;
				break;
				
			case "수리필요" :
				this.Tsuru = EquipmentStatus.수리필요;
				break;
				
			case "수리불가능" :
				this.Tsuru = EquipmentStatus.수리불가능;
				break;
				
			case "폐기" :
				this.Tsuru = EquipmentStatus.폐기;
				break;
		}
			break;
			
		case "코등이" :
			switch (statusType) {
			case "사용가능" :
				this.Tsuba = EquipmentStatus.사용가능;
				break;
				
			case "수리필요" :
				this.Tsuba = EquipmentStatus.수리필요;
				break;
				
			case "수리불가능" :
				this.Tsuba = EquipmentStatus.수리불가능;
				break;
				
			case "폐기" :
				this.Tsuba = EquipmentStatus.폐기;
				break;
		}
			break;
			
		case "코등이 받침" :
			switch (statusType) {
			case "사용가능" :
				this.TsubaDome = EquipmentStatus.사용가능;
				break;
				
			case "수리필요" :
				this.TsubaDome = EquipmentStatus.수리필요;
				break;
				
			case "수리불가능" :
				this.TsubaDome = EquipmentStatus.수리불가능;
				break;
				
			case "폐기" :
				this.TsubaDome = EquipmentStatus.폐기;
				break;
		}
			break;
		}
	}
		
}
