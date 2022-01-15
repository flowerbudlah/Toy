package global.sesoc.vo;

public class GameConsole extends Toy{

	private boolean isPortable;

	public GameConsole(String serialNum, String name, int price, boolean isPortable) {
		super(serialNum, name, price);
		this.isPortable = isPortable;
	}

	public boolean isPortable() {
		return isPortable;
	}

	public void setPortable(boolean isPortable) {
		this.isPortable = isPortable;
	} 
	
	
	
	@Override
	public String toString() {
		
		String portable = null; 
		
		if(isPortable) {
			portable = "Y";  
		} else {
			portable = "N"; 
		}
		return "[게임콘솔]\t"+super.toString()+", 휴대용="+portable+"]";
	}

	
	
	
	
}
