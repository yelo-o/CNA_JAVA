package com.my.product.dao;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.RemoveException;
import com.my.product.dto.Product;

public class ProductRepository{
	//	private Product[] pArr;
	//	private int totalCnt = 0; // 저장소에 저장된 상품수
	private List<Product> pList;
	
	public ProductRepository() {
		pList = new ArrayList<>();
	}

	/**
	 * 상품을 저장소에 추가한다
	 * @param p 저장할 상품
	 * @throws AddException 
	 * 	상품번호가 존재할 경우 "이미 존재하는 상품입니다" 메시지를 갖는 예외 발생
	 */
	public void insert(Product p) throws AddException{
		// 중복확인
		for(int i=0; i<pList.size();  i++) {
			Product p1 = pList.get(i); //저장소의 상품
			String p1ProdNo = p1.getProdNo(); //저장소 상품의 상품번호
			String pProdNo = p.getProdNo(); //저장하려는 상품의 상품번호
			if(pProdNo.equals(p1ProdNo)) {
				//if(p.getProdNo().equals(pArr[i].getProdNo())) {
				//    			System.out.println("이미 존재하는 상품입니다");
				//    			return;
				throw new AddException("이미 존재하는 상품입니다"); //강제 예외 발생
			}
		}
		pList.add(p);
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
		for(int i=0; i<pList.size(); i++){
			Product p = pList.get(i);
			if(p.getProdNo().equals(no)){
				return p;
			}
		}
		throw new FindException("상품이 없습니다"); //강제 예외 발생
	}
	
	/**
	 * 모든 상품을 검색하여 반환한다
	 * @return 상품들
	 * @throws FindException
	 * 	
	 */
	public List<Product> selectAll() throws FindException{
//		Product[] all = new Product[pList.size()];
		List<Product> pListAll = new ArrayList<Product>();
		for(int i=0; i<pList.size(); i++){
			pListAll.add(pList.get(i));
		}
		return pListAll;
	}

	/**
	 * 상품번호에 해당 상품을 저장소에서 찾아 삭제한다
	 * @param prodNo 상품번호
	 * @throws com.my.exception.RemoveException
	 * 	상품번호에 해당 상품이 없을 경우 예외가 발생한다
	 */
	public void delete(String prodNo) throws RemoveException{
		int indexOfProdNo = 0; //  상품번호에 해당 상품의 위치
		for(int i=0; i<pList.size(); i++) {
			if(prodNo.equals(pList.get(i).getProdNo())){
				indexOfProdNo = i;
				break;
			}
		}
		if(indexOfProdNo == 0) {
			throw new RemoveException("상품이 없습니다");
		}else if(indexOfProdNo > 0) {
			pList.remove(indexOfProdNo);
		}
	}    


	/**
	 * 단어를 포함한 이름을 갖는 상품들을 반환한다
	 * @param word 단어
	 * @return 상품들
	 * @throws FindException
	 */
	public List<Product> selectByProdName(String word) throws FindException{
//		Product[] all;
		List<Product> pListAll = new ArrayList<>();
		int cnt = 0; // 단어를 포함한 상품수
		for(int i=0;i<pList.size();i++) {
			Product p = pList.get(i);
			if (p.getProdName().indexOf(word) > -1) {
				cnt++;
			}
		}

//		pListAll = new Product[];
		int index = 0;
		for(int i=0;i<pList.size();i++) {
			Product p = pList.get(i);
			if(p.getProdName().indexOf(word) > -1) {
				pListAll.add(p);
				index++;
			}
		}
		return pListAll;
	}

	/**
	 * 상품번호를 받아 수정한다
	 * @param chNo 
	 * @param prodNo
	 * @param prodName
	 * @param prodPrice
	 */
	public void fix(String chNo, String prodNo, String prodName, int prodPrice) {
		for(int i=0; i<pList.size();i++) {
			if(pList.get(i).getProdNo().equals(chNo)){
				pList.get(i).setProdNo(prodNo);
				pList.get(i).setProdName(prodName);
				pList.get(i).setProdPrice(prodPrice);
			}
		}
	}

} 