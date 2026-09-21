
public class Equipment_Homen {
	private String number;
	private String date;
	private EquipmentStatus status;
	
	public Equipment_Homen(String number, String date, EquipmentStatus status) {
		this.number = number;
		this.date = date;
		this.status = status;
	}

	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setDate(String Date) {
		this.date = Date;
	}
	
	public void setStatus(EquipmentStatus status) {
		this.status = status;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getDate() {
		return date;
	}
	
	public EquipmentStatus getStatus() {
		return status;
	}
	
}
