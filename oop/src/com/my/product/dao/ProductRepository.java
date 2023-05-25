package com.my.product.dao;
import com.my.product.dto.Product;
public class ProductRepository{
	//    private Product[] pArr = new Product[5]; // 상품 저장소
	private Product[] pArr;
	private int totalCnt = 0; // 저장소에 저장된 상품수
	//생성자
	public ProductRepository() {
		this.pArr = new Product[5];
	}
	public ProductRepository(int maxSize) {
		if(maxSize <= 0) {
			System.out.println("저장소의 크기는 1이상이어야합니다, 크기를 최소값인 5로 수정합니다");
			maxSize = 5;
		}	
		pArr = new Product[maxSize];
	}
	public void insert(Product p){
		/** TODO
		 * 저장소에 상품번호가 이미 존재하면
		 * "이미 존재하는 상품입니다" 출력하고
		 * 존재하지 않을 경우만 상품을 저장한다
		 */
		if(totalCnt >= pArr.length) {
			System.out.println("저장소가 꽉찼습니다. 현재 상품수는 " + totalCnt + "입니다");
			return;
		}
		pArr[totalCnt++] = p;
		// 중복확인
		for(int i=0;i<totalCnt;i++) {
			for(int j=0;j<i;j++) {
				if(pArr[i].getProdNo().equals(pArr[j].getProdNo())) {
					System.out.println("이미 존재하는 상품입니다");
					i--;
					return;
				}
			}
		}
		//        pArr[totalCnt] = p;
		//        totalCnt++;
	}

	public void erase(String prodNo) {
		// 기존 등록된 product 모든 정보 가져옴
		System.out.println("저장소에 저장된 totalCnt는 : " + totalCnt);
		Product[] all = new Product[totalCnt];
		for(int i=0; i<totalCnt; i++){
			all[i] = pArr[i];
		}
		// prodNo가 매칭되는 것 카운트
		int cnt = 0;
		int index = 0;
		for(int i=0;i<totalCnt;i++) {
			Product p = pArr[i];
			if (p.getProdNo().equals(prodNo)) {
				all[index] = p;
				index++;
				cnt++;
			}
		}
		System.out.println(all);
		/*
		// cnt에 맞는 배열 재생성
		all = new Product[cnt];
		for(int i=0;i<totalCnt;i++) {
			Product p = pArr[i];
			if(!p.getProdName().equals(prodNo)) {
				all[index] = p;
				index++;
			}
		}
		*/
//		return all;
			
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
	
	public Product fix(String no) {
		return null;
	}

	public Product[] selectAll(){
		Product[] all = new Product[totalCnt];
		for(int i=0; i<totalCnt; i++){
			all[i] = pArr[i];
		}
		return all;
	}
} 