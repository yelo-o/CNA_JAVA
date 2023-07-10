package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String aFileRealPath;
	private String developer;
       
    public A() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
  		super.init(config);
  		ServletContext sc = this.getServletContext();
  		developer = sc.getInitParameter("developer");

  		String fileName = this.getInitParameter("fileName");
  		//		aFileRealPath = sc.getRealPath("a.txt"); //이런식으로 직접 쓰는 것보다
  		aFileRealPath = sc.getRealPath(fileName); //web.xml 파일의 파라미터값을 가져오는게 좋다.
  		System.out.println("a.txt 파일의 실제경로 : " + aFileRealPath);
  		System.out.println("init() 호출됨");
  	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		System.out.println("doGet() 호출됨, 총개발자 : " + developer );
  		FileInputStream fis = null;
  		try {
  			fis = new FileInputStream(aFileRealPath);
  			Scanner sc = new Scanner(fis);
  			while(sc.hasNextLine()) {
  				System.out.println(sc.nextLine());
  			}
  		}catch(IOException e) {
  			e.printStackTrace();
  		}finally {
  			if(fis != null) {
  				try {
  					fis.close();
  				}catch(Exception e) {
  				}
  			}
  		}
  	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
