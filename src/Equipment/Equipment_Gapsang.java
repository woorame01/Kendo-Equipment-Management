package Equipment;

public class Equipment_Gapsang extends KKC_Equipment {
	private Equipment_RepairHistory history = new Equipment_RepairHistory(this);;
	
	public Equipment_Gapsang(int number, String date) {
		super(number, date);
	}
	
	public void Equipment_RepairHistory_SetHogu(Equipment_Hogu hogu) {
		history.setHogu(hogu);
	}

	public Equipment_RepairHistory getHistory() {
		return this.history;
	}
	
}