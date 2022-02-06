package global.sesoc.manager;

import java.util.List;

import global.sesoc.vo.Toy;

public interface ToyManager {
	
	/*** 전달받은 Toy 객체를 List에 추가
	* @param list에 추가할 Toy객체
	* @return 추가여부 */
	public boolean insertToy(Toy toy);

	/** 제품의 일련 번호를 이용해 해당하는 제품이 있는지 찾는다.
	* @param serialNum 제품번호
	* @return 제품번호에 의해 검색된 제품 정보, 검색된 내용이 없을 경우 null이 리턴된다.*/
	public Toy searchToy(String serialNum);
	
	
	
	/*제품 번호를 이용해 해당 제품을 찾았을 경우 제품을 목록에서 삭제하고, 파일에 저장한 후 true릉 리턴한다.
	 * 제품번호를 찾지 못했을 경우 false를 리턴한다.
	 * @param serialNum
	 * @return 삭제 여부
	 */
	public boolean deleteToy(String serialNum);

	
	
	/**
	 * 최소금액과, 최대금액을 전달받아 해당하는 값을 전달받아 그 영역사이의 가격인 장난감을 리턴한다.
	 * @param 최소값, 최대값
	 * @return 지정한 금액 안에 존재하는 장난감의 목록 */
	public List<Toy> toyListForPrice(int minPrice, int maxPrice);

	/**
	 * 전달된 타입의 장난감 목록을 출력한다.
	 * @param 장난감 타입
	 * @return 검색된 장난감 목록 */
	public List<Toy> printToyInfo(int type);

	public void saveFile();//파일저장, 종료시 1회 저장
	
	public void loadFile();//파일로드, 시작시 1번 로드
}
