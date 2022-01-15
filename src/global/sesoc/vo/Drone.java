package global.sesoc.vo;


public class Drone extends Toy{

	private int wingCount; //날개수

	public Drone(String serialNum, String name, int price, int wingCount) {
		super(serialNum, name, price);
		this.wingCount = wingCount;
	}

	public int getWingCount() {
		return wingCount;
	}

	public void setWingCount(int wingCount) {
		this.wingCount = wingCount;
	}

	@Override
	public String toString() {
		return "[드론]\t"+super.toString()+", 날개 수=" + wingCount +"]";
	}
	
	
}
