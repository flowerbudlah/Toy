package global.sesoc.ui;

import java.util.Scanner;

import global.sesoc.manager.ToyManagerMgr;

public class ToyManagerUI {

	Scanner input = new Scanner(System.in);
	ToyManagerMgr manager = new ToyManagerMgr(); //Service = Manager
	
	//생성자
	public ToyManagerUI() {
		int mNum = 0; 
		
		while(true) {
			
			mainMenu(); 
			mNum = input.nextInt(); 
			
			switch(mNum){
				case 1: insertToy(); break; 
				case 2: searchToy(); break; 
				case 3: deleteToy(); break; 
				case 4: searchForPrice(); break;
				case 5: printToyInfo(); break;
				case 9: System.out.println("This program will be closed after saving the data.");
				default: 
					
					
					
			}
		}
	
		
		
	}
	
	//주 메뉴 출력 메서드
	public void mainMenu() {
		// TODO Auto-generated method stub
		System.out.println("\n===== 장난감 정보 출력 =====");
		System.out.println("1. 전체 출력");
		System.out.println("2. 자전거 정보 출력");
		System.out.println("3. 드론 정보 출력");
		System.out.println("4. 게임콘솔 정보 출력");
		System.out.println("9. 상위 메뉴");
		System.out.print  ("[ 선택 ] ");
		
	}
	
	//장난감 객체를 생성해서 삽입하기 위한 메소드
	public void insertToy() {
		// TODO Auto-generated method stub
		
	}

	//고유번호에 해당하는 장난감을 검색하여 화면에 출력한다.
	public void searchToy() {
		// TODO Auto-generated method stub
			
	}
		
	//장난감의 시리얼번호를 입력받아 해당하는 장난감 정보를 삭제한다. 
	public void deleteToy() {
		// TODO Auto-generated method stub
			
	}
	
	
	public void searchForPrice() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void printToyInfo() {
		// TODO Auto-generated method stub
		
	}
	

}
