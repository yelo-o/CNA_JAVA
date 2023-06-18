package com.mango.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mango.dto.Review;
import com.mango.exception.AddException;
import com.mango.exception.RemoveException;
import com.mango.exception.FindException;

public class ReviewController {
	private String fileName;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	int cnt = 0;
	
	public ReviewController() {
		fileName = "..\\reviews.dat";
	}
	
	public void insert(Review r) throws AddException{
		//입력 <- 리뷰는 중복될게 없어서 솔직히 필요 없어보임
//		try {
//			dis = new DataInputStream(new FileInputStream(fileName)) ;
//			String reviewContent = dis.readUTF();
//			int rating = dis.readInt();
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (EOFException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(dis != null) {
//				try {
//					dis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		//출력
		try {
			dos = new DataOutputStream(new FileOutputStream(fileName, true)) ;
			dos.writeUTF(r.getReviewContent());
			dos.writeInt(r.getRating());
			dos.writeUTF(r.getReviewDateTime());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dos!=null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<Review> selectAll() throws FindException{
		List<Review> rListAll = new ArrayList<>();
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			while(true) {
				String reviewContent = dis.readUTF();
				int rating = dis.readInt();
				String reviewDateTime = dis.readUTF();
				rListAll.add(new Review(reviewContent, rating, reviewDateTime)); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dis!=null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return rListAll;
	}

}
