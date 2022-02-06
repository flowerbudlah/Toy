package global.sesoc.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Toy implements Serializable {
	private String serialNum;
	private String name;
	private int price;

	
	public Toy(String serialNum, String name, int price) {
		super();
		this.serialNum = serialNum;
		this.name = name;
		this.price = price;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	
	
	@Override
	public String toString() {
		return "[고유번호 = " + serialNum + ", 이름 = " + name + ", 가격 = " + priceToString(price) + "원";
	}
	
	
	public String priceToString(int price) {
		String sPrice = Integer.toString(price);
		ArrayList<String> pList = new ArrayList<>();
		for(int i = sPrice.length(); i > 0; i-=3) {
			String pricePart = null;
			if(i <= 3) {
				pricePart = sPrice.substring(0, i);
			}
			else {
				pricePart = sPrice.substring(i-3, i);
			}
			pList.add(pricePart);
		}
		
		String newPrice = "";
		for(int i = pList.size() -1; i >= 0; i--) {
			if(i == 0) {
				newPrice += pList.get(i);
			}
			else {
				newPrice += pList.get(i) + ",";
			}
		}
		return newPrice;
	}
}

