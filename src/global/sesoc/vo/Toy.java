package global.sesoc.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Toy implements Serializable {

	private String serialNum; //장난감 일련번호
	private String name; //장난감 이름
	private int price; //장난감 가격
	
	//상위메뉴의 Source > Generate Constructor using Field..(필드를 사용하는 생성자 만들기)
	public Toy(String serialNum, String name, int price) {
		super();
		this.serialNum = serialNum;
		this.name = name;
		this.price = price;
	}

	//상위메뉴의 Source > Generate getters and setters...
	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
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

	
	
	
	//상위메뉴의 Source > Generate toString()...
	@Override
	public String toString() {
		return "[고유번호 = " + serialNum + ", 이름 = " + name + ", 가격 = " + priceToString(price) + "원";
	}
	
	//3000000(integer) -> 3,000,000
	public String priceToString(int price) { //장난감의 가격을 숫자(Interger)에서 최종적으로 문자열로 변환하고자 
		String sPrice = Integer.toString(price); 
		ArrayList<String> pList = new ArrayList<>(); 
		
		for(int i=sPrice.length(); i>0; i-=3){
			String pricePart = null; 
			if(i<=3){
				pricePart = sPrice.substring(0, i);  
			} else {
				pricePart = sPrice.substring(i-3, i); 
			}
			pList.add(pricePart);
		}
		
		String newPrice = ""; 
		for(int i=pList.size()-1; i>=0; i--) {
			if(i==0) {	newPrice += pList.get(i);
			}else{	newPrice += pList.get(i) + ",";
			}
		}
		return newPrice;
	}
	
	
	
	
	
	
}
