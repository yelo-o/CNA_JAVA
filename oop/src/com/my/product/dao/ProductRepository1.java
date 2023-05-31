package com.my.product.dao;
import com.my.product.dto.Product;
public class ProductRepository1{
	private Product[] pArr;
	private int totalCnt = 0; // 저장소에 저장된 상품수
	/**
	 * 최대 5개의 상품이 저장될 수 있는 저장소를 만든다.
	 */
	//생성자
	public ProductRepository1() {
		this.pArr = new Product[5];
	}
	/**
	 * 저장소를 만든다
	 * @param maxSize 최대상품수
	 */
	public ProductRepository1(int maxSize) {
		if(maxSize <= 0) {
			System.out.println("저장소의 크기는 1이상이어야합니다, 크기를 최소값인 5로 수정합니다");
			maxSize = 5;
		}	
		pArr = new Product[maxSize];
	}
	
	/**
	 * 상품을 저장소에 추가한다
	 * 상품번호가 존재할 경우 "이미 존재하는 상품입니다" 메시지를 갖는 예외 발생
	 * @param p 저장할 상품
	 */
	public void insert(Product p) {
		//예외처리방법 1 앞단에서 totalCnt & 배열 길이 확인
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
    			System.out.println("이미 존재하는 상품입니다");
    			return;
    		}
    	}
		//예외처리방법 2 뒷단에서
		try {
//			pArr[totalCnt++] = p; //Bad Code
			pArr[totalCnt] = p; //Good Code
			totalCnt++;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("저장소가 꽉찼습니다. 현재 상품수는 " + totalCnt + "입니다");
		}
	}

	public void erase(String no) {
		//		int index = totalCnt;
		int idx = 0;
		for (int i=0; i<totalCnt;i++) {
			if (pArr[i].getProdNo().equals(no)) {
				idx = i;
				for(idx=i+1;idx<totalCnt;idx++)
				pArr[idx-1] = pArr[idx];
				totalCnt--;
			}
		}
	}

	public Product selectByProdNo(String no){
		//상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다
		for(int i=0; i<totalCnt; i++){
			Product p = pArr[i];
			if(p.getProdNo().equals(no)){ //==는 기본자료형(숫자,문자,논리)값 비교시 사용한다
				//equals()는 문자열(String)값 비교시 사용한다
				return p;
			}
		}
		return null; //상품이 없는 경우 null을 반환한다
	}

	public Product[] selectByProdName(String word){
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

	public void fix(String chNo, String prodNo, String prodName, int prodPrice) {
		for(int i=0; i<totalCnt;i++) {
			if(pArr[i].getProdNo().equals(chNo)){
				pArr[i].setProdNo(prodNo);
				pArr[i].setProdName(prodName);
				pArr[i].setProdPrice(prodPrice);
			}
		}
	}

	public Product[] selectAll(){
		Product[] all = new Product[totalCnt];
		for(int i=0; i<totalCnt; i++){
			all[i] = pArr[i];
		}
		return all;
	}
} 