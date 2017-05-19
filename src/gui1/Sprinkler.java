package gui1;

public class Sprinkler {
	
	int sprinklerId;
	int groupId;

	int[] start_time_hours = new int[7];
	int[] start_time_min = new int[7];
	
	int[] stop_time_hours = new int[7];
	int[] stop_time_min = new int[7];
	
	int[] duration =  new int[7];
	
	boolean statusOn =false;
	
	
	//Custom Constructor
	Sprinkler(int groupId, int sprinklerId)
	{
		this.groupId = groupId;
		this.sprinklerId = Integer.parseInt(Integer.toString(groupId)+Integer.toString(sprinklerId));
	
	}
	
	public Sprinkler()
	{
		
	}
	


	public boolean checkStatus() {
		return statusOn;
	}

	
	public void setStatusOn(boolean statusOn) {
		this.statusOn = statusOn;
	}

	public int getSprinklerId() {
		return sprinklerId;
	}

//	public void setSprinklerId(int sprinklerId) {
//		this.sprinklerId = sprinklerId;
//	}

	public int getGroupId() {
		return groupId;
	}

//	public void setGroupId(String string) {
//		
//		this.groupId = groupId;
//	}

	public int getStart_time_hours(int dayIndex) {
		return start_time_hours[dayIndex];
	}

	public void setStart_time_hours(int dayIndex, int value) {
		start_time_hours[dayIndex] = value;
	}

	public int getStart_time_min(int dayIndex) {
		return start_time_min[dayIndex];
	}

	public void setStart_time_min(int dayIndex, int value) {
		start_time_min[dayIndex] = value;
	}

	public int getStop_time_hours(int dayIndex) {
		return stop_time_hours[dayIndex];
	}

	public void setStop_time_hours(int dayIndex, int value) {
		this.stop_time_hours[dayIndex] = value;
	}

	public int getStop_time_min(int dayIndex) {
		return stop_time_min[dayIndex];
	}

	public void setStop_time_min(int dayIndex, int value) {
		stop_time_min[dayIndex] = value;
	}

//	public int getDuration(int dayIndexay) {
//		return duration[day];
//	}
//
//	public void setDuration(int dayIndex, int value) {
//		duration[day] = value;
//	}

	
	
	
	
	
	
	
}
