package global.sesoc.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

public class ToyManagerMgr implements ToyManager {
	private final String FILE_NAME="toy.dat";
	private List<Toy> toyList;			// 각종 Toy 정보를 담을 리스트

	private FileInputStream fis;		// 파일을 읽기 위한 객체
	private FileOutputStream fos;		// 파일을 쓰기 위한 객체
	private ObjectInputStream ois;		// 객체를 읽기 위한 객체
	private ObjectOutputStream oos;		// 객체를 쓰기 위한 객체
	
	public ToyManagerMgr() {
		this.loadFile(); 
	}
	
	@Override
	public boolean insertToy(Toy toy) { //장난감 등록
		return this.toyList.add(toy);
	}
	
	@Override
	public Toy searchToy(String serialNum) { //일련번호를 넣어서 장난감 찾기
		int idx = -1;
		for(int i = 0 ; i < this.toyList.size(); i++) {
			if(this.toyList.get(i).getSerialNum().equals(serialNum)) {
				idx = i;  break;
			}
		}
		if(idx < 0) return null;
		else return this.toyList.get(idx);
	}
	
	
	@Override
	public boolean deleteToy(String serialNum) { //제품 고유번호를 넣어서 장난감 정보를 삭제한다. 
		
		//1) 먼저 이 고유번호에 해당하는 장난감이 있는지 찾아본다. 
		int idx = -1;
		for(int i = 0 ; i < this.toyList.size(); i++) {
			if(this.toyList.get(i).getSerialNum().equals(serialNum)) {
				idx = i;  break;
			}
		}
		
		if(idx < 0) { // (1) 장난감 못찾았다. 
			System.out.print("입력하신 장난감이 존재하지 않아 삭제할 수가 없습니다. ");
			return false;	
		
		} else {// (2) 장난감 찾았다. 
			System.out.println(this.toyList.get(idx));
			System.out.println("입력하신 장난감이 위와같이 존재하며, 삭제하겠습니다. ");
			return this.toyList.remove(this.toyList.get(idx)); 
		
		}
		
	}
	
	

	
	/*** 최소금액과, 최대금액을 전달받아 해당하는 값을 전달받아 그 영역사이의 가격인 장난감을 리턴한다.
	 * @param 최소값, 최대값
	 * @return */
	@Override
	public List<Toy> toyListForPrice(int minPrice, int maxPrice) {
		ArrayList<Toy> printList = new ArrayList<Toy>();
		
		for(int i=0; i<this.toyList.size(); i++) {
			if(minPrice <= this.toyList.get(i).getPrice() && this.toyList.get(i).getPrice() <= maxPrice) 
				printList.add(this.toyList.get(i)); 
		}
		return printList;
		
		
	}

	
	
	
	@Override
	public List<Toy> printToyInfo(int type) {
		ArrayList<Toy> printList = new ArrayList<Toy>();
		
		if(type == 1) { //1. 전체출력인 경우, 
			for(int i = 0 ; i < this.toyList.size() ; i++) {
				printList.add(this.toyList.get(i));
			}
		} else if(type == 2){ //2. 자전거 인경우, 
			for(int i = 0 ; i < this.toyList.size() ; i++) {
				if(this.toyList.get(i) instanceof Bicycle) {
					printList.add(this.toyList.get(i));
				}
			}
		} else if(type == 3) { //3. 드론인 경우, 
			for(int i = 0 ; i < this.toyList.size() ; i++) {
				if(this.toyList.get(i) instanceof Drone) {
					printList.add(this.toyList.get(i));
				}
			}	
		} else if(type == 4) { //4. 게임 콘솔인 경우, 
			for(int i = 0 ; i < this.toyList.size() ; i++) {
				if(this.toyList.get(i) instanceof GameConsole) {
					printList.add(this.toyList.get(i));
				}
			}
		}
		return printList;
	}

	@Override
	public void saveFile() {   //직렬화
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(this.FILE_NAME);
			oos = new ObjectOutputStream(fos); 
			oos.writeObject(this.toyList);
		}catch(IOException ex) {
			System.out.println(ex);
		}finally {
			try {
				if(fos != null) fos.close();
				if(oos != null) oos.close();
			}catch(IOException ex){}
		}
	}
	
	
	
	
	@Override
	public void loadFile() {   //역직렬화
		File file = new File(this.FILE_NAME);
		try {
			if(file.exists()) {
				this.fis = new FileInputStream(file);
				this.ois = new ObjectInputStream(this.fis);
				this.toyList = (ArrayList<Toy>)this.ois.readObject();
			}else {
				file.createNewFile();   //없으면 새로 생성하기
				this.toyList = new ArrayList<Toy>();
			}
		}catch(IOException ex) {
			System.out.println(ex);
		}catch(ClassNotFoundException ex){
			System.out.println(ex);
		}finally {
			try {
				if(fis != null) fis.close();
				if(ois != null) ois.close();
			}catch(IOException ex) {}
		}
	}
	
}

