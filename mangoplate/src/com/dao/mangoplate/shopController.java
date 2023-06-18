package com.dao.mangoplate;
import java.util.Scanner;
import java.sql.*;
import com.dto.mangoplate.Shop;
import com.main.mangoplate.MangoPlate;

public class shopController {
	private Shop shop;
	Scanner sc = new Scanner(System.in);

	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement psmt = null;
	

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "kosta";
	String pw = "kosta";
	
	private static int count;
	
	public shopController(){
	}
	
	
	public shopController(Shop shop){


	}
public void ceo_page() {
		
		String shop_name;
		String shop_content;
		String shop_type;
		String shop_passwd;
		String confirm_passwd;
		
		System.out.println("가게 이름을 적어주세요.");
		shop_name = sc.nextLine();
		System.out.println("가게를 소개해주세요.");
		shop_content = sc.nextLine();
		System.out.println("식종을 적어주세요");
		shop_type = sc.nextLine();
		System.out.println("비밀번호를 적어주세요");
		shop_passwd = sc.nextLine();
		
		Shop shop = new Shop(shop_name, shop_content, shop_type, shop_passwd);
		shopController controller = new shopController();
		controller.insert(shop);
	}

	 public static int num_max() {
		String sql = "SELECT MAX(SHOP_NO) FROM SHOP";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
			
	 } 
	 //가게 등록 요청
	public void insert(Shop shop) {
		
		String sql = "insert into SHOP(Shop_no, shop_name, shop_state, shop_content, shop_type, shop_passwd) values (?,?,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count = num_max();
		shop.setShop_no(count);
		shop.setShop_state(false);
		
			try {
				psmt = con.prepareStatement(sql);
				psmt.setInt(1, shop.getShop_no());
				psmt.setString(2, shop.getShop_name());
				psmt.setBoolean(3, shop.getShop_state());
				psmt.setString(4, shop.getShop_content());
				psmt.setString(5, shop.getShop_type());
				psmt.setString(6, shop.getShop_passwd());
				psmt.executeUpdate();
				System.out.println("신청완료!");
			}catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("이미 존재하는 비밀번호 입니다.");
				System.out.println("저장되지않고 처음으로 돌아갑니다.");
			}catch (SQLException e) {
				System.out.println("구문입력 오류");
				e.printStackTrace();
			}
			finally{	
			}
			
		}
	//가게 정보 수정
	public void modify_shop() {
		String passwd;

		
		System.out.println("비밀번호를 입력해주세요. : ");
		passwd = sc.nextLine();
		String modify_sql = "select * from shop where shop_passwd = "+passwd;
		
		
		
		
	}
}



	