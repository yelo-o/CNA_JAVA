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
		fileName = "..\\reviews.txt";
	}

	public void insert(Review r) throws AddException{
		//출력
		try {
			cnt++;
			dos = new DataOutputStream(new FileOutputStream(fileName, true)) ;
			dos.writeUTF(r.getReviewContent());
			dos.writeInt(r.getRating());
			dos.writeUTF(r.getReviewDateTime());
			//			dos.writeInt(r.getReviewNo());
			r.setReviewNo(cnt); //cnt값을 reviewNo로 셋팅
			dos.writeInt(r.getReviewNo());

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
				//파일로부터 읽기
				String reviewContent = dis.readUTF(); //리뷰내용 읽기
				int rating = dis.readInt(); //리뷰점수 읽기
				String reviewDateTime = dis.readUTF(); //리뷰시간 읽기
				int reviewNo = dis.readInt(); //리뷰번호 읽기

				//읽은 데이터들을 매개변수로 하여 rListAll에 리뷰객체 추가하기
				Review re = new Review(reviewContent, rating, reviewDateTime, reviewNo);
				//				re.getReviewNo();
				rListAll.add(re); 
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

	public void delete(int deleteNo) throws RemoveException {
		List<Review> rList = new ArrayList<>();
		//파일에 재구성하여 입력
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			while(true) {
				String reviewContent = dis.readUTF(); //리뷰내용 읽기
				int rating = dis.readInt(); //리뷰점수 읽기
				String reviewDateTime = dis.readUTF(); //리뷰시간 읽기
				int reviewNo = dis.readInt(); //리뷰번호 읽기
				if(reviewNo == deleteNo) {
					continue;
				}
				rList.add(new Review(reviewContent, rating, reviewDateTime, reviewNo));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(EOFException e) {
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
		//rList의 데이터 파일에 쓰기
		try {
			dos = new DataOutputStream(new FileOutputStream(fileName, false)); //소켓을 다시 열어줘야 하므로 다시 선언
			for(Review r : rList) {
				dos.writeUTF(r.getReviewContent());
				dos.writeInt(r.getRating());
				dos.writeUTF(r.getReviewDateTime());
				dos.writeInt(r.getReviewNo());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
