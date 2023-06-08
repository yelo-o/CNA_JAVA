package com.my.product.dao;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.RemoveException;
import com.my.product.dto.Product;

public class ProductRepository{
	private String fileName;
	public ProductRepository() {
		fileName = "..\\products.dat";
	}

	/**
	 * 상품을 저장소에 추가한다
	 * @param p 저장할 상품
	 * @throws AddException 
	 * 	상품번호가 존재할 경우 "이미 존재하는 상품입니다" 메시지를 갖는 예외 발생
	 */
	public void insert(Product p) throws AddException{
		/*
		 * 상품중복확인
		 * products.dat 파일을 자료형별로 읽기
		 * 자원 : products.dat 파일
		 * 노드스트림 : FileInputStream
		 * 필터스트림 : DataInputStream
		 */
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			String prodNo = dis.readUTF();
			String prodName = dis.readUTF();
			int prodPrice = dis.readInt();
			if(prodNo.equals(p.getProdNo())) {
				throw new AddException("이미 존재하는 상품입니다");
			}
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		/*
		 * products.dat파일에 상품정보(상품번호, 상품명, 가격)를 자료형별로 쓰기
		 * 목적지 : product.dat 파일
		 * 노드스트림 : FileOutputStream
		 * 필터스트림 : DataOutputStream
		 */
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(fileName, true));
			dos.writeUTF(p.getProdNo());
			dos.writeUTF(p.getProdName());
			dos.writeInt(p.getProdPrice());
		} catch (FileNotFoundException e) { //데이터 쓰기에서 FileNotFoundException 이 발생하는 경우? -> 저장소 이름이 다른 경우 D드라이브, E드라이브 등..
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
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
		
		for(int i=0 ; i < selectAll().size() ; i++){
			Product p = selectAll().get(i);
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
	 */
	public List<Product> selectAll() throws FindException{
		List<Product> pListAll = new ArrayList<>();
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			while(true) { //파일을 읽어서 Product에 넣음
				String prodNo = dis.readUTF();
				String prodName = dis.readUTF();
				int prodPrice = dis.readInt();
				pListAll.add(new Product(prodNo,prodName,prodPrice)); //파일로부터 읽은 번호,이름,가격을 pListAll이라는 리스트에 넣음 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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