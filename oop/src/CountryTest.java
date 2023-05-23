import com.my.asia.Japan;
import com.my.asia.Korea; // com.my.*.Korea; 안됨 (정확히 써야 함)
import com.my.europe.France;

public class CountryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		com.my.asia.Korea k;
		k = new com.my.asia.Korea();
		
		Korea k1 = new Korea();
		France f = new France();
		Japan j = new Japan();
		
//		k1.capital = "서울";
//		k1.capital = "평양";
//		k1.language = "일본어";
//		k1.population = -1;
		
		k1.print();
		k1.down();
		k1.print();
		k1.down();
		k1.print();
		k1.down();
		k1.print();
	}

}
