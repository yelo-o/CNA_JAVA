import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
	public static void test(File f) {
		String name = f.getName();
		System.out.print(name);
		
		boolean directory = f.isDirectory();
		if(directory) {
			System.out.println(" 디렉토리입니다");
			File[] files = f.listFiles();
			for(File subf : files) {
				String subName = subf.getName();
				if(subName.lastIndexOf(".jpg") != -1) {
					
				}
				System.out.println(subName);
				if(subf.isDirectory()) {
					System.out.println("폴더");
				}else {
					System.out.print("파일");
					long subLength = subf.length();
					System.out.println("크기 : " + subLength);
				}
			}
		}else {
			System.out.println("디렉토리 아닙니다");
			System.out.println("파일크기 : " + f.length()); 
			System.out.println(f.canWrite()? "쓰기 가능":"쓰기 금지"); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println("최종사용시간 : " + sdf.format(new Date(f.lastModified())));
//			System.out.println("최종사용시간 : " + sdf.format(f.lastModified()));
		}
	}
	public static void deleteTest(File f) {
		if(f.exists()) {
			if(f.delete()) {
				System.out.println(f.getName() + " 삭제 성공");
			}else {
				System.out.println(f.getName() + " 삭제 실패");
			}
		}else {
			System.out.println(f.getName() + " 없습니다");
		}
	}
	public static void createTest(File f) {
		if(!f.exists()) {
			try {
				if(f.createNewFile()) {
					System.out.println(f.getName() + " 생성 성공");
				}else {
					System.out.println("[" + f.getName() + "]"+ " 생성 실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("[" + f.getName() + "]"+ " 이미 있습니다");
		}
	}
	public static void pathTest(File f) {
		System.out.println("f.getName() : " + f.getName());
		System.out.println("f.getAbsolutePath() : " + f.getAbsolutePath());
		System.out.println("f.getParent() : " + f.getParent());
		System.out.println("f.getPath() : " + f.getPath());
		
	}
	public static void main(String[] args) {
		File f;
		f = new File("C:\\263\\CNA_JAVA");
		test(f);
		
		f = new File("C:\\Users\\김민규\\Documents\\카카오톡 받은 파일\\이름 없는 노트북.pdf");
		test(f);
		
		f = new File("C:\\Users\\김민규\\Documents\\카카오톡 받은 파일\\이름 없는 노트북.pdf");
		deleteTest(f);
		
		f = new File("C:\\263\\CNA_JAVA\\test.txt");
		createTest(f);
		
		pathTest(f);
		pathTest(new File("."));
	}

}
