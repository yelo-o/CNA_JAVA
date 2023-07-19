package com.my.product.service;

import java.util.List;

import com.my.exception.FindException;
import com.my.product.dao.ProductRepository;
import com.my.product.dto.Product;
import com.my.util.PageBean;

public class ProductService {
	private static ProductService service = new ProductService();
	private ProductRepository repository;
	public ProductService() {
		repository = new ProductRepository();
	}
	
	public static ProductService getInstance() {
		return service;
	}

	public Product findByProdNo(String prodNo) throws FindException{
		return repository.SelectByProdNo(prodNo);
	}
	/**
	 * 상품목록을 검색한다. 한 페이지당 최대4개의 상품을 검색한다
	 * @param currentPage 검색할 페이지
	 * @return 페이지에 해당하는 상품목록
	 * @throws FindException
	 */
	public com.my.util.PageBean<Product> findAll(int currentPage) throws FindException{
		int cntPerPage = 4;
		//ex) cp: 1, 2, 3
		int endRow = currentPage*cntPerPage;
		int startRow = endRow - cntPerPage + 1;
		
		List<Product> list = repository.selectAll(startRow, endRow);
		int totalCnt = repository.count(); //총 상품수
		
		int cntPerPageGroup = 3;
//		PageBean pb = new PageBean(); //롬복활용
//		pb.setCntPerPage(cntPerPage);
//		pb.setTotalCnt(totalCnt);
//		pb.setList(list);
//		pb.setCntPerPageGroup(cntPerPageGroup);
//		pb.setCurrentPage(currentPage);
		
		PageBean<Product> pb = new PageBean<>(cntPerPage, totalCnt, list,
				                   cntPerPageGroup, currentPage);
//		return repository.selectAll(startRow, endRow);
		return pb;
	}

}
