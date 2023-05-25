import java.util.Scanner;
import com.my.product.dto.Product;
import com.my.product.dao.ProductRepository;

public class ProductUser{
	static Scanner sc = new Scanner(System.in);
	ProductRepository repository = new ProductRepository(3); 
	
	public void findAll() {
		System.out.println(">>전체상품검색<<");
		Product[]resultArr = repository.selectAll();
		for(int i=0; i<resultArr.length; i++){
			resultArr[i].print();
		}

	}
	public void findByprodNo() {
		System.out.println(">>상품검색<<");
		System.out.print("상품번호를 입력하세요:");
		String noArg1 = sc.nextLine();//키보드로 입력받기
		System.out.print(noArg1 + " ");
		System.out.println(repository.selectByProdNo(noArg1) == null? "상품이 없습니다": "상품이 있습니다");
		//TODO
		//상품이 존재하면 상품번호, 상품명, 가격을 출력하시오
		Product p = repository.selectByProdNo(noArg1);
		if(p != null) {
			p.print();
		}
	}
	public void findByProdName() {
		System.out.println(">>상품이름 검색<<");
		System.out.print("단어를 입력하세요 단어를 포함한 상품명으로 검색합니다:");
		String word = sc.nextLine();//키보드로 입력받기
//		System.out.print(word + " ");
		Product[] pArr = repository.selectByProdName(word);
		for(Product p: pArr) {
			p.print();
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
		repository.insert(pArg);
	}
	
	public void modify() {
		System.out.println(">>상품수정<<");
		System.out.print("상품번호를 입력하세요:");
		String prodNo = sc.nextLine();
		repository.fix(prodNo);
	}
	
	public void delete() {
		System.out.println(">>상품삭제<<");
		System.out.print("상품번호를 입력하세요:");
		String prodNo = sc.nextLine();
		repository.erase(prodNo);
		
		
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
				user.delete();
			}else if(opt.equals("9")){
			}else{
				System.out.println("잘못입력하셨습니다");
			}
		}while(!opt.equals("9"));

	}
}