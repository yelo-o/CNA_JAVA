/**
 * 배열 사용
 */
package com.my.product.dao;
import com.my.product.dto.Product;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.RemoveException;
public class ProductRepository2{
	private Product[] pArr;
	private int totalCnt = 0; // 저장소에 저장된 상품수
	/**
	 * 최대 5개의 상품이 저장될 수 있는 저장소를 만든다.
	 */
	//생성자
	public ProductRepository2() {
		this.pArr = new Product[5];
	}
	/**
	 * 저장소를 만든다
	 * @param maxSize 최대상품수
	 */
	public ProductRepository2(int maxSize) {
		if(maxSize <= 0) {
			System.out.println("저장소의 크기는 1이상이어야합니다, 크기를 최소값인 5로 수정합니다");
			maxSize = 5;
		}	
		pArr = new Product[maxSize];
	}

	/**
	 * 상품을 저장소에 추가한다
	 * @param p 저장할 상품
	 * @throws AddException 
	 * 	상품번호가 존재할 경우 "이미 존재하는 상품입니다" 메시지를 갖는 예외 발생
	 * 	저장소가 꽉찼을 경우 "저장소가 꽉찼습니다. 현재상품수" 메시지를 갖는 예외
	 */
	public void insert(Product p) throws AddException{
		//		if(totalCnt >= pArr.length) {
		//			System.out.println("저장소가 꽉찼습니다. 현재 상품수는 " + totalCnt + "입니다");
		//			return;
		//		}
		// 중복확인
		for(int i=0; i<totalCnt;  i++) {
			Product p1 = pArr[i]; //저장소의 상품
			String p1ProdNo = p1.getProdNo(); //저장소의 상품의 상품번호
			String pProdNo = p.getProdNo(); //저장하려는 상품의 상품번호
			if(pProdNo.equals(p1ProdNo)) {
				//if(p.getProdNo().equals(pArr[i].getProdNo())) {
				//    			System.out.println("이미 존재하는 상품입니다");
				//    			return;
				throw new AddException("이미 존재하는 상품입니다"); //강제 예외 발생
			}
		}
		try {
			//			pArr[totalCnt++] = p; //Bad Code <-catch 되기 전에 수가 증가해버림
			pArr[totalCnt] = p; //Good Code
			totalCnt++;
		}catch(ArrayIndexOutOfBoundsException e) {
			//			System.out.println("저장소가 꽉찼습니다. 현재 상품수는 " + totalCnt + "입니다");
			throw new AddException("저장소가 꽉찼습니다. 현재 상품수는 " + totalCnt + "입니다"); //강제 예외 발생
		}
	}

	/**
	 * 상품번호에 해당 상품을 저장소에서 찾아 삭제한다
	 * @param prodNo 상품번호
	 * @throws com.my.exception.RemoveException
	 * 	상품번호에 해당 상품이 없을 경우 예외가 발생한다
	 */
	public void delete(String prodNo) throws RemoveException{
		int idx = 0;
		for (int i=0; i<totalCnt;i++) {
			if (pArr[i].getProdNo().equals(prodNo)) {
				idx = i;
				for(idx=i+1;idx<totalCnt;idx++)
					pArr[idx-1] = pArr[idx];
				totalCnt--;
			}
		}
		if(idx==0) {
			throw new RemoveException("상품이 없습니다");
		}


		//		int indexOfProdNo = 0; //  상품번호에 해당 상품의 위치
		//    	for(int i=0; i<totalCnt; i++) {
		//    		if(prodNo.equals(pArr[i].getProdNo())){
		//    			indexOfProdNo = i;
		//    			break;
		//    		}
		//    	}
		//    	if(indexOfProdNo == 0) {
		//    		throw new RemoveException("상품이 없습니다");
		//    	}
		//    	//상품위치부터 다음상품을 앞으로 땡겨넣기
		//    	for(int i=indexOfProdNo; i<totalCnt-1; i++) {
		//    		pArr[i] = pArr[i+1];
		//    	}
		//    	//상품번호에 해당 상품이 있으면 
		//    	if(indexOfProdNo > 0) { 
		//    		totalCnt--;
		//    	}
	}    

	/**
	 * 상품번호에 해당하는 상품을 저장소에서 찾아 반환한다
	 * @param no 상품번호
	 * @return 상품객체
	 * @throws FindException
	 * 	번호에 해당하는 상품이 없으면 "상품이 없습니다" 메시지를 갖는 예외 발생한다
	 */
	public Product selectByProdNo(String no) throws FindException{
		//상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다
		for(int i=0; i<totalCnt; i++){
			Product p = pArr[i];
			if(p.getProdNo().equals(no)){
				return p;
			}
		}
		throw new FindException("상품이 없습니다"); //강제 예외 발생
	}

	/**
	 * 단어를 포함한 이름을 갖는 상품들을 반환한다
	 * @param word 단어
	 * @return 상품들
	 * @throws FindException
	 */
	public Product[] selectByProdName(String word) throws FindException{
		Product[] all;
		int cnt = 0; // 단어를 포함한 상품수
		for(int i=0;i<totalCnt;i++) {
			Product p = pArr[i];
			if (p.getProdName().indexOf(word) > -1) {
				cnt++;
			}
		}

		all = new Product[cnt];
		int index = 0;
		for(int i=0;i<totalCnt;i++) {
			Product p = pArr[i];
			if(p.getProdName().indexOf(word) > -1) {
				all[index] = p;
				index++;
			}
		}
		return all;
	}

	/**
	 * 상품번호를 받아 수정한다
	 * @param chNo 
	 * @param prodNo
	 * @param prodName
	 * @param prodPrice
	 */
	public void fix(String chNo, String prodNo, String prodName, int prodPrice) {
		for(int i=0; i<totalCnt;i++) {
			if(pArr[i].getProdNo().equals(chNo)){
				pArr[i].setProdNo(prodNo);
				pArr[i].setProdName(prodName);
				pArr[i].setProdPrice(prodPrice);
			}
		}
	}

	/**
	 * 모든 상품을 검색하여 반환한다
	 * @return 상품들
	 * @throws FindException
	 * 	
	 */
	public Product[] selectAll() throws FindException{
		Product[] all = new Product[totalCnt];
		for(int i=0; i<totalCnt; i++){
			all[i] = pArr[i];
		}
		return all;
	}
} 