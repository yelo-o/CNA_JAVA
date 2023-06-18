import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.mango.dao.ReviewController;
import com.mango.dto.Review;
import com.mango.exception.AddException;
import com.mango.exception.FindException;

public class MangoTest {
	static Scanner sc = new Scanner(System.in);
	ReviewController controller = new ReviewController();
	
	//1. 모든 리뷰 보여주기
	public void serachAll() {
		System.out.println("[모든 리뷰 검색]");
		List<Review> resultList = new ArrayList<>();
		try {
			resultList = controller.selectAll();
			for(int i=0; i<resultList.size(); i++) {
				resultList.get(i).print();
			}
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
	//2. 작성자로 리뷰 검색
	public void searchByWriter() {
		System.out.println("[작성자로 리뷰 검색]");
	}
	//3. 리뷰 작성
	public void writeReview() {
		System.out.println("[리뷰 작성]");
		System.out.println("리뷰 내용을 입력하세요");
		String reviewContent = sc.nextLine();
		
		System.out.println("별점을 입력하세요 (1 ~ 5점)");
		int rating = Integer.parseInt(sc.nextLine());
		if(rating < 1 || rating > 5) {
			System.out.println("다시 입력하세요");
		}
		LocalDateTime now = LocalDateTime.now();
		String reviewDateTime = now.format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"));
		
		Review r = new Review(reviewContent, rating, reviewDateTime);
		try {
			controller.insert(r);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
	//4. 리뷰 수정
	public void modifyReview() {
		System.out.println("[리뷰 수정]");
		
	}
	//5. 리뷰 삭제
	public void deleteReview() {
		System.out.println("[리뷰 삭제]");
	}

	public static void main(String[] args) {
		MangoTest user = new MangoTest();
		String opt;
		do{
			System.out.println(">>작업을 선택하세요<<");
			System.out.print("1:전체리뷰검색,  2:작성자로검색, 3: 리뷰작성,"
					+ " 4: 리뷰수정, 5: 리뷰삭제, 9: 종료");
			opt = sc.nextLine();//키보드로 입력받기
			
			if(opt.equals("1")){
				user.serachAll();
				
			}else if(opt.equals("2")){
				user.searchByWriter();

			}else if(opt.equals("3")){
				user.writeReview();
				
			}else if(opt.equals("4")){
				user.modifyReview();
				
			}else if(opt.equals("5")){
				user.deleteReview();
				
			}else if(opt.equals("9")){
			}else{
				System.out.println("잘못입력하셨습니다");
			}
		}while(!opt.equals("9"));
	}

}
