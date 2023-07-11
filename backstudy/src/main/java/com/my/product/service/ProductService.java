package com.my.product.service;

import java.util.List;

import com.my.exception.FindException;
import com.my.product.dao.ProductRepository;

public class ProductService {
	private ProductRepository repository;
	public ProductService() {
		repository = new ProductRepository();
	}

		public List<String> findAll(int currentPage) throws FindException{
			int cntPerPage = 4;

			int endRow = currentPage*cntPerPage;
			int startRow = endRow - cntPerPage + 1;
			return repository.selectAll(startRow, endRow);
		}

}
