package Equipment;
import KKC.KKC_Member;

public class Equipment_Hogu {
	private String number;
	private EquipmentStatus status;
	private Equipment_Homen homen;
	private Equipment_Howan howan;
	private Equipment_Gap gap;
	private Equipment_Gapsang gapsang;
	private KKC_Member member;
	
	public Equipment_Hogu(String number, Equipment_Homen homen, 
						  Equipment_Howan howan, Equipment_Gap gap, 
						  Equipment_Gapsang gapsang, KKC_Member member) {
		
		this.number = number;
		this.homen = homen;
		this.howan = howan;
		this.gap = gap;
		this.gapsang = gapsang;
		this.member = member;
		this.status = EquipmentStatus.사용가능;
	}
	
	public void setMember(KKC_Member member) {
		if(this.member == member) {
			System.out.println("동일한 사용자를 입력했습니다.");
		}
		else
			this.member = member;
	}
	
	public void setHowan(Equipment_Howan howan) {
		if(this.howan == howan) {
			System.out.println("같은 장비를 입력했습니다.");
		}
		else
			this.howan = howan;
	}
	
	public void setHomen(Equipment_Homen homen) {
		if(this.homen == homen) {
			System.out.println("같은 장비를 입력했습니다.");
		}
		else
			this.homen = homen;
	}
	
	public void setGap(Equipment_Gap gap) {
		if(this.gap == gap) {
			System.out.println("같은 장비를 입력했습니다.");
		}
		else
			this.gap = gap;
	}
	
	public void setGapsang(Equipment_Gapsang gapsang) {
		if(this.gapsang == gapsang) {
			System.out.println("같은 장비를 입력했습니다.");
		}
		else
			this.gapsang = gapsang;
	}
	
	public String getNumber() {
		return number;
	}
	
	public EquipmentStatus getStatus() {
		return status;
	}
	
	public KKC_Member getMember() {
		return member;
	}
	
	public Equipment_Homen getHomen() {
		return homen;
	}
	
	public Equipment_Howan getHowan() {
		return howan;
	}
	
	public Equipment_Gap getGap() {
		return gap;
	}
	public Equipment_Gapsang getGapsang() {
		return gapsang;
	}
	
	public void checkStatus() {
		if(homen.getStatus() == EquipmentStatus.폐기 ||
		   howan.getStatus() == EquipmentStatus.폐기 ||
		   gap.getStatus() == EquipmentStatus.폐기 ||
		   gapsang.getStatus() == EquipmentStatus.폐기) {
			this.status = EquipmentStatus.폐기;
		}
		
		else if(homen.getStatus() == EquipmentStatus.수리불가능 ||
				howan.getStatus() == EquipmentStatus.수리불가능 ||
				gap.getStatus() == EquipmentStatus.수리불가능 ||
				gapsang.getStatus() == EquipmentStatus.수리불가능) {
				 this.status = EquipmentStatus.수리불가능;
			}
		
		else if(homen.getStatus() == EquipmentStatus.수리필요 ||
				howan.getStatus() == EquipmentStatus.수리필요 ||
				gap.getStatus() == EquipmentStatus.수리필요 ||
				gapsang.getStatus() == EquipmentStatus.수리필요) {
				 this.status = EquipmentStatus.수리필요;
			}
		
		else {
			this.status = EquipmentStatus.사용가능;
		}
	}
	
	

}
