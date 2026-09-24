package Equipment;

public class KKC_Equipment {
	
	private String number, date;
	private Equipment_Status status;
	
	public KKC_Equipment(String number, String date) {
		this.number = number;
		this.date = date;
		this.status = Equipment_Status.사용가능;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setDate(String Date) {
		this.date = Date;
	}
	
	public void setStatus(String statusType) {
		switch (statusType) {
			case "사용가능" :
				this.status = Equipment_Status.사용가능;
				break;
				
			case "수리필요" :
				this.status = Equipment_Status.수리필요;
				break;
				
			case "수리불가능" :
				this.status = Equipment_Status.수리불가능;
				break;
				
			case "폐기" :
				this.status = Equipment_Status.폐기;
				break;
		}
		
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getDate() {
		return date;
	}
	
	public Equipment_Status getStatus() {
		return status;
	}

}
