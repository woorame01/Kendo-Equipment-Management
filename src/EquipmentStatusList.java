import java.util.ArrayList;
public class EquipmentStatusList {
	
	ArrayList <EquipmentStatus> StatusList  = new ArrayList <EquipmentStatus>();
	
	public int addStatus(String statusType, boolean canUsing) {
		for(int i=0; i<StatusList.size(); i++) {
			if(StatusList.get(i).getStatusType().equals(statusType)) {
				System.out.println("이미 등록된 상태입니다.");
				return 0;
			}
		}
		
		EquipmentStatus newStatus = new EquipmentStatus(statusType, canUsing);
		StatusList.addLast(newStatus);
		System.out.println(StatusList.getLast().getStatusType()+"을(를) "
		+StatusList.getLast().getCanUsing()+"상태로 "+StatusList.size()+"번째 장비 상태로 등록하였습니다.");
		
		return 0;	
	}
	
	public EquipmentStatus findStatusNoComment (String statusType) {
		for(int i=0; i<StatusList.size(); i++) {
			if(StatusList.get(i).getStatusType().equals(statusType)) {
				EquipmentStatus findStatus = StatusList.get(i);

				return findStatus;
			}
		}
		return null;
	}
	
	public void showStatusList() {
		System.out.print("장비 상태 목록 : ");
		for(int i=0; i<StatusList.size(); i++) {
			System.out.print(StatusList.get(i).getStatusType()+" ");
		}
		System.out.println();
	}
	
}
