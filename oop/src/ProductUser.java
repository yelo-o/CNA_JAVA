import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.my.product.dto.Product;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.RemoveException;
import com.my.product.dao.ProductRepository;

public class ProductUser{
	static Scanner sc = new Scanner(System.in);
	ProductRepository repository = new ProductRepository(); 
	
	public void findAll() {
		System.out.println(">>전체상품검색<<");
//		Product[] resultArr;
		List<Product> resultList = new ArrayList<>();
		try {
			resultList = repository.selectAll();
			for(int i=0; i<resultList.size(); i++){
				resultList.get(i).print();
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void findByprodNo() {
		System.out.println(">>상품검색<<");
		System.out.print("상품번호를 입력하세요:");
		String noArg1 = sc.nextLine();//키보드로 입력받기
		System.out.print(noArg1 + " ");
//		System.out.println(repository.selectByProdNo(noArg1) == null? "상품이 없습니다": "상품이 있습니다");
		//TODO
		//상품이 존재하면 상품번호, 상품명, 가격을 출력하시오
		Product p;
		try {
			p = repository.selectByProdNo(noArg1);
			if(p != null) {
				p.print();
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void findByProdName() {
		System.out.println(">>상품이름 검색<<");
		System.out.print("단어를 입력하세요 단어를 포함한 상품명으로 검색합니다:");
		String word = sc.nextLine();//키보드로 입력받기
//		System.out.print(word + " ");
//		Product[] pArr;
		List<Product> pList = new ArrayList<>();
		
		try {
			pList = repository.selectByProdName(word);
			for(Product p: pList) {
				p.print();
			}
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
	
	public void add(){
		System.out.println(">>상품추가<<");
		System.out.print("상품번호를 입력하세요:");
		String prodNo = sc.nextLine();
		
		System.out.println("상품명을 입력하세요:");
		String prodName = sc.nextLine();
		
		System.out.println("상품가격을 입력하세요:");
		int prodPrice = Integer.parseInt(sc.nextLine());
		
		Product pArg = new Product(prodNo,prodName,prodPrice);
		
		try {
			repository.insert(pArg);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
	
	public void modify() {
		System.out.println(">>상품수정<<");
		System.out.print("수정할 상품번호를 입력하세요:");
		String chNo = sc.nextLine();
		
		System.out.print("변경후 상품번호를 입력하세요:");
		String prodNo = sc.nextLine();
		
		System.out.println("변경후 상품명을 입력하세요:");
		String prodName = sc.nextLine();
		
		System.out.println("변경후 상품가격을 입력하세요:");
		int prodPrice = Integer.parseInt(sc.nextLine());
		repository.fix(chNo, prodNo, prodName, prodPrice);
	}
	
	public void erase() {
		System.out.println(">>상품삭제<<");
		System.out.print("상품번호를 입력하세요:");
		String prodNo = sc.nextLine();
		try {
			repository.delete(prodNo);
		} catch (RemoveException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args){
		
		ProductUser user = new ProductUser();
		String opt;
		do{
			System.out.println(">>작업을 선택하세요<<");
			System.out.print("1:상품전체검색,  2:상품번호로검색, 3: 상품추가, 4: 상품이름으로 검색 , 5: 상품수정, 6: 상품삭제, 9: 종료");
			opt = sc.nextLine();//키보드로 입력받기
			if(opt.equals("1")){
				user.findAll();
				
			}else if(opt.equals("2")){
				user.findByprodNo();

			}else if(opt.equals("3")){
				user.add();
				
			}else if(opt.equals("4")){
				user.findByProdName();
				
			}else if(opt.equals("5")){
				user.modify();
				
			}else if(opt.equals("6")){
				user.erase();
			}else if(opt.equals("9")){
			}else{
				System.out.println("잘못입력하셨습니다");
			}
		}while(!opt.equals("9"));

	}
}