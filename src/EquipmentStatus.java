// v1.1 - 장비 상태 관리

public class EquipmentStatus {
	private String statusType;
	private String canUsing;
	
	public EquipmentStatus(String statusType, boolean canUsing) {
		this.statusType = statusType;
		
		if(canUsing == true)
			this.canUsing = "사용가능";
		
		else if(canUsing == false)
			this.canUsing = "사용불가";
		
		
	}
	
	public String getCanUsing() {
		return canUsing;
	}
	
	public String getStatusType() {
		return statusType;
	}
	public void showStatus() {
		System.out.println(statusType);
	}
	
	

}
